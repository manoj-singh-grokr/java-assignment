package SpringCalculator.SharedFunctions;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public Double add(Double x, Double y)
    {
        return x+y;
    }

    public Double subtract( Double x,  Double y)
    {
        return x-y;
    }

    public Double multiply( Double x, Double y)
    {
        return x*y;
    }

    public double divide(Double x, Double y)
    {
        return (double) x/y;
    }
}
