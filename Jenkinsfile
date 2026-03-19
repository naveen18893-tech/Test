pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stage ('test') {
            steps {
                script {
                    sh "mvn test"
                }
            }
        }
    }
}
