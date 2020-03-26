import fr.ourson.utils.Utilities

/**
 * Custom step example.
 * @param args The maven args
 */
def call(String args) {

    Utilities util = new Utilities(this)

    node() {
        stage('Build') {
            echo 'Building..'
            myMaven 'compile'
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