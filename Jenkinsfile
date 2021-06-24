pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb:jdk11'
        }
    }

    stages {

        stage('Code Analysis') {
            steps {
                sh 'printenv'
                sh 'gradle clean build sonarqube'
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}