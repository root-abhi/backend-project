pipeline {
    agent any

    environment {
        // Properly reference the Maven tool
        MAVEN_HOME = tool 'M3'  // 'M3' should match your Maven configuration in Jenkins
        NEXUS_URL = 'http://your-nexus-repo-url/repository/maven-releases/'  // Your Nexus URL
        NEXUS_CREDENTIALS = 'nexus-credentials'  // Jenkins credentials ID for Nexus
        PROJECT_VERSION = "1.0.${BUILD_NUMBER}"  // Dynamic versioning
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
                    // Run Maven clean install and tests
                    sh "${MAVEN_HOME}/bin/mvn clean install -DskipTests=false"
                }
            }
        }

        stage('Push to Nexus') {
            steps {
                script {
                    // Deploy the artifacts to Nexus repository
                    sh "${MAVEN_HOME}/bin/mvn deploy -DskipTests -DaltDeploymentRepository=nexus::default::${NEXUS_URL} -Dversion=${PROJECT_VERSION}"
                }
            }
        }
    }

    post {
        success {
            // Notification or success message
            echo 'Build and deployment successful!'
        }
        failure {
            // Notification or failure message
            echo 'Build or deployment failed!'
        }
    }
}
