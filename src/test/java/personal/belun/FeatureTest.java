package personal.belun;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class,
        locations = { "classpath:/main-context.xml", "classpath:/mock-context.xml" })
public class FeatureTest {

    @Autowired
    @Qualifier(value = "collaborator")
    //@ReplaceWithMock(name = "collaborator")
    private Collaborator mockedCollaborator;

    @Autowired
    private ClassUnderTesting classUnderTest;

    //@Rule
    //public PowerMockRule rule = new PowerMockRule(); // This rule is just bootstrapping PowerMock

    @Before
    public void resetMockedService() {
        initMocks(this);
    }

    @Test
    public void someTest() throws Exception {
        classUnderTest.someMethod();

        verify(mockedCollaborator).doSomethignWith("whatever");
    }
}
