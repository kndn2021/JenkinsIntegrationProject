pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'make check'
            }
        }
    }
    post {
        always {
          emailext body: 'Jenkins status is : ', subject: 'Jenkins Pipeline status', to: 'kndnbhagat@gmail.com'
            junit '**/target/*.xml'
        }
        failure {
          emailext body: 'Jenkins status is : ', subject: 'Jenkins Pipeline status', to: 'kndnbhagat@gmail.com'
        }
    }
}
