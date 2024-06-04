package Praktikum.Praktikum2;
public class BinaryTreeArray13 {
    int[] data;
    int idxLast;

    public BinaryTreeArray13() {
        data = new int[10];
        idxLast = -1;
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

    // Method to add data to the tree
    void add(int data) {
        if (idxLast < this.data.length - 1) {
            this.data[++idxLast] = data;
        } else {
            System.out.println("Tree is full!");
        }
    }

    // Pre-order traversal
    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != 0) {
            System.out.print(data[idxStart] + " ");
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    // Post-order traversal
    void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast && data[idxStart] != 0) {
            traversePostOrder(2 * idxStart + 1);
            traversePostOrder(2 * idxStart + 2);
            System.out.print(data[idxStart] + " ");
        }
    }
}