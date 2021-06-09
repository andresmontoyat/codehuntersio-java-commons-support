pipeline {
    agent {
        docker {
            image 'codehunters/gradle-awseb'
        }
    }

    stages {
        stage('Code Analysis') {
            steps {
               //put your code scanner
                echo 'Run jacoco '
                echo 'Run sonarqube'
            }

        }

        stage('Test') {
            steps {
               //put your code scanner
                echo 'Run junit '
            }

            post{
                success{
                    echo "Robot Testing Successfully"
                }
                failure{
                    echo "Robot Testing Failed"
                }
            }
        }

        stage('Build') {

            steps {
                sh 'mvn -v'
                sh 'Create docker image'
            }

            post{
                success{
                    echo "Build and Push Successfully"
                }
                failure{
                    echo "Build and Push Failed"
                }
            }
        }

        stage('Deploy develop environment') {
            when {
                branch 'develop'
            }

            steps {
                echo 'Develop'
            }
        }

        stage('Deploy master environment') {
            when {
                branch 'master'
            }

            steps {
                echo 'Master'
            }
        }
    }
}