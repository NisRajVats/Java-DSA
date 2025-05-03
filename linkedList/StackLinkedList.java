public class StackLinkedList {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public StackLinkedList(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public StackLinkedList() {
        top = null;
        height = 0;
    }

    public void print() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Add an item to the top of the stack (push operation)
    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // Remove an item from the top of the stack (pop operation)
    public Node pop() {
        if (height == 0) return null;
        
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        
        return temp;
    }

    // Get the top item without removing it (peek operation)
    public Node peek() {
        return top;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return height == 0;
    }

    // Get the number of items in the stack
    public int size() {
        return height;
    }

    // Clear the stack
    public void clear() {
        top = null;
        height = 0;
    }

    // Check if the stack contains a specific value
    public boolean contains(int value) {
        Node current = top;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get the top value (without removing the node)
    public Integer getTop() {
        if (top == null) return null;
        return top.value;
    }
    
    // Search for a value and return its distance from the top (0-based)
    // Returns -1 if the value is not found
    public int search(int value) {
        Node current = top;
        int distance = 0;
        
        while (current != null) {
            if (current.value == value) {
                return distance;
            }
            current = current.next;
            distance++;
        }
        
        return -1;
    }
}