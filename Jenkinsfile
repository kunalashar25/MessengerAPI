pipeline{
	agent any
	stages{		
		stage ('Build'){		
			tools {
				jdk 'localJDK'		
			}
			steps{
				bat 'mvn clean package'
			}				
			post{
				success{
					echo 'Archiving Artifacts'
					archiveArtifacts artifacts: '**/*.war', onlyIfSuccessful: true
				}
			}		
		}
		stage('Deploy to Server'){
			steps{
				echo 'Deploying Artifacts to Server'
				build job: 'deploy'
			}
			post{
				success{
					echo 'Deployed Successfully!'					
				}
				failure{
					echo 'Deployment Failed!'					
				}
			}
		}		
		stage('Perform Checkstyle?'){
			steps{
				timeout(time:5,unit:'DAYS'){
					input message: 'Perform Code CheckStyle?'
				}
				
				build job: 'checkstyle'
			}
			post{
				success{
					echo 'Checkstyle Completed!'					
				}
				failure{
					echo 'Checkstyle Issue!'					
				}
			}
		}
	}
}