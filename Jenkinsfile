
pipeline {
    agent any

    stages {
        stage('clone code') {
            steps {
                git branch: 'main', credentialsId: 'Git-cred', url: 'https://github.com/sarangi99/CICD.git'
            }
        }
stage('Build') {
            steps {
                sh 'mvn clean compile' 
           }
        }
stage('package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('copy to nexus') {
            steps {
                sh 'mvn clean deploy'
            }
        }
        stage('Build Docker Image') {
    steps {
        sh 'docker build -t quickbite-app:1.0 .'
    }
}
         stage('Conatiner creation using port mapping') {
    steps {
        sh 'docker run -d --name cn-quickbite-app:1.0 -p 8083:8080  quickbite-app:1.0 '
    }
}
    }
}
