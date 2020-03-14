package fr.ourson

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

class SayHelloTest extends BasePipelineTest {
    def steps

    @Override
    @Before
    void setUp() throws Exception {
        // Positionnement de l'endroit où on trouve les sources et les différentes ressources
        this.scriptRoots += "test/resources"
        this.scriptRoots += "src"
        super.setUp()

        // Un exemple de moking de méthode propre à Jenkins, ici echo ne fera qu'afficher les messages dans la sortie standard
        // De nombreuses méthodes sont déjà mockées dans BasePipelineTest
        helper.registerAllowedMethod("echo", [String.class]) { String message ->
            println(message)
        }

        // Astuce pour pouvoir exécuter le code dans un "context" Jenkins
        steps = loadScript('foo.groovy')
    }

    @Test
    void should_say_hello() {
        SayHello sayHello = new SayHello(steps)
        sayHello.sayHelloToTheWorld('Stéphane')

        // Affiche la pile d'appels, c'est dans cette pile d'appels que la méthode assertCallStackContains va rechercher
        printCallStack()

        // On cherche l'instruction qui doit être appelée avec les bons paramètres
        assertCallStackContains('foo.echo(Hello World by Stéphane !!!')
    }
}