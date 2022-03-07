pipeline {
    agent any

    triggers{
        bitbucketPush()
    }


    stages {
        stage ('Test & Build Artifact') {
            agent {

            steps {
                bat './gradlew clean build'
            }
        }
        stage ('Build & Push docker image') {
            steps {
                withDockerRegistry(credentialsId: '9b38192f-91c0-4789-ac24-85baabb4e094', url: 'https://index.docker.io/v1/') {
                    bat 'docker push turkogluc/spring-jenkins-demo'
                }
            }
        }

    }
}
