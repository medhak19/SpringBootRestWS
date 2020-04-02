pipeline {

    agent any

    stages {

        // Clean
        stage('CLEAN'){
            steps{
              bat './gradlew clean'
            }
        }

        stage('BOOTJAR'){
            steps{
              bat './gradlew bootJar'
            }
        }

        stage('RUNJAR'){
            steps{
              bat 'start cmd.exe /c ./runJarScript.bat'
            }
        }
      }
      
 }
