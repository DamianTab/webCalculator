package damian.tab.calculator.api;

import damian.tab.calculator.service.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@EnableWebMvc
@WebAppConfiguration
@ContextConfiguration(classes = {CalculatorController.class, CalculationService.class})
public class ITCalculatorController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void shouldAssertNotNullServletAndBeans() {
        final ServletContext servletContext = webApplicationContext.getServletContext();
        assertAll(() -> {
            assertNotNull(servletContext);
            assertTrue(servletContext instanceof MockServletContext);
            assertNotNull(webApplicationContext.getBean(CalculationService.class));
            assertNotNull(webApplicationContext.getBean(CalculatorController.class));
        });
    }

    @Test
    public void shouldReceiveResponseFromApi() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("firstNumber", "10.1");
        paramsMap.add("secondNumber", "2");

        this.mockMvc.perform(get("/api/calculator/addition").params(paramsMap))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.result").value("12.1"));
    }

}
