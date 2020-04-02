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
              echo "%{env.WORKSPACE}%"  
              echo "${env.WORKSPACE}"
              bat 'start cmd.exe /c runJarScript.bat'
            }
        }
      }
      
 }
