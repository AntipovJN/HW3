import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        int[] x = mergeArrays(new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000},new int[] {1, 3, 5, 7, 8,10,10});
        for (int i:x) {
            System.out.print(i + ",");
        }
        String [] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
        robotMove(new Robot(),-2,-2);
        System.out.println(factorial(13));
        System.out.println(isPalindrome("Madam, I'm Adam!") ? "t" : "f");
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString()); //Hello!
        System.out.println("Размер её - " + answer.length()); //6
        System.out.println("Символ под № 1 - " + answer.charAt(1)); //e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5)); //ello --> проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString()); //Hello!
        example[0] = 74;
        System.out.println(answer.toString()); //Hello!
        ComplexNumber firstNumber = new ComplexNumber(123,321);
        ComplexNumber secondNumber = new ComplexNumber(123, 321);
        ComplexNumber thirdNumber = new ComplexNumber(213, 321);
        System.out.println(firstNumber.equals(secondNumber) + " " + firstNumber.toString() + " equals " + secondNumber.toString());
        System.out.println(firstNumber.equals(thirdNumber) + " " + firstNumber.toString() + " !equals " + thirdNumber.toString());
        String text = " spam bad";
        String[] spam = {"spam", "bad"};
        System.out.println(checkLabels(new TextAnalyzer[]{new NegativeTextAnalyzer(), new SpamAnalyzer(spam),new TooLongTextAnalyzer(30)}, text));

    }

    public static boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder(text.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
        String handledText = stringBuilder.toString();
        String reverseText = stringBuilder.reverse().toString();
        return handledText.equals(reverseText);
    }

    private static BigInteger factorial(int value) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    private static void robotMove (Robot robot, int toX, int toY) {
        if (robot.getX() < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                if (robot.getDirection().equals(Direction.DOWN)) {
                    robot.turnLeft();
                } else {
                  robot.turnRight();
                }
            }
            while (robot.getX() < toX) {
                robot.stepForward();
            }
        } else if (robot.getX() > toX) {
            while (robot.getDirection() != Direction.LEFT) {
                if (robot.getDirection().equals(Direction.UP)) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }
            while (robot.getX() > toX) {
                robot.stepForward();
            }
        }
        if (robot.getY() > toY) {
            while (robot.getDirection() != Direction.DOWN) {
                if (robot.getDirection().equals(Direction.RIGHT)) {
                    robot.turnRight();
                } else {
                robot.turnLeft();
                }
            }
            while (robot.getY() > toY) {
                robot.stepForward();
            }
        }
        if (robot.getY() < toY) {
            while (robot.getDirection() != Direction.UP) {
                if (robot.getDirection().equals(Direction.LEFT)) {
                    robot.turnRight();
                } else {
                    robot.turnRight();
                }
            }
            while (robot.getY() < toY) {
                robot.stepForward();
            }
        }

    }



    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        for (String s:roles) {
            sb.append(s).append(":\n");
            for (int x = 0; x < textLines.length; x++) {
                if (textLines[x].startsWith(s + ":")) {
                    sb.append(x + 1).append(")").append(textLines[x].substring(textLines[x].indexOf(':') + 1)).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }



    private static int[] mergeArrays(int[] a1, int[] a2) {
        int[] mergeArray = new int[a1.length + a2.length];
        for (int i = 0, k = 0, n = 0; i < mergeArray.length; i++) {
            if (k > a1.length - 1) {
                mergeArray[i] = a2[n];
                n++;
            } else if (n > a2.length - 1) {
                mergeArray[i] = a1[k];
                k++;
            } else if (a1[k] < a2[n]) {
                mergeArray[i] = a1[k];
                k++;
            } else {
                mergeArray[i] = a2[n];
                n++;
            }
        }

        return mergeArray;
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
            for (TextAnalyzer analyzer: analyzers) {
                if (analyzer.processText(text) != Label.OK) {
                    return analyzer.processText(text);
                }
            }
        return Label.OK;
    }
}
