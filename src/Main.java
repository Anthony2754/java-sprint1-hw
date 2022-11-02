import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int target = 10000;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Ваша ежедневная цель: " + target + " шагов.");
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {

            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести количество шагов: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, 7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
                int month = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов: от 1 до 30.");
                int day = scanner.nextInt();
                System.out.println("Введите количество ваших шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveStepTracker(month, day, steps);

            } else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите посмотреть статистику: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5 - Май, 6 - Июнь, 7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
                int month = scanner.nextInt();
                stepTracker.Statistic(month);

            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов в день:");
                int newTargetSteps = scanner.nextInt();
                stepTracker.changePurposeOfDailySteps(newTargetSteps);

            } else {
                System.out.println("Извините, такой команды пока нет.");

            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}