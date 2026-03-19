pipeline {
    agent any 
    tools {
        jdk 'JDK17'
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
                    sh "mvn clean test"
                    archiveArtifacts artifacts: 'target/ExtentReport.html', fingerprint: true
                }
            }
        }
    }
post {
        always {
            // Publish JUnit XML reports to Jenkins
            junit 'target/surefire-reports/*.xml'
            publishHTML(target: [
              reportDir: 'target',
              reportFiles: 'ExtentReport.html',
             reportName: 'Extent Report'
         ])
        }
       
    }
}
