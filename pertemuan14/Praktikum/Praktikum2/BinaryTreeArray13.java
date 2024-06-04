package Praktikum.Praktikum2;
public class BinaryTreeArray13 {
    int[] data;
    int idxLast;

    public BinaryTreeArray13() {
        data = new int[10];
    }

    void populateData(int[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != 0) { 
            traverseInOrder(2 * idxStart + 1);
            System.out.print(data[idxStart] + " ");
            traverseInOrder(2 * idxStart + 2); 
        }
    }
}
