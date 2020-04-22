import fr.ourson.utils.Utilities

def call(Map config) {

    Utilities util = new Utilities(this)

    node {
        stage('Build') {
            echo 'Building..'
            util.mvn config.mvnArgs
        }
        stage('Test') {
            echo 'Testing..'
        }
        stage('Deploy') {
            echo 'Deploying....'
        }
    }
}