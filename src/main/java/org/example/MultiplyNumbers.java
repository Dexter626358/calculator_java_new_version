public class MultiplyNumbers {
    public String getTimes (int num1, int num2) {
        return String.format("Произведение %d и %d равна %d", num1, num2, num1 * num2);
    }

    public String getTimes (double num1, double num2) {
        return String.format("Произведение %f и %f равна %f", num1, num2, num1 * num2);
    }

    public String getTimes (double num1, int num2) {
        return String.format("Произведение %f и %d равна %f", num1, num2, num1 * num2);
    }

    public String getTimes (int num1, double num2) {
        return String.format("Произведение %d и %f равна %f", num1, num2, num1 * num2);
    }



}
