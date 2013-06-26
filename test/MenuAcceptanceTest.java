import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuAcceptanceTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @WebAppConfiguration
    @ContextConfiguration("file:web/WEB-INF/mvc-dispatcher-servlet.xml")

    public class RestaurantAcceptanceTest {

        private MockMvc mockMvc;

        @SuppressWarnings("SpringJavaAutowiringInspection")
        @Autowired
        protected WebApplicationContext wac;

        @Before
        public void setup() {
            this.mockMvc = webAppContextSetup(this.wac).build();
        }

        @Test
        public void index() throws Exception {
            mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Sea Foods"));
        }
    }
}
