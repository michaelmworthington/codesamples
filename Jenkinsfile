pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''cd mavensample
mvn clean package'''
      }
    }
  }
}