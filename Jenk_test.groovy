pipeline {
    agent any
    stages {
        stage('Fase 1') {
            steps {
                echo 'Fase 1'
                sh 'touch file_Fase1.txt'
                sh 'echo "Esto es la fase 1" >> file_Fase1.txt'
                archiveArtifacts artifacts: 'file_Fase1.txt'

            }   
        }
        stage('Fase 2'){
            steps {
                echo 'Fase 2'
                sh 'touch file_Fase2.txt'
                sh 'echo "Esto es la Fase2" >> file_Fase2.txt'
                archiveArtifacts artifacts: 'file_Fase2.txt'
            }
        }
        stage('Fase Final'){
            steps {
                echo 'Fase Final'
                sh 'touch file_Final.txt'
                sh 'cat file_Fase1.txt >> file_Final.txt'
                sh 'cat file_Fase2.txt >> file_Final.txt'
                archiveArtifacts artifacts: 'file_Final.txt'
            }
        }
    }
}