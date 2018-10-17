pipeline{
	agent any
	stages{	
		
		stage ('Build'){
			steps{
				sh 'mvn clean package'
			}
				
			post{
				success{
					echo 'Archiving Artifacts'
					archiveArtifacts artifacts: '**/*.war'
				}
			}		
		}
	}
}