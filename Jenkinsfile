pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
        SONAR_HOST_URL = 'http://localhost:9000'
        SONAR_PROJECT_KEY = 'employee-crud'
    }

    parameters {
        string(name: 'DOCKER_IMAGE_NAME', defaultValue: 'employee-crud', description: 'Docker image name')
        string(name: 'DOCKER_IMAGE_TAG', defaultValue: 'latest', description: 'Docker image tag')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                withEnv(["PATH+JAVA=${env.JAVA_HOME}\\bin"]) {
                    bat 'mvn clean install'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withEnv(["PATH+JAVA=${env.JAVA_HOME}\\bin"]) {
                    withCredentials([string(credentialsId: 'sonarqube-token', variable: 'SONAR_TOKEN')]) {
                        bat '''
                            mvn sonar:sonar ^
                                -Dsonar.projectKey=%SONAR_PROJECT_KEY% ^
                                -Dsonar.projectName=%SONAR_PROJECT_KEY% ^
                                -Dsonar.projectVersion=1.0.0 ^
                                -Dsonar.sources=src/main/java ^
                                -Dsonar.tests=src/test/java ^
                                -Dsonar.java.binaries=target/classes ^
                                -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml ^
                                -Dsonar.host.url=%SONAR_HOST_URL% ^
                                -Dsonar.login=%SONAR_TOKEN%
                        '''
                    }
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }

        success {
            echo 'Build successful!'
            echo 'Test Results: Jenkins Build > Test Results tab'
            echo 'SonarQube: http://localhost:9000/dashboard?id=employee-crud'
        }

        failure {
            echo 'Build failed. Check logs for details.'
        }
    }
}
