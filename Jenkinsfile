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
        tool 'NodeJS 9.11.1 - Auto Install'
        
        def statusCode = sh returnStatus:true, script: 'npm --version'
        echo "npm version status code: ${statusCode}"
        
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
    stage('Node') {
      steps {
        sh 'npm --version'
      }
    }
  }
}
