pipeline {
agent any environment {
// none required
} stages {
stage('Build') {
steps {
echo "Build using Maven to compile and package" }
}
stage('Unit and Integration Tests') {
steps {
echo "Unit tests: Ensuring code functions as expected"
echo "Integration tests: Ensuring different components of the application work together as expected"
echo "Unit and Integration tests are conducted using Appium"
} post {
success {
mail to: "jenkinsdeakin@gmail.com"
subject: "Unit tests and Integration tests outcome",
body: "Unit tests and Integration test have been successful"
} }
}
stage('Code Analysis') {
steps {
echo "Analysing Code to ensure it meets industry standards."
echo "Code Analysed using SonarQube" }
}
    stage('Security Scan') {
steps {
echo "Conducting security scan"
echo "Security scan completed using Burp Suite" }
post {
success {
mail to: "jenkinsdeakin@gmail.com", subject: "Security Scan outcome", body: "Security Scan was successful"
} }
}
stage('Deploy to Staging') {
steps {
echo "Application will be deployed to staging server"
echo "Staging server is AWS EC2" }
}
stage('Integration Tests on Staging') {
steps {
echo "Running integration tests on the staging environment to ensure the application functions as expected in a production-like environment."
} }
stage('Deploy to Production') {
steps {
echo "Deploying the application"
echo "Production Server used is AWS EC2" }
} }
}
