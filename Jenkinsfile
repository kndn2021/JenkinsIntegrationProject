pipeline {
    agent any
    tools { 
        maven 'Maven Repository' 
        jdk 'JAVA_HOME' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = https://github.com/kndn2021/JenkinsIntegrationProject/tree/master/JenkinsIntegration"
                    echo "M2_HOME = Maven Repository"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}
