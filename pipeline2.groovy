pipeline {
    agent any 
    
    stages {
        stage('Build') {
            steps {
                script {
                    echo "Build using Maven to compile and package"
                    // Generate a build log
                    sh 'echo "Build log content" > build.log'
                }
            }
            post {
                always {
                    // Archive the build log
                    archiveArtifacts artifacts: 'build.log', allowEmptyArchive: true
                }
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                script {
                    echo "Unit tests: Ensuring code functions as expected"
                    echo "Integration tests: Ensuring different components of the application work together as expected"
                    echo "Unit and Integration tests are conducted using Appium"
                    // Generate test logs
                    sh 'echo "Unit and Integration test logs" > test.log'
                }
            }
            post {
                success {
                    // Send email with the test log attached
                    emailext(
                        to: "jenkinsdeakin@gmail.com",
                        subject: "Unit tests and Integration tests outcome",
                        body: "Unit tests and Integration test have been successful.",
                        attachmentsPattern: 'test.log'
                    )
                }
            }
        }
        stage('Code Analysis') {
            steps {
                script {
                    echo "Analysing Code to ensure it meets industry standards."
                    echo "Code Analysed using SonarQube"
                    // Generate code analysis logs
                    sh 'echo "Code analysis log" > code_analysis.log'
                }
            }
            post {
                always {
                    // Archive the code analysis log
                    archiveArtifacts artifacts: 'code_analysis.log', allowEmptyArchive: true
                }
            }
        }
        stage('Security Scan') {
            steps {
                script {
                    echo "Conducting security scan"
                    echo "Security scan completed using Burp Suite"
                    // Generate security scan logs
                    sh 'echo "Security scan log" > security_scan.log'
                }
            }
            post {
                success {
                    // Send email with the security scan log attached
                    emailext(
                        to: "jenkinsdeakin@gmail.com",
                        subject: "Security Scan outcome",
                        body: "Security Scan was successful.",
                        attachmentsPattern: 'security_scan.log'
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                script {
                    echo "Application will be deployed to staging server"
                    echo "Staging server is AWS EC2"
                    // Generate deployment logs
                    sh 'echo "Deployment to staging log" > deploy_staging.log'
                }
            }
            post {
                always {
                    // Archive the deployment log
                    archiveArtifacts artifacts: 'deploy_staging.log', allowEmptyArchive: true
                }
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                script {
                    echo "Running integration tests on the staging environment to ensure the application functions as expected in a production-like environment."
                    // Generate integration test logs
                    sh 'echo "Integration tests on staging log" > integration_staging.log'
                }
            }
            post {
                always {
                    // Archive the integration test logs
                    archiveArtifacts artifacts: 'integration_staging.log', allowEmptyArchive: true
                }
            }
        }
        stage('Deploy to Production') {
            steps {
                script {
                    echo "Deploying the application"
                    echo "Production Server used is AWS EC2"
                    // Generate production deployment logs
                    sh 'echo "Deployment to production log" > deploy_production.log'
                }
            }
            post {
                always {
                    // Archive the production deployment log
                    archiveArtifacts artifacts: 'deploy_production.log', allowEmptyArchive: true
                }
            }
        }
    }
}
