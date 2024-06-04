public class BinaryTreeMain13 {
    public static void main(String[] args) {
        BinaryTree13 bt = new BinaryTree13();
        bt.addRecursive(6);
        bt.addRecursive(4);
        bt.addRecursive(8);
        bt.addRecursive(3);
        bt.addRecursive(5);
        bt.addRecursive(7);
        bt.addRecursive(9);
        bt.addRecursive(10);
        bt.addRecursive(15);

        System.out.print("PreOrder Traversal: ");
        bt.traversePreOrder(bt.root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        bt.traverseInOrder(bt.root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        bt.traversePostOrder(bt.root);
        System.out.println();

        System.out.println("Find Node 5: " + bt.find(5));
        System.out.println("Delete Node 8");
        bt.delete(8);

        System.out.println();
        System.out.print("PreOrder Traversal: ");
        bt.traversePreOrder(bt.root);
        System.out.println();

        // Display smallest and largest values
        System.out.println("Smallest Value: " + bt.findMinValue());
        System.out.println("Largest Value: " + bt.findMaxValue());

        // Display leaf nodes
        System.out.print("Leaf Nodes: ");
        bt.displayLeafNodes();
        System.out.println();

        // Count leaf nodes
        System.out.println("Number of Leaf Nodes: " + bt.countLeafNodes());
    }
}