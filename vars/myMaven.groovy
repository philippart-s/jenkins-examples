import fr.ourson.utils.Utilities

/**
 * Custom step example.
 * @param args The maven args
 */
def call(String args) {
    Utilities util = new Utilities(this)

    util.mvn(args)
}