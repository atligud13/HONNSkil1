/**
 * Created by Atli Guðlaugsson on 25/08/2015.
 * This is a basic calculator that reads from the input line and calculates
 * following the reverse polish notation.Supported operations are add, subtract
 * multiply, divide and factorial.
 */
import java.util.Scanner;
import java.util.Stack;
public class Calculator
{
    private Stack<String> stack = new Stack<String>();

    public Calculator() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            stack.push(scanner.next());
            evaluate(stack);
        }
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }

    public void evaluate(Stack<String> stack) {
        String token = stack.pop();

        /**
         * If the user typed in exit, we exit the program
         */
        if(token.equals("exit")) System.exit(0);

        /**
         * If the token is a number, we print the stack and return
         */
        if(isNumeric(token)) {
            stack.push(token);
            printStack(stack);
            return;
        }

        /**
         * Otherwise we perform an operation
         */
        String operators = "+-*/!";

        int index = operators.indexOf(token);

        /**
         * If the user typed something wrong in we print an error message but keep
         * the program running.
         */
        if(index == -1) {
            System.out.println("Error, input a number or an operand.");
            return;
        }

        int a = Integer.valueOf(stack.pop());
        int b = 0;

        /**
         * Handling factorials separately so that it can be performed
         * when only one value is on the stack
         */
        if(index == 4){
            int result = 1;
            for(int i = a; i > 0; i--) {
                result *= i;
            }
            stack.push(String.valueOf(result));
        }
        else {
            b = Integer.valueOf(stack.pop());
        }
        switch(index){
            case 0:
                stack.push(String.valueOf(a + b));
                break;
            case 1:
                stack.push(String.valueOf(a - b));
                break;
            case 2:
                stack.push(String.valueOf(a * b));
                break;
            case 3:
                stack.push(String.valueOf(a / b));
                break;
            case 4:
                // factorial already handled
                break;
        }

        /**
         * If we got this far then we call evaluate again so that
         * the next sequence can be handled.
         */
        evaluate(stack);
    }

    public void printStack(Stack<String> stack) {
        System.out.print("[");
        if(!stack.isEmpty()) System.out.print(stack.elementAt(0));
        for(int i = 1; i < stack.size(); ++i){
            System.out.print(", " + stack.elementAt(i));
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * Helper function that I found on StackOverFlow
     * Determines whether the string is a number or not
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}

