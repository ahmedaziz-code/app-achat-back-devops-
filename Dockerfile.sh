pipeline {
    agent any

    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }

    stages {
        stage('Getting project from Github') {
            steps {
                git branch : 'fournisseur' ,
                    url : 'https://github.com/ahmedaziz-code/app-achat.git';
            }
        }
        stage('database connection') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker rm mysql || true
                sudo docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d -p 127.0.0.1:3306:3306 mysql:latest
                '''
            }
        }
        stage('cleanig the project') {
            steps{
                sh 'mvn clean'
            }

        }
        stage ('artifact construction') {
            steps{
                sh 'mvn  package'
            }
        }
        stage ('Unit Test') {
            steps{
                sh 'mvn  test'
            }
        }
        stage ('SonarQube analysis') {
            steps{
                sh '''
                mvn sonar:sonar
                '''
            }
        }
    }
}
