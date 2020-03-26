package fr.ourson

/**
 * Wonderfull class to say Hello !
 */
class SayHello {
    // Jenkins steps
    def steps

    /**
     * Constructor with Jenkins steps.
     * @param steps Jenkin's steps.
     */
    SayHello(Script steps) {
        this.steps = steps
    }

    /**
     * Say hello to the world !
     * @param name Who say hello ?
     */
    void sayHelloToTheWorld(String name) {
        steps.echo "Hello World by ${name} !!!"
    }
}