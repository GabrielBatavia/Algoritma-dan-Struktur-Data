/**
 * Postfix13
 */
public class Postfix13 {
    int n, top;
    char[] stack;

    public Postfix13(int total) {
        n = total;
        top = -1;
        stack = new char[n];
        push('(');
    }
    
    public void push (char c) {
        top++;
        stack[top] = c;
    }

    public char pop() {
        char item = stack[top];
        top--;
        return item;
    }

    public boolean isOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || 
            (c >= '0' && c <= '9') || c == ' ' || c == '.') {
            return true;
        } else {
            return false;
        }
    }
}