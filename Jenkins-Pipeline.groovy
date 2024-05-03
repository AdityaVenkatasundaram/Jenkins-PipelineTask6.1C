pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the code using Maven'

            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit tests'

                echo 'Running integration tests'

            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Integrating code analysis tool'
                echo 'Tool used: SonarQube'

            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan using OWASP Dependency-Check'

            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying application to staging server using AWS CLI'
                echo 'Tool used: AWS EC2'
 
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging environment'
                echo 'Tool used: Selenium'

            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying application to production server using AWS CLI'
                echo 'Tool used: AWS EC2'

            }
            post{
                success{
                    mail to: "adityacalvin@gmail.com",
                      body: "The deployment to production was successful.",
                      subject: "Pipeline Status: Success - Deploy to Production",
                      attachmentsPattern: '**/*.groovy'
                }
                failure {
                    mail to: "adityacalvin@gmail.com",
                      body: "The deployment to production has failed.",
                      subject: "Pipeline Status: Failure - Deploy to Production",
                      attachmentsPattern: '**/*.groovy'
                }
            }
        }
    }
}
