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
				build job:deploy
			}
		}
	}
}