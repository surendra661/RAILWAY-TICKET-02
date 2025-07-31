pipeline {
    agent any
    tools {
        maven 'myma'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/surendra661/RAILWAY-TICKET-02.git'

            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('test') {
            steps {
                echo 'testing to server...'
            }
        }
    }
}
