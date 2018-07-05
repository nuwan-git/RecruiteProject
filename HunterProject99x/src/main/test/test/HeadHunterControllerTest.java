package test;

import net.cnr.controller.HeadHunterController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({/* include live config here
    e.g. "file:web/WEB-INF/application-context.xml",
    "file:web/WEB-INF/dispatcher-servlet.xml" */})
public class HeadHunterControllerTest {

    private MockMvc mockMvc;
    private HeadHunterController headHunterController;
    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(headHunterController).build();
    }
}
