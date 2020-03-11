package fr.ourson

class SayHello {
    def steps

    SayHello(Script steps) {
        this.steps = steps
    }

    void sayHelloToTheWorld(String name) {
        steps.echo "Hello World by ${name} !!!"
    }
}