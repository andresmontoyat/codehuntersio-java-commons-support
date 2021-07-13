pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb:jdk11'
        }
    }

    stages {

        stage('Code Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'printenv'
                    sh 'gradle clean build sonarqube'
                }
            }

            post{
                success {
                    echo('The build were executed successfully')
                }
                failure {
                    error('The build failed')
                }
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }
}