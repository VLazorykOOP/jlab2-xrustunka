import java.util.Scanner;

public class Drib {
    private int numerator;
    private int denominator;

    // Конструктор
    public Drib(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Конструктор, що дозволяє вводити дріб з клавіатури
    public Drib() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть чисельник: ");
        this.numerator = scanner.nextInt();
        System.out.print("Введіть знаменник: ");
        this.denominator = scanner.nextInt();
    }

    // Знаходження найбільшого спільного дільника (НСД)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Скорочення дробу
    private void simplify() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    // Додавання дробів
    public Drib add(Drib other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Drib result = new Drib(newNumerator, newDenominator);
        result.simplify();
        return result;
    }

    // Віднімання дробів
    public Drib subtract(Drib other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Drib result = new Drib(newNumerator, newDenominator);
        result.simplify();
        return result;
    }

    // Множення дробів
    public Drib multiply(Drib other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        Drib result = new Drib(newNumerator, newDenominator);
        result.simplify();
        return result;
    }

    // Ділення дробів
    public Drib divide(Drib other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        Drib result = new Drib(newNumerator, newDenominator);
        result.simplify();
        return result;
    }

    // Перевизначення toString() для зручного виводу
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Приклад використання
    public static void main(String[] args) {
        Drib drib1 = new Drib();
        Drib drib2 = new Drib();

        Drib sum = drib1.add(drib2);
        System.out.println("Сума: " + sum);

        Drib difference = drib1.subtract(drib2);
        System.out.println("Різниця: " + difference);

        Drib product = drib1.multiply(drib2);
        System.out.println("Добуток: " + product);

        Drib quotient = drib1.divide(drib2);
        System.out.println("Частка: " + quotient);
    }
}
