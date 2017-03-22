package Calculate;

/**
 * Created by Kelvin on 22-3-2017.
 */
public class Calculate {

    public static double CalculatePower(int speed) {

        //windsnelheid => m/s = windsnelheid / 3,6
        //1m/s == 250 Kw

        double mPerSeconde = speed / 3.6;
        double kWh = 250 * mPerSeconde;

        return Math.round(kWh);
    }
}
