pipeline {
  agent any

  tools { 
    maven 'Maven 3.3.9 - Auto Install' 
    jdk 'JDK 8u66 - Auto Install' 
  }
  
  stages {
    stage ('Initialize') {
        steps {
            sh '''
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
            ''' 
        }
    }
    stage('define npm tool') {
      steps {
        script {
                nodeHome = tool 'NodeJS 9.11.1 - Auto Install'
                echo "node home: ${nodeHome}"
                def statusCode = 0
                statusCode = sh returnStatus: true, script: 'which npm'
                echo "which npm status: ${statusCode}"
                statusCode = sh returnStatus: true, script: 'which node'
                echo "which node status: ${statusCode}"
                statusCode = sh returnStatus: true, script: "${nodeHome}/bin/npm --version"
                echo "npm version status: ${statusCode}"
        }
      }
    }
    stage('Maven Build') {
      steps {
        sh '''cd mavensample
mvn clean package'''
      }
    }
    stage('Quality Analysis') {
      parallel {
        stage('Quality Analysis') {
          steps {
            echo 'Run integration tests here...'
          }
        }
        stage('Code Coverage') {
          steps {
            echo 'Run Checkstyle'
          }
        }
      }
    }
    stage('Node Docker') {
      agent {
              docker { image 'node:7-alpine' }
      }
      steps {
         sh 'node --version'
      }
    }
  }
}
