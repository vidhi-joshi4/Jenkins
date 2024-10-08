pipeline {
    agent any 
    
    stages {
        stage('Build') {
            steps {
                echo "Build using Maven to compile and package"
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo "Unit tests: Ensuring code functions as expected"
                echo "Integration tests: Ensuring different components of the application work together as expected"
                echo "Unit and Integration tests are conducted using Appium"
            }
            post {
                always {
                    emailext (
                        body: 'Unit tests and Integration test have been successful',
                        subject: 'Unit tests and Integration tests outcome',
                        to: 'jenkinsdeakin@gmail.com',
                        attachLog: true  // Attach build log to email
                    )
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo "Analysing Code to ensure it meets industry standards."
                echo "Code Analysed using SonarQube"
            }
        }
        stage('Security Scan') {
            steps {
                echo "Conducting security scan"
                echo "Security scan completed using Burp Suite"
            }
            post {
                always {
                    emailext (
                        body: 'Security Scan was successful',
                        subject: 'Security Scan outcome',
                        to: 'jenkinsdeakin@gmail.com',
                        attachLog: true  // Attach build log to email
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo "Application will be deployed to staging server"
                echo "Staging server is AWS EC2"
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo "Running integration tests on the staging environment to ensure the application functions as expected in a production-like environment."
            }
        }
        stage('Deploy to Production') {
            steps {
                echo "Deploying the application"
                echo "Production Server used is AWS EC2"
            }
        }
    }

    post {
        always {
            emailext (
                subject: "Pipeline Status: ${currentBuild.result}",
                body: '''<html>
                            <body>
                                <p>Build Status: ${BUILD_STATUS}</p>
                                <p>Build Number: ${BUILD_NUMBER}</p>
                                <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
                            </body>
                        </html>''',
                to: 'jenkinsdeakin@gmail.com',
                from: 'jenkins@example.com', 
                replyTo: 'jenkins@example.com', 
                mimeType: 'text/html'
            )
        }
    }
}
