pipeline{
	agent any
	stages{	
		
		stage ('Build'){
			steps{
				sh 'mvn clean install'
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