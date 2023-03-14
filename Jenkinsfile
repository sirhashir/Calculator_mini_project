pipeline {
    agent any
    
    environment { // setting langugae level
        LANG = 'en_US.UTF-8'
    }

    stages { 
        stage('Git Pull'){
            steps{
                git url: 'https://github.com/sirhashir/Calculator_mini_project.git', branch: 'master',
                credentialsId:'Github_id'
            }
        }
        stage('Maven Build and Run Tests'){
            steps{
                sh "mvn clean install"
            }
        }
        stage('Image Build'){ 
            steps{
                sh "docker build -t hashir10/spe_mini_project:latest ."
            }
        }

        stage('Image Deploy') {
          steps {
            withCredentials([usernamePassword(credentialsId: 'Docker_id', usernameVariable: 'docker_username', passwordVariable: 'docker_password')]) {
              sh "echo $docker_password | docker login --username $docker_username --password-stdin"
              sh "docker push hashir10/spe_mini_project:latest"
            }
          }
        }
//         stage('Delete previous Image and Containers') {
//             steps {
//                 sh '''
//                     # Get the IDs of all images with the tag <none>
//                     NONE_IMAGES=$(docker images | grep "<none>" | awk '{print $3}')
//                     # Delete all of the <none> images
//                     for IMAGE in $NONE_IMAGES
//                     do
//                       docker rmi --force $IMAGE
//                     done
//                     # Delete all of the containers associated with the <none> images
//                     for IMAGE in $NONE_IMAGES
//                     do
//                       # Get the container IDs for the image
//                       CONTAINER_IDS=$(docker ps -a | grep $IMAGE | awk '{print $1}')
//                   # Remove the containers
//                   for CONTAINER_ID in $CONTAINER_IDS
//                   do
//                     docker rm --force $CONTAINER_ID
//                   done
//                 done
//                 '''
//             }
//         }
        stage('Ansible Deploy') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker_id', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    ansiblePlaybook(
                        installation: 'Ansible',
                        inventory: 'inventory',
                        playbook: 'ansible_playbook.yml',
                        colorized: true,
                        disableHostKeyChecking: true,
                        extraVars: [
                            'jenkins_credentials_username': "${DOCKERHUB_USERNAME}",
                            'jenkins_credentials_password': "${DOCKERHUB_PASSWORD}"
                        ]
                    )
                }
            }
        }
    }
    options {
        skipDefaultCheckout()
        timestamps()
    }
}
