package jenkinsfiles

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.ProjectSource.projectSource

class MyMavenStepJnkTest extends BasePipelineTest {

    @Override
    @BeforeEach
    void setUp() {


        def library = library().name('ourson-lib')
                .defaultVersion('<notNeeded>')
                .allowOverride(true)
                .implicit(false)
                .targetPath('<notNeeded>')
                .retriever(projectSource())
                .build()

        helper.registerSharedLibrary(library)

        super.setUp()
    }

    @Test
    void should_run_custom_step() {
        helper.registerAllowedMethod('echo', [String.class], {p -> println p})
        runScript('test/resources/myMavenStep.jenkins')
        assertJobStatusSuccess()
    }
}
