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
              //bat 'java -jar ./build/libs/Artifact1-1.0-SNAPSHOT.jar'
               // bat "start cmd.exe /c ${env.WORKSPACE}/runJarScript.bat"
               //bat 'runJarScript.bat' 
                bat 'start cmd.exe /c ${env.WORKSPACE}/build/libs/Artifact1-1.0-SNAPSHOT.jar'
            }
        }
      }
      
 }
