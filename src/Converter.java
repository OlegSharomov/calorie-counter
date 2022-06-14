public class Converter {
    public static final double LENGTH_OF_ONE_STEP_IN_KILOMETERS = 0.00075;
    public static final double LOSING_KILOCALORIES_IN_ONE_STEP = 0.05;

    public static double cutNumbersAfterComma(double namber){
        double scale = Math.pow(10, 3);
        namber = Math.round(namber * scale) / scale;
        return namber;
    }

    public static double calculateDistanceInKilometers(int steps) {
        double distance = steps * LENGTH_OF_ONE_STEP_IN_KILOMETERS;
        double result = cutNumbersAfterComma(distance);
        return  result;
    }

    public static double losingWeight(int steps) {
        double calories = steps * LOSING_KILOCALORIES_IN_ONE_STEP;
        double result = cutNumbersAfterComma(calories);
        return result;
    }
}