pipeline {
    agent any

    stages {
        stage('github clone') {
            steps {
                sh "ls -alh && pwd"
                // sh 'rm -rf jenkins-maven-docker-pipeline'
            //   sh 'git clone https://github.com/nileshyav/jenkins-maven-docker-pipeline && cd jenkins-maven-docker-pipeline && pwd && ls -alh'
            }
        }
        stage('Build jar file'){
            steps {
                // sh 'cd jenkins-maven-docker-pipeline &&  mvn package'
                sh 'mvn clean package && pwd'
                
                
            }
        }
        stage('build docker image'){
            steps{
                sh 'pwd  && docker build -t javaapp .'
            }
            
        }
        stage('Deploying app'){
            steps{
                sh 'pwd && docker run -d -p 80:8080 javaapp '

            }
        }
            
        }
    }

