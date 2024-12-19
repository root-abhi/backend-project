pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'M3', type: 'Tool'  // This assumes you've configured Maven in Jenkins
        NEXUS_URL = 'http://your-nexus-repo-url/repository/maven-releases/' // Your Nexus URL
        NEXUS_CREDENTIALS = 'nexus-credentials'  // Jenkins credentials ID for Nexus
        PROJECT_VERSION = '1.0.${BUILD_NUMBER}'  // Versioning for your project
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    // Clean and build the project with Maven, run tests (including Cucumber)
                    sh "'${MAVEN_HOME}/bin/mvn' clean install -DskipTests=false"
                }
            }
        }

        stage('Push to Nexus') {
            steps {
                script {
                    // Deploy to Nexus repository using Maven Deploy plugin
                    sh "'${MAVEN_HOME}/bin/mvn' deploy -DskipTests -DaltDeploymentRepository=nexus::default::${NEXUS_URL} -Dversion=${PROJECT_VERSION}"
                }
            }
        }
    }

    post {
        success {
            // Send success notification (optional)
            echo 'Build and deployment successful!'
        }
        failure {
            // Send failure notification (optional)
            echo 'Build or deployment failed!'
        }
    }
}

