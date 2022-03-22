package SpringCalculator.CLI;

import SpringCalculator.CalculatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CalculatorController controller;

	@Test
	void contextLoads(){
		assertThat(controller).isNotNull();
	}

	@Test
	public void ShouldAddTwoNumbers() throws Exception{
		double num1 = 5;
		double num2 = 6;
		double result = controller.add(5.0,6.0);
		assertThat(result).isEqualTo(11.0);
	}

	@Test
	public void ShouldSubtractTwoNumbers() throws Exception{
		double num1 = 5;
		double num2 = 6;
		double result = controller.subtract(5.0,6.0);
		assertThat(result).isEqualTo(-1.0);
	}

	@Test
	public void ShouldMultiplyTwoNumbers() throws Exception{
		double num1 = 5;
		double num2 = 6;
		double result = controller.multiply(5.0,6.0);
		assertThat(result).isEqualTo(30.0);
	}

	@Test
	public void ShouldDivideTwoNumbers() throws Exception{
		double num1 = 5;
		double num2 = 6;
		double result = controller.divide(5.0,10.0);
		assertThat(result).isEqualTo(0.5);
	}

}
