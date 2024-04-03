public class StackKonversi13 {
    int size;
    int[] tumpukanBiner;
    int top;

    public StackKonversi13() {
        this.size = 32;
        tumpukanBiner = new int[size];
        top = -1;
    }

    public boolean isEmpety() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
}
