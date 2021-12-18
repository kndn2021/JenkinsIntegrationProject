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
                withMaven {
                  //bat "mvn clean install"
                    mvn install:install-file "-DgroupId=org.mozilla" "-DartifactId=jss" "-Dversion=4.2.5" "-Dpackaging=jar" "-Dfile=C:\Users\AArmijos\workspace\componentes-1.0.4\deps\jss-4.2.5.jar"
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
