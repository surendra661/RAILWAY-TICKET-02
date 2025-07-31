pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/surendra661/RAILWAY-TICKET-02.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building Railway Ticket App...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying to server...'
            }
        }
    }
}
