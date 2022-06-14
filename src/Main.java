import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();

                if (userInput == 1) {
                    System.out.println("Введите название месяца, например: Январь");
                    int month = CheckInputUtils.checkMonth();
                    System.out.println("Введите число месяца от 1 до 30");
                    int day = CheckInputUtils.checkDays3();
                    System.out.println("Введите количество пройденных шагов за этот день (цифрами)");
                    int steps = CheckInputUtils.checkIntAndPositivity();
                        System.out.println("Данные по шагам занесены. Теперь они составляют значение: " +
                                stepTracker.changeValueSteps(month - 1, day - 1, steps));

                } else if (userInput == 2) {
                    System.out.println("За какой месяц вы хотите вывести статистику?");
                    System.out.println("Введите название месяца, например: Январь");
                    int month = CheckInputUtils.checkMonth();
                        stepTracker.printStatistics(month);
                } else if (userInput == 3) {
                    System.out.println("Введите новую цель по количеству шагов");
                    int targetSteps = CheckInputUtils.checkIntAndPositivity();
                    stepTracker.changeTargetNumberOfSteps(targetSteps);
                } else if (userInput == 0) {
                    break;
                }
            } else {
                System.out.println("Неправильно введена команда. Попробуйте ввести ее цифрами без пробелов.");
            }
            scanner.nextLine();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Пожалуйста, введите номер команды, что именно вы хотите сделать:");
        System.out.println("1 => Ввести количество шагов за определённый день");
        System.out.println("2 => Напечатать статистику за определённый месяц");
        System.out.println("3 => Изменить цель по количеству шагов в день");
        System.out.println("0 => Выйти из приложения");
    }
}