pipeline{
	agent any
	stages{		
		stage ('Build'){		
			tools {
				jdk 'JDK 8u101'			
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