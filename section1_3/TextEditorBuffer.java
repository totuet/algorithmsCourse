package section1_3;

/*
Text editor buffer. Develop a data type for a buffer in a text editor that implements the following API:
public class Buffer
Buffer() create an empty buffer
void insert(char c) insert c at the cursor position
char delete() delete and return the character at the cursor
void left(int k) move the cursor k positions to the left
void right(int k) move the cursor k positions to the right
int size() number of characters in the buffer
API for a text buffer
Hint : Use two stacks.
 */

import java.util.Stack;

public class TextEditorBuffer {
    private Stack<Character> stack1;
    private Stack<Character> stack2;


    //create empty buffer
    public TextEditorBuffer() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // insert c at cursor position
    public void insert(char c) {
        stack1.push(c);
    }


    //delete and return char at cursor
    public char delete() {
        return stack1.pop();
    }


    //move cursor k positions to left
    public void left(int k) {
        for (int i = 0; i < k; i++) {
            if (stack1.size() != 0 ) {
                stack2.push(stack1.pop());
            }
        }
    }


    //move cursor k positions to right
    public void right(int k) {
        for (int i = 0; i < k; i++) {
            if (stack2.size() != 0 ) {
                stack1.push(stack2.pop());
            }
        }
    }

    //number of chars in buffer
    public int size(){
        return stack1.size() + stack2.size();
    }

    public void printBuffer(){
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.forEach(System.out::print);
        System.out.println();
    }


    public static void main(String[] args) {
        TextEditorBuffer buff = new TextEditorBuffer();
        String string = "Hello World";
        for (char c : string.toCharArray()) {
            buff.insert(c);
        }
        buff.printBuffer();
        buff.left(4);
        buff.delete();
        buff.insert('T');
        buff.right(2);
        buff.delete();
        buff.insert('a');
        buff.right(1);
        buff.delete();
        buff.insert('s');
        buff.right(1);
        buff.delete();
        buff.insert('t');
        buff.printBuffer();


    }
}
