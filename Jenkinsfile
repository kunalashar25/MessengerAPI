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
					archiveArtifacts artifacts: '**/target/*.war', onlyIfSuccessful: true
				}
			}		
		}
	}
}