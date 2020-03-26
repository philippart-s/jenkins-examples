import fr.ourson.utils.Utilities

/**
 * Global var example.
 * @param args The maven args
 */
def call(String args) {
    Utilities util = new Utilities(this)

    util.mvn(args)
}