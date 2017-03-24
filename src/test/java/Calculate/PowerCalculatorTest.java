package Calculate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kelvin on 24-3-2017.
 */

public class PowerCalculatorTest {

    private PowerCalculator power;

    @Before
    public void setUp() throws Exception {
        power = new PowerCalculator(40);
        System.out.println("Nieuw object gemaakt");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("De berekening is uitgevoerd");
    }

    @Test
    public void calculatePower() throws Exception {
        double result = power.CalculatePower();
        System.out.println("Berekening is bezig, resultaat: " + result);
    }
}