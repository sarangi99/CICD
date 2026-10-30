
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
