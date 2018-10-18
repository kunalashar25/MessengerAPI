pipeline{
	agent any
	stages{	
		
		stage ('Build'){
			steps{
				bat 'mvn clean'
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