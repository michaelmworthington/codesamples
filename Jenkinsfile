pipeline {
  agent {
    docker {
      image 'maven:3.5.0-jdk-8'
    }

  }
  stages {
    stage('Build') {
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
    stage('define tools') {
      agent any
      steps {
        tool 'NodeJS 9.11.1 - Auto Install'
      }
    }
    stage('Node') {
      steps {
        sh 'npm --version'
      }
    }
  }
}