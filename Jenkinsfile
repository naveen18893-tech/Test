pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stages {
    state ('test java version') {
        steps {
            script {
                sh "java --version"
                sh "mvn --verion"
            }
        }
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
