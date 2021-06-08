pipeline {
    agent {
        docker { image 'codehunters/gradle-awseb' }
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}