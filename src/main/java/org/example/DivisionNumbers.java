public class DivisionNumbers {
    public String getDivision (int num1, int num2) {
        return String.format("Частное %d и %d равна %f", num1, num2, (double) num1 / num2);
    }

    public String getDivision (double num1, double num2) {
        return String.format("Частное %f и %f равна %f", num1, num2, num1 / num2);
    }

    public String getDivision (double num1, int num2) {
        return String.format("Частное %f и %d равна %f", num1, num2, num1 / num2);
    }

    public String getDivision (int num1, double num2) {
        return String.format("Частное %d и %f равна %f", num1, num2, num1 / num2);
    }

}
