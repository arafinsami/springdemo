pipeline {
    agent any

    parameters {
        string(name: 'GIT_BRANCH', defaultValue: 'main', description: 'Git branch to checkout')
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
                sh 'echo "Branch: ${GIT_BRANCH}"'
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
                    url: 'https://github.com/arafinsami/springdemo.git'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/*.html', allowEmptyArchive: true
        }
    }
}
