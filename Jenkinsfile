pipeline {
    agent any

    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        stage('Compile') {
            steps {
                gradlew('clean', 'classes')
            }
        }
        stage('Unit Tests') {
            steps {
                gradlew('test')
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage('Long-running Verification') {
            environment {
                SONAR_LOGIN = credentials('3156ecd9c90dbee47c9718a7eb216b27ca24a2e3')
            }
            parallel {
                stage('Integration Tests') {
                    steps {
                        gradlew('integrationTest')
                    }
                    post {
                        always {
                            junit '**/build/test-results/integrationTest/TEST-*.xml'
                        }
                    }
                }
                stage('Code Analysis') {
                    steps {
                        gradlew('sonarqube')
                    }
                }
            }
        }
        stage('Assemble') {
            steps {
                gradlew('assemble')
                stash includes: '**/build/libs/*.war', name: 'app'
            }
        }
        stage('Promotion') {
            steps {
                timeout(time: 1, unit:'DAYS') {
                    input 'Deploy to Production?'
                }
            }
        }
        stage('Deploy to Production') {
            environment {
                HEROKU_API_KEY = credentials('928a90de-931a-47a2-8274-8f66d944a239')
            }
            steps {
                unstash 'app'
                gradlew('deployHeroku')
            }
        }
    }
    post {
        failure {
            mail to: 'habtamuarsenalbarca@gmail.com', subject: 'Build failed', body: 'Please fix!'
        }
    }
}

def gradlew(String... args) {
    bat "./gradlew ${args.join(' ')} -s"
}
