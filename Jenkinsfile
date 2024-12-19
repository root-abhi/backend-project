pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/bin'  // Directly use the path to Maven
        NEXUS_URL = 'http://your-nexus-repo-url/repository/maven-releases/'
        NEXUS_CREDENTIALS = 'nexus-credentials'
        PROJECT_VERSION = "1.0.${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    sh "${MAVEN_HOME}/mvn clean install -U -DskipTests=false"
                }
            }
        }

        /*
        stage('Push to Nexus') {
            steps {
                script {
                    sh "${MAVEN_HOME}/mvn deploy -DskipTests -DaltDeploymentRepository=nexus::default::${NEXUS_URL} -Dversion=${PROJECT_VERSION}"
                }
            }
        }
        */
    }

            stage('Test & Allure Report') {

            steps {

                script {

                    // Run tests and generate Allure report

                    sh 'mvn test'



                    // Generate Allure reports

                    sh 'mvn allure:serve'

                }

            }

        }


    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
