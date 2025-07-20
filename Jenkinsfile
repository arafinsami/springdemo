pipeline {
    agent any

    parameters {
        string(name: 'GIT_BRANCH', defaultValue: 'develop', description: 'Git branch to checkout')
        string(name: 'GIT_TAG', defaultValue: '1.0', description: 'Docker image tag')
    }

    environment {
        MODULE_PATH = "springdemo"
        ECR_REPO = "418295709911.dkr.ecr.us-east-1.amazonaws.com/springdemo"
        SCANNER_HOME = tool 'sonar-scanner'
        MAVEN_HOME = tool 'Maven 3'
    }

    tools {
        maven 'Maven 3'
    }

    stages {
        stage('Print Build Info') {
            steps {
                sh 'echo "Branch: ${GIT_BRANCH}, Tag: ${GIT_TAG}"'
                sh 'env'
            }
        }

        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Git Checkout') {
            steps {
                git branch: "${params.GIT_BRANCH}",
                    credentialsId: 'gitlab-cred',
                    url: 'http://18.179.133.228/sun_game/game-fish.git'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/*.html', allowEmptyArchive: true
        }
    }