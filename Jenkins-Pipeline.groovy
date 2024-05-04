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
            post{
                success{
                    emailext{
                        subject: "Jenkins Build: ${current.Build.fullDisplayName}",
                        body: "The deployment to production was successful.",
                        to: "adityacalvin@gmail.com",
                        attachLog: true
                    } 
                }
                failure {
                    emailext{
                      subject: "Jenkins Build: ${current.Build.fullDisplayName}",
                      body: "The deployment to production has failed.",
                      to: "adityacalvin@gmail.com",
                      attachLog: true
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying application to production server using AWS CLI'
                echo 'Tool used: AWS EC2'

            }
            }

        }

    }
}

