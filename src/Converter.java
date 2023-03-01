public class Converter {
    public static double distance(int steps) { //конвертер шагов в метры
        return steps * 0.75;
    }

    public static int calories(int steps) { //конвертер шагов в Ккал
        return steps / 20;
    }
}
