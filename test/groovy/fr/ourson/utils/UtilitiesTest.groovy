package fr.ourson.utils

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UtilitiesTest extends BasePipelineTest{
    def steps

    @BeforeEach
    void setUp() {
        // Positionnement de l'endroit où on trouve les sources et les différentes ressources
        this.scriptRoots += 'test/resources'
        this.scriptRoots += 'src'

        // Nécessaire pour initialiser le fwk de tests
        super.setUp()

        // Astuce pour pouvoir exécuter le code dans un "context" Jenkins
        steps = loadScript ('foo.groovy')
    }

    @Test
    void should_execute_maven_command() {
        Utilities utilities = new Utilities(steps)

        utilities.mvn 'clean compile'

        assertCallStackContains('mvn clean compile')
    }
}