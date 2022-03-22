package SpringCalculator.CLI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldAddTwoNumbers() throws Exception{
        mvc.perform(get("/add?x=5&y=8")).andExpect(content().string("13.0"));
    }

    @Test
    void shouldSubtractTwoNumbers() throws Exception{
        mvc.perform(get("/subtract?x=5&y=8")).andExpect(content().string("-3.0"));

    }

    @Test
    void shouldDivideTwoNumbers() throws Exception{
        mvc.perform(get("/divide?x=5&y=8")).andExpect(content().string("0.625"));

    }

    @Test
    void shouldMultiplyTwoNumbers() throws Exception{
        mvc.perform(get("/multiply?x=5&y=8")).andExpect(content().string("40.0"));

    }
}
