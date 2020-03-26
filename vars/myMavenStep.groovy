import fr.ourson.utils.Utilities

/**
 * Custom step example.
 * @param args The maven args
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
    util.mvn(args)
}