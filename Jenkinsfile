pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            timestamps() {
              fileExists 'pom.xml'
              sh '/var/jenkins_home/mvn clean install -Dlicense.skip=true'
            }

          }
        }

        stage('Get version') {
          steps {
            timestamps() {
              sh '/var/jenkins_home/mvn --version'
            }

          }
        }

      }
    }

  }
}
