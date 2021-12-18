pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
            maven "Maven Repository" // -clean
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/kndn2021/JenkinsIntegrationProject.git'
                //sh "mvn clean install"
                    withMaven {
      sh "mvn clean verify"
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
