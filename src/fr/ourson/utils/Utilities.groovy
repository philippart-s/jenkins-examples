package fr.ourson.utils

/**
 * Utility class example for a pipeline
 */
class Utilities implements Serializable{
    Script steps

    Utilities(Script steps) {
        this.steps = steps
    }

    /**
     * Simple method to exceute maven commands
     * @param args Maven arguments.
     */
    void mvn(String args) {
        steps.sh "mvn ${args}"
    }
}
