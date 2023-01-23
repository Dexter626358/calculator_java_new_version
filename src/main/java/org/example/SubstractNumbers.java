public class SubstractNumbers {
    public String getDifference (int num1, int num2) {
        return String.format("Разность %d и %d равна %d", num1, num2, num1 - num2);
    }

    public String getDifference (double num1, double num2) {
        return String.format("Разность %f и %f равна %f", num1, num2, num1 - num2);
    }

    public String getDifference (double num1, int num2) {
        return String.format("Разность %f и %d равна %f", num1, num2, num1 - num2);
    }

    public String getDifference (int num1, double num2) {
        return String.format("Разность %d и %f равна %f", num1, num2, num1 - num2);
    }

}
