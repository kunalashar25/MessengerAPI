pipeline{
	agent any
	stages{	
	
		stage ('Checkout'){
			steps{
				dir('MessengerAPI'){
				checkout[{
					branches: [[name: '*/master']],
                		extensions: [[$class: 'CloneOption', depth: 0, noTags: false, reference: '', shallow: false, timeout: 60]]
				}]
				}
			}		
		}
		
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