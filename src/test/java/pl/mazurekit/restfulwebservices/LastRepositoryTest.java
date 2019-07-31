package pl.mazurekit.restfulwebservices;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LastRepositoryTest {
    @Autowired
    private MockMvc mockMvc;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8888));

    @Test
    public void shuldReturnExpectedText() throws Exception {

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/users/allegro/repos?per_page=100"))
                .willReturn(WireMock.aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{" +
                                "\"id\": 71782347," +
                                "\"name\": \"akubra\"," +
                                "\"updated_at\": \"2018-01-07T13:23:15Z\"," +
                                "\"pushed_at\": \"2018-04-19T09:42:36Z\"" +
                                "}," +
                                "{" +
                                "\"id\": 71782342," +
                                "\"name\": \"dom\"," +
                                "\"updated_at\": \"2019-01-02T13:23:15Z\"," +
                                "\"pushed_at\": \"2019-03-19T09:42:36Z\"" +
                                "}" +
                                "]")));

        mockMvc.perform(get("/lastrepo"))
                .andExpect(status().isOk())
                .andExpect(content().string("dom"));

    }


}
