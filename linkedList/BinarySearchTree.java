public class BinarySearchTree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    // Insert a value into the BST
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        
        Node temp = root;
        while (true) {
            // Return false if value already exists
            if (value == temp.value) return false;
            
            // Go left if value is less than current node
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } 
            // Go right if value is greater than current node
            else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    // Check if a value exists in the BST
    public boolean contains(int value) {
        if (root == null) return false;
        
        Node temp = root;
        while (temp != null) {
            // Go left if value is less than current node
            if (value < temp.value) {
                temp = temp.left;
            } 
            // Go right if value is greater than current node
            else if (value > temp.value) {
                temp = temp.right;
            } 
            // Found the value
            else {
                return true;
            }
        }
        // Value not found
        return false;
    }

    // Find the minimum value in the BST
    public Integer findMin() {
        if (root == null) return null;
        
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.value;
    }

    // Find the maximum value in the BST
    public Integer findMax() {
        if (root == null) return null;
        
        Node temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.value;
    }

    // Get the root node
    public Node getRoot() {
        return root;
    }

    // Check if the BST is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Clear the BST
    public void clear() {
        root = null;
    }

    // Delete a node with the specified value
    public boolean remove(int value) {
        if (root == null) return false;
        
        Node currentNode = root;
        Node parentNode = null;
        
        // Find the node to delete
        while (currentNode != null && currentNode.value != value) {
            parentNode = currentNode;
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        
        // Return false if the value is not found
        if (currentNode == null) return false;
        
        // Case 1: Node to delete has no children (leaf node)
        if (currentNode.left == null && currentNode.right == null) {
            // If it's the root node
            if (currentNode == root) {
                root = null;
            } 
            // If it's the left child of its parent
            else if (parentNode.left == currentNode) {
                parentNode.left = null;
            } 
            // If it's the right child of its parent
            else {
                parentNode.right = null;
            }
            return true;
        }
        
        // Case 2: Node to delete has only a right child
        else if (currentNode.left == null) {
            // If it's the root node
            if (currentNode == root) {
                root = currentNode.right;
            } 
            // If it's the left child of its parent
            else if (parentNode.left == currentNode) {
                parentNode.left = currentNode.right;
            } 
            // If it's the right child of its parent
            else {
                parentNode.right = currentNode.right;
            }
            return true;
        }
        
        // Case 3: Node to delete has only a left child
        else if (currentNode.right == null) {
            // If it's the root node
            if (currentNode == root) {
                root = currentNode.left;
            } 
            // If it's the left child of its parent
            else if (parentNode.left == currentNode) {
                parentNode.left = currentNode.left;
            } 
            // If it's the right child of its parent
            else {
                parentNode.right = currentNode.left;
            }
            return true;
        }
        
        // Case 4: Node to delete has both left and right children
        else {
            // Find the minimum value in the right subtree (successor)
            Node successorParent = currentNode;
            Node successor = currentNode.right;
            
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            
            // Replace the value of the node to delete with the successor's value
            currentNode.value = successor.value;
            
            // Remove the successor
            // If the successor is the direct right child of current node
            if (successorParent == currentNode) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            
            return true;
        }
    }

    // Get the height of the BST
    public int getHeight() {
        return calculateHeight(root);
    }
    
    private int calculateHeight(Node node) {
        if (node == null) return -1;
        
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Count the number of nodes in the BST
    public int size() {
        return countNodes(root);
    }
    
    private int countNodes(Node node) {
        if (node == null) return 0;
        
        return countNodes(node.left) + countNodes(node.right) + 1;
    }
    
    // Tree traversal methods
    
    // In-order traversal (Left, Root, Right)
    public void inOrderTraversal() {
        inOrder(root);
    }
    
    private void inOrder(Node node) {
        if (node == null) return;
        
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    
    // Pre-order traversal (Root, Left, Right)
    public void preOrderTraversal() {
        preOrder(root);
    }
    
    private void preOrder(Node node) {
        if (node == null) return;
        
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    // Post-order traversal (Left, Right, Root)
    public void postOrderTraversal() {
        postOrder(root);
    }
    
    private void postOrder(Node node) {
        if (node == null) return;
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    
    // Level-order traversal (Breadth-First Search)
    public void levelOrderTraversal() {
        // Using a simple array-based queue for this example
        // In a real implementation, you might use Java's Queue interface
        int height = getHeight();
        for (int i = 0; i <= height; i++) {
            printGivenLevel(root, i);
        }
    }
    
    private void printGivenLevel(Node node, int level) {
        if (node == null) return;
        
        if (level == 0) {
            System.out.print(node.value + " ");
        } else {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
    
    // Check if the tree is a valid BST
    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(Node node, int min, int max) {
        if (node == null) return true;
        
        // Check if current node's value is within valid range
        if (node.value <= min || node.value >= max) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isValidBST(node.left, min, node.value) && 
               isValidBST(node.right, node.value, max);
    }
}