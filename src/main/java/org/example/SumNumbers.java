public class SumNumbers {

    public String getSum (int num1, int num2) {
        return String.format("Результат сложения %d и %d равен %d", num1, num2, num1 + num2);
    }

    public String getSum (double num1, double num2) {
        return String.format("Результат сложения %f и %f равен %f", num1, num2, num1 + num2);
    }

    public String getSum (double num1, int num2) {
        return String.format("Результат сложения %f и %d равен %f", num1, num2, num1 + num2);
    }

    public String getSum (int num1, double num2) {
        return String.format("Результат сложения %d и %f равен %f", num1, num2, num1 + num2);
    }


}
