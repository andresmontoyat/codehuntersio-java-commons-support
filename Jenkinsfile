pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb:jdk11'
        }
    }

    stages {
        stage('Cleanup Workspace') {
            steps {
                cleanWs()
                echo 'Cleaned Up Workspace'
            }
        }

        stage('Code Analysis') {
            steps {
                sh 'printenv'
                sh 'gradle clean build sonarqube'
            }
        }

    }
}