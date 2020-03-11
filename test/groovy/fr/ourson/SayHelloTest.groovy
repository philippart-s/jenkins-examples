package fr.ourson

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before

class SayHelloTest extends BasePipelineTest {
    def steps

    @Override
    @Before
    void setUp() throws Exception {
        this.scriptRoots += "test/resources"
        this.scriptRoots += "src"
        super.setUp()

       helper.registerAllowedMethod("echo", [String.class]) { String message ->
            println(message)
        }
        steps = loadScript('foo.groovy')
    }

    @org.junit.Test
    void should_say_hello() {
        SayHello sayHello = new SayHello(steps)
        sayHello.sayHelloToTheWorld('Stéphane')

        assertCallStackContains('foo.echo(Hello World by Stéphane !!!')
    }
}