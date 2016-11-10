
import java.util.EmptyStackException;

public class oscarArrayStack <E> {

    private int top;
    private E[] array;

    /* no-arguments default constructor creates an empty stack */
    @SuppressWarnings("unchecked")

    public oscarArrayStack(int userInputlength) {
        top = -1;		// empty stack
        array = (E []) (new Object[userInputlength]);  // the array size is fixed,
        //just get the length of the expression
    }

    // this returns if the stack is empty, not neccessary for
    // this assignment but handy to have for future purposes.
    public boolean empty() {

        return (top == -1);

    }


    // push to stack

    public void push(E value) {
		/* make sure there is room in the array */
        if (array.length == top + 1) {
            array = java.util.Arrays.copyOf(array, array.length * 2);
        } // else, there already is room for one new element
        top++;
        array[top] = value;
    }

    /* @return	the top value on the stack */
    public E pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        E result = array[top];
        top--;
        return result;
    }


    /* @return	the top value on the stack */
    public E peek() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

	    /* convert the stack to a printable string
	     * @return	a string representing the stack
	     */

    // Prints the stack
    void print(oscarArrayStack storage)
    {
        while(!empty())
        {
            System.out.println(storage.peek());
            storage.pop();
        }
    }
}