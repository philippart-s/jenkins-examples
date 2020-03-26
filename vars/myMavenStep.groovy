import fr.ourson.utils.Utilities

/**
 * Custom full step example.
 * @param config Step parameters
 */
def call(Map config) {

    Utilities util = new Utilities(this)

    node() {
        stage('Build') {
            echo 'Building..'
            myMaven config.mvnArgs
        }
        stage('Test') {
            echo 'Testing..'
        }
        stage('Deploy') {
            echo 'Deploying....'
        }
    }
}