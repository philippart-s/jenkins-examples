package vars

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Classe permettant de tester le script représentant le custom step myMavenStep.jenkins
 */
class MyMavenStepTest extends BasePipelineTest{

    @Override
    @BeforeEach
    void setUp() {
        this.scriptRoots += 'test/resources'
        this.scriptRoots += 'src'
        this.scriptRoots += 'vars'

        super.setUp()
    }

    @Test
    void should_run_custom_step() {
        def customStepToTest = loadScript('myMavenStep.groovy')

        Map params = [mvnArgs:'clean compile']
        customStepToTest.call(params)

        assertCallStackContains('mvn clean compile')
    }

}
