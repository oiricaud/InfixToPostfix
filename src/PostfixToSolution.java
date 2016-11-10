import java.util.Scanner;

public class PostfixToSolution {

    PostfixToSolution(){
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        System.out.println("Type in expression");

        String userInput = input.next();
        if(!userInput.equalsIgnoreCase("quit")){
            oscarArrayStack<Comparable> arrayStack = new oscarArrayStack<Comparable> (userInput.length());
            for (int i = 0; i < userInput.length(); i++){
                char splitter = userInput.charAt(i);

                if (Character.isDigit(splitter)) {
                    arrayStack.push(userInput.charAt(i));

                }

                if (splitter == '*'|| (splitter == '/' || (splitter == '-' || (splitter == '+' ||
                        (splitter == '^')))))
                {
                    arrayStack.push(splitter);
                    arrayStack.pop();
                    int a = Integer.parseInt(String.valueOf(arrayStack.pop()));
                    int b = Integer.parseInt(String.valueOf(arrayStack.pop()));
                    //arrayStack.push(operation(splitter, a, b));
                    //System.out.println("Value of a:" + a);
                    //System.out.println("Value of b:" + b);
                    arrayStack.push(operation(splitter, a, b));
                }
            }
            arrayStack.print(arrayStack);
            System.out.println("Result of stack using the Array Stack implementation: " );

        }
        else
            System.out.println("terminated, like the terminator.");
    }


    private static int operation(Object peek, int a, int b) {

        if (peek.equals('*')) {
            int total = a * b;
            return (total);
        }

        if (peek.equals('/')) {
            int total = a / b;
            return (total);
        }
        if (peek.equals('-')) {
            int total = b - a;
            return (total);
        }

        if (peek.equals('+')) {
            int total = a + b;
            return (total);
        }
        if (peek.equals('^')) {
            int total = (int) Math.pow(a, b);
            return (total);
        }
        else
            return b;
    }
}
