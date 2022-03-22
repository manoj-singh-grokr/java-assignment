package SpringCalculator;

import SpringCalculator.SharedFunctions.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final Calculator calculator;

    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping("/")
    public String show(){
        return "This is a calculator that works with values in the url.";
    }

    @GetMapping("/add")
    public Double add(@RequestParam Double x, @RequestParam Double y) {
        return calculator.add(x, y);
    }

    @GetMapping("/subtract")
    public Double subtract(@RequestParam Double x, @RequestParam Double y) {
        return calculator.subtract(x, y);
    }

    @GetMapping("/multiply")
    public Double multiply(@RequestParam Double x, @RequestParam Double y) {
        return calculator.multiply(x, y);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam Double x, @RequestParam Double y) {
        return calculator.divide(x, y);
    }
}
