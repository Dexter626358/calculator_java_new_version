import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class UserInterface {
    static Scanner scan = new Scanner(System.in);

    public static void menu() {
        System.out.println("Калькулятор умеет выполнять операции над действительными и комплексными числами");
        System.out.println("Введите операцию:\n 1. Сложение.\n 2. Вычитание.\n 3. Умножение.\n 4. Деление.\n 5. Выход.");
    }

    public void UserChoose() throws IOException {
        Logger logger = Logger.getLogger(UserInterface.class.getName());
        FileHandler fh = new FileHandler("calclogger.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("Начало работы калькулятора");
        boolean flag = true;
        while (flag) {
            String[] numbers;
            numbers = getNumber();
            String number1 = numbers[0];
            String number2 = numbers[1];
            logger.info(String.format("Пользователь ввел %s и %s", number1, number2));
            if (Checker.isNumeric(number1) || Checker.isComplex(number1) || Checker.isInteger(number1) || Checker.isNumeric(number2) || Checker.isComplex(number2) || Checker.isInteger(number2)) {
                menu();
                String operation = scan.nextLine();
                Printer printer = new Printer();
                switch (operation) {
                    case "1": {
                        logger.info("Пользователь выбрал операцию сложения");
                        SumNumbers sum = new SumNumbers();
                        if (Checker.isInteger(number1) && Checker.isInteger(number2)) {
                            printer.printer(sum.getSum(ParseNumbers.getInt(number1), ParseNumbers.getInt(number2)));
                        } else if (Checker.isInteger(number1) && Checker.isNumeric(number2)) {
                            printer.printer(sum.getSum(ParseNumbers.getInt(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isNumeric(number1) && Checker.isInteger(number2)) {
                            printer.printer(sum.getSum(ParseNumbers.getDouble(number1), ParseNumbers.getInt(number2)));
                        } else if ((Checker.isNumeric(number1) && Checker.isNumeric(number2))) {
                            printer.printer(sum.getSum(ParseNumbers.getDouble(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isComplex(number1) && Checker.isComplex(number2)) {
                            ComplexParser complexParser = new ComplexParser();
                            Complex complex = new Complex(complexParser.ComplexSplit(number1)[0], complexParser.ComplexSplit(number1)[1]);
                            printer.printer(complex.plus(new Complex(complexParser.ComplexSplit(number2)[0], complexParser.ComplexSplit(number2)[1])).toString());
                        } else {
                            System.out.println("Я не умею складывать эти числа.");
                        }
                        break;
                    }
                    case "2": {
                        logger.info("Пользователь выбрал операцию вычитания");
                        SubstractNumbers diff = new SubstractNumbers();
                        if (Checker.isInteger(number1) && Checker.isInteger(number2)) {
                            printer.printer(diff.getDifference(ParseNumbers.getInt(number1), ParseNumbers.getInt(number2)));
                        } else if (Checker.isInteger(number1) && Checker.isNumeric(number2)) {
                            printer.printer(diff.getDifference(ParseNumbers.getInt(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isNumeric(number1) && Checker.isInteger(number2)) {
                            printer.printer(diff.getDifference(ParseNumbers.getDouble(number1), ParseNumbers.getInt(number2)));
                        } else if ((Checker.isNumeric(number1) && Checker.isNumeric(number2))) {
                            printer.printer(diff.getDifference(ParseNumbers.getDouble(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isComplex(number1) && Checker.isComplex(number2)) {
                            ComplexParser complexParser = new ComplexParser();
                            Complex complex = new Complex(complexParser.ComplexSplit(number1)[0], complexParser.ComplexSplit(number1)[1]);
                            printer.printer(complex.minus(new Complex(complexParser.ComplexSplit(number2)[0], complexParser.ComplexSplit(number2)[1])).toString());
                        } else {
                            System.out.println("Я не умею складывать эти числа.");
                        }
                        break;
                    }
                    case "3": {
                        logger.info("Пользователь выбрал операцию умножения");
                        MultiplyNumbers time = new MultiplyNumbers();
                        if (Checker.isInteger(number1) && Checker.isInteger(number2)) {
                            printer.printer(time.getTimes(ParseNumbers.getInt(number1), ParseNumbers.getInt(number2)));
                        } else if (Checker.isInteger(number1) && Checker.isNumeric(number2)) {
                            printer.printer(time.getTimes(ParseNumbers.getInt(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isNumeric(number1) && Checker.isInteger(number2)) {
                            printer.printer(time.getTimes(ParseNumbers.getDouble(number1), ParseNumbers.getInt(number2)));
                        } else if ((Checker.isNumeric(number1) && Checker.isNumeric(number2))) {
                            printer.printer(time.getTimes(ParseNumbers.getDouble(number1), ParseNumbers.getDouble(number2)));
                        } else if (Checker.isComplex(number1) && Checker.isComplex(number2)) {
                            ComplexParser complexParser = new ComplexParser();
                            Complex complex = new Complex(complexParser.ComplexSplit(number1)[0], complexParser.ComplexSplit(number1)[1]);
                            printer.printer(complex.times(new Complex(complexParser.ComplexSplit(number2)[0], complexParser.ComplexSplit(number2)[1])).toString());
                        } else {
                            System.out.println("Я не умею складывать эти числа.");
                        }
                        break;
                    }
                    case "4": {
                        logger.info("Пользователь выбрал операцию деления");
                        DivisionNumbers div = new DivisionNumbers();
                        if (number2.equals("0")) {
                            logger.warning("Деление на ноль");
                            printer.printer("Деление на ноль");
                        } else {
                            if (Checker.isInteger(number1) && Checker.isInteger(number2)) {
                                printer.printer(div.getDivision(ParseNumbers.getInt(number1), ParseNumbers.getInt(number2)));
                            } else if (Checker.isInteger(number1) && Checker.isNumeric(number2)) {
                                printer.printer(div.getDivision(ParseNumbers.getInt(number1), ParseNumbers.getDouble(number2)));
                            } else if (Checker.isNumeric(number1) && Checker.isInteger(number2)) {
                                printer.printer(div.getDivision(ParseNumbers.getDouble(number1), ParseNumbers.getInt(number2)));
                            } else if ((Checker.isNumeric(number1) && Checker.isNumeric(number2))) {
                                printer.printer(div.getDivision(ParseNumbers.getDouble(number1), ParseNumbers.getDouble(number2)));
                            } else if (Checker.isComplex(number1) && Checker.isComplex(number2)) {
                                ComplexParser complexParser = new ComplexParser();
                                Complex complex = new Complex(complexParser.ComplexSplit(number1)[0], complexParser.ComplexSplit(number1)[1]);
                                printer.printer(complex.divides(new Complex(complexParser.ComplexSplit(number2)[0], complexParser.ComplexSplit(number2)[1])).toString());
                            } else {
                                logger.warning("Некорректный ввод чисел");
                                System.out.println("Я не умею складывать эти числа.");
                            }
                            break;
                        }
                    }
                    case "5": {
                        logger.warning("Выход из программы");
                        printer.printer("Выход");
                        flag = false;
                        break;

                    }
                    default: {
                        logger.warning("Некорректный ввод.");
                        printer.printer("Некорректный ввод. Попробуйте еще раз");
                        break;
                    }
                }
            } else {
                logger.warning("Некорректный ввод.");
                System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }

    public String[] getNumber(){
        String[] numbers;
        System.out.println("Введите числа через пробел: ");
        numbers = scan.nextLine().split(" ");
        return numbers;
    }
}
