/**
 * Created by Atli Guðlaugsson on 25/08/2015.
 * This is a basic calculator that reads from the input line and calculates
 * following the reverse polish notation.Supported operations are add, subtract
 * multiply, divide and factorial.
 */
import java.io.Console;
import java.util.Scanner;
import java.util.Stack;
public class Calculator
{
    private Stack<String> stack = new Stack<String>();

    public Calculator() {
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        evaluate(answer);
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }

    public void evaluate(String token) {

        if(token.equals("exit")) System.exit(0);

        String operators = "+-*/!";

        if(!operators.contains(token))
        {
            stack.push(token);
        }
        else
        {
            int index = operators.indexOf(token);
            int a = Integer.valueOf(stack.pop());
            int b = 0;
            if(index == 4){
                factorial(a);
            }
            else {
                b = Integer.valueOf(stack.pop());
            }
            switch(index){
                case 0:
                    plus(a, b);
                    break;
                case 1:
                    minus(a, b);
                    break;
                case 2:
                    multiplication(a, b);
                    break;
                case 3:
                    division(a, b);
                    break;
                case 4:
                    // factorial already handled
                    break;
            }
        }
    }

    public void plus(int a, int b){

    }

    public void minus(int a, int b){

    }

    public void multiplication(int a, int b){

    }

    public void division(int a, int b){

    }

    public void factorial(int a){

    }
}

