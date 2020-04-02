pipeline {

    agent any

    stages {

        // Clean
        stage('CLEAN'){
            steps{
              ./gradlew clean
            }
        }

        stage('BOOTJAR'){
            steps{
              ./gradlew bootJar
            }
        }

        stage('RUNJAR'){
            steps{
              start java -jar build/libs/Artifact1-1.0-SNAPSHOT.jar
            }
        }
      }
      
 }
