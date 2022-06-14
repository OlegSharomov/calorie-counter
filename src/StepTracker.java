import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    int targetNumberOfSteps = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public int changeValueSteps(int month, int day, int steps) {
        monthToData.get(month).daysAndSteps.set(day, steps);
        return monthToData.get(month).daysAndSteps.get(day);
    }

    class MonthData {
        ArrayList<Integer> daysAndSteps = new ArrayList<>();

        public MonthData() {
            for (int i = 0; i < 30; i++) {
                daysAndSteps.add(0);
            }
        }
    }

    public void changeTargetNumberOfSteps(int TargetSteps) {
        if (TargetSteps >= 0) {
            targetNumberOfSteps = TargetSteps;
            System.out.println("Целевое количество шагов изменено. Сейчас оно составляет: " + targetNumberOfSteps);
        } else {
            System.out.println("Целевое количество шагов не изменено. Попробуйте еще раз. Значение цели должно быть положительным");
        }
    }

    public void printStatistics(int month) {
        printMonthlyStatistics(month - 1);
        printAllStepsDistanceAndCalories(month - 1);
        printMaxStepsOnDay(month - 1);
        printAverageNumberOfSteps(month - 1);
        printBestSeries(month - 1);
    }

    void printMonthlyStatistics(int month) {
        for (int i = 0; i < monthToData.get(month).daysAndSteps.size(); i++) {
            System.out.print((i + 1) + " день: " + monthToData.get(month).daysAndSteps.get(i));
            if (i < monthToData.get(month).daysAndSteps.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    void printAllStepsDistanceAndCalories(int month) {
        int count = 0;
        for (int steps : monthToData.get(month).daysAndSteps) {
            count += steps;
        }
        System.out.println("Общее количество шагов за месяц составляет: " + count);
        System.out.println("Общее пройденное расстояние = " + Converter.calculateDistanceInKilometers(count) + " км");
        System.out.println(Converter.losingWeight(count) + " - столько килокалорий вы сожгли за месяц. Вы молодец!!!");
    }

    public void printMaxStepsOnDay(int month) {
        int day = 0;
        int max = 0;
        for (int i = 0; i < monthToData.get(month).daysAndSteps.size(); i++) {
            if (max < monthToData.get(month).daysAndSteps.get(i)) {
                max = monthToData.get(month).daysAndSteps.get(i);
                day = i + 1;
            }
        }
        System.out.println(day + " числа вы прошли " + max + " шагов. Это лучший результат за месяц!!!");
    }

    public void printAverageNumberOfSteps(int month) {
        int allSteps = 0;
        for (int steps : monthToData.get(month).daysAndSteps) {
            allSteps += steps;
        }
        System.out.println((allSteps / monthToData.get(month).daysAndSteps.size()) + " - это среднее ежедневное количество шагов в месяце");
    }

    public void printBestSeries(int month) {
        int days = 0;
        int count = 0;
        for (int j : monthToData.get(month).daysAndSteps) {
            if (j > targetNumberOfSteps) {
                count++;
            } else {
                count = 0;
            }
            if (count > days) {
                days = count;
            }
        }
        System.out.println(days + " дней подряд в месяце вы прошли выше намеченной цели");
    }
}
