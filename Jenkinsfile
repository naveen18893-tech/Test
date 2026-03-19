pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stages {
    stage ('test') {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }
    }
}
