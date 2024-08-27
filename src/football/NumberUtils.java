package football;

public class NumberUtils {
    public static int generateNumberInRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
