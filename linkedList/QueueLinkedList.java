public class QueueLinkedList {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public QueueLinkedList(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public QueueLinkedList() {
        first = null;
        last = null;
        length = 0;
    }

    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Add an item to the end of the queue (enqueue operation)
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    // Remove an item from the front of the queue (dequeue operation)
    public Node dequeue() {
        if (length == 0) return null;
        
        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    // Get the first item in the queue without removing it
    public Node peek() {
        return first;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return length == 0;
    }

    // Get the number of items in the queue
    public int size() {
        return length;
    }

    // Clear the queue
    public void clear() {
        first = null;
        last = null;
        length = 0;
    }

    // Check if the queue contains a specific value
    public boolean contains(int value) {
        Node current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get the first value (without removing the node)
    public Integer getFirst() {
        if (first == null) return null;
        return first.value;
    }

    // Get the last value (without removing the node)
    public Integer getLast() {
        if (last == null) return null;
        return last.value;
    }
}