pipeline
{
    agent any 
    environment 
    {
        DIRECTORY_PATH= "The path of the code directory"
        TESTING_ENVIRONMENT= "This testing environment"
        PRODUCTION_ENVIRONMENT= "Vidhi"
    }
    stages
    {
        stage('Build')
        {
            steps
            {
                echo "$DIRECTORY_PATH is being fetched from $TESTING_ENVIRONMENT"
                echo "compile the code and generate any necessary artifacts"
            }
        }
        stage('Unit and Integration Tests')
        {
            steps
            {
                echo "Unit tests"
                echo "Integration tests"
            }
        }
        stage('Code Analysis')
        {
            steps
            {
                echo "Check the quality of the code"
            }
        }
        stage('Security Scan')
        {
            steps
            {
                echo "The application will be deployed to $TESTING_ENVIRONMENT as specified by the environment variable $PRODUCTION_ENVIRONMENT"
            }
        }
        stage('Integration Tests on Staging')
        {
            steps
            {
                
                    sleep 10
                
            }
        }
        stage('Deploy to Production')
        {
            steps
            {
                echo "Code is being deployed to this production environment: $PRODUCTION_ENVIRONMENT"
            }
        }
    }
}

