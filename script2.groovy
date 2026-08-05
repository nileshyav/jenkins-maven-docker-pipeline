def showWorkingDir(){
    sh '''
    ls -alh
    pwd
    '''
}

def buildJar(){
    sh '''
        mvn clean package
        pwd

    '''
}

def buildImage(){
    sh '''
        docker build -t javaapp .
        docker tag  javaapp inilesh/java-maven-app:v1
        
    '''
}

def push_dockerhub(){
    withCredentials([usernamePassword(credentialsId: 'dockerhub_auth', passwordVariable: 'pass', usernameVariable: 'user')]) {
        sh '''
            echo $pass | docker login -u $user --password-stdin
            echo "login success"
            docker push inilesh/java-maven-app:v1

        '''
    // some block
}
}


return this;