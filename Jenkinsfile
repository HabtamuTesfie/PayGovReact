pipeline {
    agent any

    triggers{
        bitbucketPush()
    }


    stages {
        stage ('Test & Build Artifact') {
             steps {
                bat './gradlew assemble docker'
            }
        }
}
}
