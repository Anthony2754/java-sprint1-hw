import java.util.HashMap;
import java.util.ArrayList;
public class StepTracker {
    HashMap<Integer, ArrayList<Integer>> stepsInMonth;
    ArrayList<Integer> year;
    int targetSteps = 10000;
    int stepInDay;
    StepTracker() {
        stepsInMonth = new HashMap<>();
        stepInDay = 0;
        stepsInMonth.put(1, initArrayList());
        stepsInMonth.put(2, initArrayList());
        stepsInMonth.put(3, initArrayList());
        stepsInMonth.put(4, initArrayList());
        stepsInMonth.put(5, initArrayList());
        stepsInMonth.put(6, initArrayList());
        stepsInMonth.put(7, initArrayList());
        stepsInMonth.put(8, initArrayList());
        stepsInMonth.put(9, initArrayList());
        stepsInMonth.put(10, initArrayList());
        stepsInMonth.put(11, initArrayList());
        stepsInMonth.put(12, initArrayList());
    }
    public ArrayList<Integer> initArrayList() {
        year = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            year.add(stepInDay);
        }
        return year;
    }

    public void saveStepTracker(int month, int day, int steps) {
        if (month < 1 | month > 12) {
            System.out.println("Введен несуществующий месяц");
            return;
        } else if (day < 1 | day > 30) {
                System.out.println("Введен несуществующий день");
                return;
            } else if (steps < 0) {
                    System.out.println("В количестве шагов недопустимо использование отрицательных чисел");
                    return;
                }

            if (stepsInMonth.containsKey(month)) {
                stepsInMonth.get(month).set((day - 1), steps);
                System.out.println("Значение сохранено!");
            }

    }

    public void Statistic(int month) {
        int sumSteps = 0;
        int maxSteps = 0;
        int maxStepsInDay = 0;
        int bestSeries = 0;
        int thisSeries = 0;
        if (stepsInMonth.containsKey(month)) {
            for (int i = 0; i < year.size(); i++) {
                int steps = stepsInMonth.get(month).get(i);
                if (i != 29) {
                    System.out.print((i + 1) + " день: " + steps + ", ");
                } else {
                    System.out.println((i + 1) + " день: " + steps);
                }
                sumSteps += steps;
                if (steps > maxSteps) {
                    maxSteps = steps;
                    maxStepsInDay = i + 1;
                }
                if (steps > targetSteps) {
                    thisSeries++;
                } else {
                    bestSeries = Math.max(bestSeries, thisSeries);
                    thisSeries = 0;
                }
            }
            int averageSteps = sumSteps / year.size();
            System.out.println("Всего шагов за месяц: " + sumSteps);
            System.out.println("Максимальное пройденное количество шагов - " + maxSteps + " было пройдено в " + maxStepsInDay + " день.");
            System.out.println("Среднее количество шагов в день: " + averageSteps);
            Converter.convert(sumSteps);
            System.out.println("Лучшая серия: " + bestSeries + " дней");
        } else {
            System.out.println("Введен несуществующий месяц");
        }
    }
    void newTargetSteps(int newTargetSteps) {
        if (newTargetSteps < 0) {
            System.out.println("В количестве шагов недопустимо использование отрицательных чисел");
        } else {
            targetSteps = newTargetSteps;
            System.out.println("Новая цель по количеству шагов: " + targetSteps);
        }
    }
}