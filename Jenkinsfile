pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
            maven "Maven Repository"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/kndn2021/JenkinsIntegrationProject.git'
                def mavenPom = readMavenPom 'pom.xml'
                withMaven {
                  bat "mvn clean install"
                    //--file *.pom 
    }
            }
            
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    emailext body: 'Jenkins pipeline build successfully run', subject: 'Success jenkins build', to: 'kndnbhagat@gmail.com'
                }
            }
        }
    }
}
