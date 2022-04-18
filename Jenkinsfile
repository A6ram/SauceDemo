pipeline {
    agent any
parameters {
 gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
               git branch: "${params.BRANCH}", url: 'https://github.com/Yuschkewicz/SauceDemo.git'

                // Run Maven on a Unix agent.
                sh "mvn clean test"


                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'

                }
            }
        }
        stage('Allure') {
 steps {
     script {
             allure([
                     includeProperties: false,
                     jdk: '',
                     properties: [],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results']]
             ])
     }
 }
}

    }
}