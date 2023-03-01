import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker month = new StepTracker(Months.January, 31);

        Scanner input = new Scanner(System.in);
        System.out.println("Добрый день!");

        while (true) {
            System.out.println("""
                    Введите номер операции:
                    1. Ввести количество шагов за определенный день
                    2. Напечатать статистику за определенный месяц
                    3. Изменить цель по количеству шагов в день
                    4. Выйти из приложения""");

            int userChoice = input.nextInt();

            if (userChoice == 4) {
                System.out.println("Программа завершена, досвидания");
                break;
            }

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Введите день за который вы хотите ввести шаги: ");
                    int day = input.nextInt();
                    System.out.println("Введите количество шагов: ");
                    int steps = input.nextInt();
                    month.setStepsCounter(day, steps);
                }
                case 2 -> System.out.println(month);
                case 3 -> {
                    System.out.println("Введите новую цель шагов для этого месяца: ");
                    int step = input.nextInt();
                    month.setStepTarget(step);
                }
                default -> System.out.println("Вы вводите некорректное число!");
            }
        }
    }
}