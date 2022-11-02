
public class Converter {
    static double strideLength = 0.75;
    static double calorieStep = 50;

    // Конвертация шагов в километры и калории
    static void convert(int sumSteps) {
        System.out.println("Пройденная дистанция: " + (sumSteps * strideLength / 1000) + " км.");
        System.out.println("Сожженно: " + (sumSteps * calorieStep / 1000) + " килокалорий.");
    }
}