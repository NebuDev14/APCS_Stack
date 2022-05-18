import java.util.Stack;

public class StackExpTestDay1 {
  public static double evalExp(String expression) {
    Stack<String> postfix = new Stack<String>();
    for (int i = 0; i < expression.length(); i++) {
        if (checkUnary(expression.substring(i, i + 1))) {
            double val = factorial(Double.valueOf(expression.substring(i, i+1)));
            postfix.push(String.valueOf(val));
        }
        else if (!checkOperator(expression.substring(i, i + 1))) {
            postfix.push(expression.substring(i, i + 1));
        } 
        else {
            postfix.push(performOperation(Double.valueOf(postfix.pop()), Double.valueOf(postfix.pop()),expression.substring(i, i + 1)));
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
}
