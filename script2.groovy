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


return this;