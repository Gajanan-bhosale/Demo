pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

    agent any

    tools {
        maven 'maven_3.9.4'
    }

    stages {
        stage('code Compilation') {
            steps {
                echo 'code compilation is statring'
                sh 'mvn clean compile'
            }
        }
        stage('code QA Execution') {
            steps {
                echo 'unit test case check in progess'
                sh 'mvn clean test'
                echo 'unit test case check completed'
            }
        }

        stage('code package') {
            steps {
                echo 'Creating a war Artifact'
                sh 'mvn clean package'
                echo 'creation war artifact done'
            }
        }
        stage('Building & Tag Docker Image') {
             steps {
                  echo 'Starting Building Docker Image'
                  sh 'docker build -t kubegajanan/demo-project .'
                  sh 'docker build -t mmt-project .'
                  echo 'Completed  Building Docker Image'
             }
        }
        stage('Docker Image Scanning') {
              steps {
                   echo 'Docker Image Scanning Started'
                   sh 'java -version'
                   echo 'Docker Image Scanning Started'
              }
        }
        stage(' Docker push to Docker Hub') {
              steps {
                    script {
                        withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                        sh 'docker login docker.io -u kubegajanan -p ${dockerhubCred}'
                        echo "Push Docker Image to DockerHub : In Progress"
                        sh 'docker push kubegajanan/demo-project:latest'
                        echo "Push Docker Image to DockerHub : In Progress"
                        sh 'whoami'
                         }
                    }
              }
        }

    }
}