package com.oneous.main.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Abdullah Al Mamun Oronno (www.oneous.com)
 */
/*

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/main/WEB-INF/servlet-context.xml", "file:src/main/main/WEB-INF/applicationContext-jdbc.xml"})
public class HomeControllerTest {

    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void getDefaultHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name(Matchers.containsString("home")));
    }

    @Test
    public void viewName() throws Exception {
        this.mockMvc.perform(get("/home"))
                .andExpect(view().name(Matchers.containsString("home")));
    }

}*/
