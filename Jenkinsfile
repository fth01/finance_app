pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                checkout scm
            }
        }
    }

    stage('build docker image') {
        steps {
            script {
                sh "docker build --no-cache -t finace-test-image ."
            }
        }
    }
}