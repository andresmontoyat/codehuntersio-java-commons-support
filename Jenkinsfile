pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb'
        }
    }

    stages {
        stage('Code Analysis') {
            steps {
                sh 'printenv'
                sh 'gradle sonarqube'
            }
        }

        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }
    }
}