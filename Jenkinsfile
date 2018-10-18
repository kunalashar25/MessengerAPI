pipeline{
	agent any
	stages{	
		
		stage ('Build'){
			steps{
				bat 'mvn clean install'
			}
				
			post{
				success{
					echo 'Archiving Artifacts'
					archiveArtifacts artifacts: '**/*.war', onlyIfSuccessful: true
				}
			}		
		}
	}
}