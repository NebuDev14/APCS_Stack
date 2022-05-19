import java.util.Stack;

public class StackExpTestDay1 {
    public static double evalAns(String expression) {
        Stack<String> postfix = new Stack<String>();
        for (int i = 0; i < expression.length(); i++) {
            if (checkUnary(expression.substring(i, i + 1))) {
                double val = factorial(Double.valueOf(postfix.pop()));
                postfix.push(String.valueOf(val));
            } else if (!checkOperator(expression.substring(i, i + 1))) {
                postfix.push(expression.substring(i, i + 1));
            } else {
                postfix.push(performOperation(Double.valueOf(postfix.pop()), Double.valueOf(postfix.pop()),
                        expression.substring(i, i + 1)));
                System.out.println(postfix.peek());
            }
        }

        return Double.valueOf(postfix.peek());

    }

    public static double factorial(double n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public static boolean checkUnary(String exp) {
        return exp.equals("!");
    }

    public static boolean checkOperator(String exp) { // lmao
        return (exp.equals("*") || exp.equals("+") || exp.equals("-") || exp.equals("%") || exp.equals("/")
                || exp.equals("^"));
    }

    public static String performOperation(double n1, double n2, String operator) {
        double ans = 0;
        switch (operator) {
            case "+":
                ans = n1 + n2;
                break;
            case "-":
                ans = n2 - n1;
                break;
            case "*":
                ans = n1 * n2;
                break;
            case "%":
                ans = n2 % n1;
                break;
            case "/":
                ans = n2 / n1;
                break;
            case "^":
                ans = Math.pow(n2, n1);
                break;
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        double answer, yourAns;
        String exp;
        int c = 0, w = 0;

        exp = "256++";
        System.out.println("Testing Post-fix Single Digit Operation");
        System.out.println("Operations tested: +,-,*,/,%,^,!");
        System.out.println("Testing 2+5+6");
        System.out.print("Postfix equivalent " + exp + "...");
        answer = 13;
        yourAns = evalAns(exp);
        if (yourAns == answer) {
            System.out.println("Pass");
            c++;
        } else {
            System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
            w++;
        }

        System.out.println();
        exp = "256*+9-";
        System.out.println("Testing 2+5*6-9");
        System.out.print("Postfix equivalent " + exp + "...");
        answer = 23;
        yourAns = evalAns(exp);
        if (yourAns == answer) {
            System.out.println("Pass");
            c++;
        } else {
            System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
            w++;
        }

        System.out.println();
        exp = "111+3^+2/";
        System.out.println("Testing (1+(1+1)^3)/2");
        System.out.print("Postfix equivalent " + exp + "...");
        answer = 4.5;
        yourAns = evalAns(exp);
        if (yourAns == answer) {
            System.out.println("Pass");
            c++;
        } else {
            System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
            w++;
        }

        System.out.println();
        exp = "12+3*23+%";
        System.out.println("Testing (1+2)*3%(2+3)");
        System.out.print("Postfix equivalent " + exp + "...");
        answer = 4;
        yourAns = evalAns(exp);
        if (yourAns == answer) {
            System.out.println("Pass");
            c++;
        } else {
            System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
            w++;
        }

        System.out.println();
        exp = "473%-!";
        System.out.println("Testing (4-7%3)!");
        System.out.print("Postfix equivalent " + exp + "...");
        answer = 6;
        yourAns = evalAns(exp);
        if (yourAns == answer) {
            System.out.println("Pass");
            c++;
        } else {
            System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
            w++;
        }

        System.out.println();
        System.out.println("Number of correct answer: " + c);
        System.out.println("Number of incorect answer: " + w);
        System.out.println("Accuracy: " + Math.round((double) c / (c + w) * 100) / 100 + "%");
    }
}
