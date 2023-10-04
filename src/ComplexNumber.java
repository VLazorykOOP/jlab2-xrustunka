import java.util.Scanner;

public class ComplexNumber {
    private double real;
    private double imaginary;

    // Конструктор
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Конструктор, що дозволяє вводити комплексне число з клавіатури
    public ComplexNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть дійсну частину: ");
        this.real = scanner.nextDouble();
        System.out.print("Введіть уявну частину: ");
        this.imaginary = scanner.nextDouble();
    }

    // Знаходження модуля комплексного числа
    public double modulus() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    // Знаходження аргументу комплексного числа
    public double argument() {
        return Math.atan2(imaginary, real);
    }

    // Додавання комплексних чисел
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Віднімання комплексних чисел
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imaginary - other.imaginary);
    }

    // Множення комплексних чисел
    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Ділення комплексних чисел
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    // Комплексне спряження
    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    // Перевизначення toString() для зручного виводу
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    // Приклад використання
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber();
        ComplexNumber num2 = new ComplexNumber();

        System.out.println("num1 + num2 = " + num1.add(num2));
        System.out.println("num1 - num2 = " + num1.subtract(num2));
        System.out.println("num1 * num2 = " + num1.multiply(num2));
        System.out.println("num1 / num2 = " + num1.divide(num2));
        System.out.println("Conjugate of num1 = " + num1.conjugate());
        System.out.println("Modulus of num1 = " + num1.modulus());
        System.out.println("Argument of num1 = " + num1.argument());
    }
}
