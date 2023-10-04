import java.util.Scanner;

public class Vector3D {
    private double x, y, z;

    // Конструктор
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Конструктор, що дозволяє вводити координати з клавіатури
    public Vector3D() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть координату x: ");
        this.x = scanner.nextDouble();
        System.out.print("Введіть координату y: ");
        this.y = scanner.nextDouble();
        System.out.print("Введіть координату z: ");
        this.z = scanner.nextDouble();
    }

    // Методи додавання та віднімання векторів
    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3D subtract(Vector3D other) {
        return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    // Скалярний добуток
    public double dotProduct(Vector3D other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Множення на скаляр
    public Vector3D multiply(double scalar) {
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    // Порівняння векторів
    public boolean equals(Vector3D other) {
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }

    // Обчислення довжини вектора
    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    // Порівняння довжини векторів
    public int compareMagnitude(Vector3D other) {
        double thisMagnitude = this.magnitude();
        double otherMagnitude = other.magnitude();

        if (thisMagnitude < otherMagnitude) return -1;
        else if (thisMagnitude > otherMagnitude) return 1;
        else return 0;
    }

    // Перевизначення toString() для зручного виводу
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    // Приклад використання
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D();
        Vector3D v2 = new Vector3D();

        System.out.println("v1 + v2 = " + v1.add(v2));
        System.out.println("v1 - v2 = " + v1.subtract(v2));
        System.out.println("v1 * v2 = " + v1.dotProduct(v2));
        System.out.println("v1 * 2 = " + v1.multiply(2));
        System.out.println("Magnitude of v1 = " + v1.magnitude());
        System.out.println("Magnitude of v2 = " + v2.magnitude());
        System.out.println("Comparison of magnitudes: " + v1.compareMagnitude(v2));
    }
}
