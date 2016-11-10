
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String input = "2*(3*4-5)";
        LinkedList postfix = new LinkedList();
        String[] array = new String[input.length()];
        Stack <String> s = new Stack <String> ();
        System.out.println("Input " + input);
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(input.charAt(i));
        }

        for (int i = 0; i < array.length; i++) {
            String pointer = array[i];
            System.out.println("Pointer: " + pointer);

            if (array[i].matches("[( ) + * / -]")) {
                String operand = array[i];
              whatToDo(s, postfix, pointer, operand);
            } else {
                postfix.add(pointer);
            }
        }
        // Pop the stack
        while(!(s.isEmpty())){
            postfix.add(s.peek());
            s.pop();
        }
        System.out.println("postfix: " + postfix.toString());
        PostfixToSolution postfixToSolution = new PostfixToSolution();
    }
    private static void whatToDo(Stack<String> s, LinkedList postfix, String pointer, String operand) {
        if(s.isEmpty()){
            s.push(operand);
        }
        else {
            String topOfStack = s.peek();
            System.out.println("            Pointer: " + pointer + "\n" + "topOfStack: "  + topOfStack);
            if (getHigherPriority(topOfStack) > getHigherPriority(pointer)) {
                postfix.add(topOfStack);
                s.push(pointer);
            }
        }
    }

    private static int getHigherPriority(String op) {
        switch (op) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
            case "^":
                return 2;
            case "(":
            case ")":
                return 3;
            default:
                throw new IllegalArgumentException("Operator unknown: " + op);
        }
    }
}


