public class StepTracker {
    protected Months monthName;
    protected int days; //сколько дней в этом месяце, доверимся пользователю
    protected int stepTarget = 10_000; //цель шагов в этом месяце, по умолчанию 10к, но можно поставить свою
    protected int[][] stepsCounter;

    public StepTracker(Months monthName, int days) {
        stepsCounter = new int[days][1]; //счетчик шагов по дням
        this.monthName = monthName;
        this.days = days;

        for (int i = 0; i < this.days; i++) { //заполняем все дни 0, чтобы можно было потом вывести адекватную статистику
            stepsCounter[i][0] = 0;
        }
    }

    public void setStepTarget(int stepTarget) { //установка цели по шагам
        if (stepTarget >= 0) {
            this.stepTarget = stepTarget;
        } else {
            System.out.println("Вводимое число не может быть отрицательным");
        }
    }

    public void setStepsCounter(int day, int steps) { //сохранение шагов за этот день
        if (day > 0 && steps >= 0) {
            this.stepsCounter[day][0] = steps;
        } else {
            System.out.println("Вводимые числа не могут быть отрицательными");
        }
    }

    @Override
    public String toString() {
        String daysOutput = " ";         //собираем вывод шагов по дням
        int totalSteps = 0;               //общее количество шагов
        int maxSteps = 0;                 //максимальное количество шагов за 1 день
        int bestScore = 0;                //лучшая серия дней превысивших цель шагов
        int currentScore = 0;             //текущая серия дней превысивших цель шагов
        for (int i = 0; i < days; i++) {  //проходимся по всему массиву дней

            if (i > 0) {
                daysOutput += "день " + i + " шагов пройдено: " + stepsCounter[i][0] + "\n ";
                totalSteps += stepsCounter[i][0];
            }

            if (maxSteps == 0 || maxSteps < stepsCounter[i][0]) {
                maxSteps = stepsCounter[i][0];
            }

            if (stepsCounter[i][0] > stepTarget) { //если мы в этот день превысили цель, то +1 к серии
                currentScore += 1;
                if (bestScore < currentScore) {
                    bestScore = currentScore;     //запоминаем лучшую серию
                }
            } else {
                currentScore = 0;                 //обнуляется текущая серия, если не смогли превысить цель
            }
        }
        return daysOutput +
                "\n Общее количество шагов за месяц: " + totalSteps +
                "\n Максимальное пройденное количество шагов за месяц: " + maxSteps +
                "\n Среднее количество шагов за месяц: " + (totalSteps / days) +
                "\n Количество сожженных калорий за месяц: " + Converter.calories(totalSteps) +
                "\n Количество пройденных километров за месяц: " + Converter.distance(totalSteps) +
                "\n Лучшая серия " + bestScore;
    }
}
