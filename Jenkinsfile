pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb'
        }
    }

    stages {
        stage('Code Analysis') {
            steps {
                sh 'gradle sonarqube'
            }
        }
    }
}