import java.util.Scanner;

public class CheckInputUtils {


    public static int checkIntAndPositivity() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (!(userInput > 0)) {
                    System.out.println("Неправильно введена команда. Попробуйте ввести ее цифрами без пробелов.");
                    scanner.nextLine();
                    continue;
                }
                break;
            }
            System.out.println("Это не число. Попробуйте ввести число цифрами");
            scanner.nextLine();
        }
        return userInput;
    }

    public static int checkMonth() {
        Scanner scanner = new Scanner(System.in);
        int namber;
        String[] nameMonthRus = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август",
                "сентябрь", "октябрь", "ноябрь", "декабрь"};
        String[] nameMonthEng = {"january", "february", "march", "april", "may", "june", "july", "august",
                "september", "october", "november", "december"};
        OUTER:
        while (true) {
            String input = scanner.next();
            input = input.trim().toLowerCase();
            for (int i = 0; i < nameMonthRus.length; i++) {
                if (nameMonthRus[i].equals(input) || nameMonthEng[i].equals(input)) {
                    namber = i + 1;
                    break OUTER;
                }
            }
            System.out.println("Неправильно введена команда. Попробуйте ввести ее одним словом без пробелов.");
            scanner.nextLine();
        }
        return namber;
    }

    public static int checkDays3() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (!(userInput > 0 && userInput <= 30)) {
                    System.out.println("Вы ошиблись.Введите число от 1 до 30");
                    continue;
                }
                break;
            }
            System.out.println("Это не число дня. Попробуйте ввести число цифрами");
            scanner.nextLine();
        }
        return userInput;
    }
}