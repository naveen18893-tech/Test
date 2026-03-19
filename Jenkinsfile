pipeline {
    agent any 
    environment {
    JAVA_HOME = '/usr/lib/jvm/java-17-amazon-corretto.x86_64'
    PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }
    tools {
        maven 'maven'
    }
    stages {
    stage ('test java version') {
        steps {
            script {
                sh "java --version"
                sh "mvn --version"
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
