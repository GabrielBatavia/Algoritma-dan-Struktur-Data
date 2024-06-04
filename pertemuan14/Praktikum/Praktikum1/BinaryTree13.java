public class BinaryTree13 {
    Node13 root;

    public BinaryTree13() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Method to add a node recursively
    public void addRecursive(int data) {
        root = addRecursive(root, data);
    }

    private Node13 addRecursive(Node13 current, int data) {
        if (current == null) {
            return new Node13(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // Data already exists
            return current;
        }

        return current;
    }

    // Method to find the smallest value
    public int findMinValue() {
        return findMinValue(root);
    }

    private int findMinValue(Node13 current) {
        return current.left == null ? current.data : findMinValue(current.left);
    }

    // Method to find the largest value
    public int findMaxValue() {
        return findMaxValue(root);
    }

    private int findMaxValue(Node13 current) {
        return current.right == null ? current.data : findMaxValue(current.right);
    }

    // Method to display leaf nodes
    public void displayLeafNodes() {
        displayLeafNodes(root);
    }

    private void displayLeafNodes(Node13 node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(" " + node.data);
        }
        displayLeafNodes(node.left);
        displayLeafNodes(node.right);
    }

    // Method to count the number of leaf nodes
    public int countLeafNodes() {
        return countLeafNodes(root);
    }

    private int countLeafNodes(Node13 node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }

    public boolean find(int data) {
        boolean result = false;
        Node13 current = root;
        while (current != null) {
            if (current.data == data) {
                result = true;
                break;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    // Pre-order traversal
    public void traversePreOrder(Node13 node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // In-order traversal
    public void traverseInOrder(Node13 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    // Post-order traversal
    public void traversePostOrder(Node13 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    public Node13 getSuccessor(Node13 del) {
        Node13 successor = del.right;
        Node13 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }

        Node13 parent = root;
        Node13 current = root;
        boolean isLeftChild = false;
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        }

        // Case 1: Node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
        // Case 2: Node to be deleted has one child (right)
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: Node to be deleted has one child (left)
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 4: Node to be deleted has two children
        else {
            Node13 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }
}