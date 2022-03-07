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
               
         bat 'docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker'
                
            }
        }

    }
}
