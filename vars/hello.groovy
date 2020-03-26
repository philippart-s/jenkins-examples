import fr.ourson.SayHello

def call(String name) {
    SayHello sayHello = new SayHello(this)
    sayHello.sayHelloToTheWorld(name)
}