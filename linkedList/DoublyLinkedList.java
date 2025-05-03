public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.prev;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        
        Node temp = tail;
        
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        
        Node temp = head;
        
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        
        return temp;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= length) return null;
        
        Node temp;
        if (index < length/2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean setNode(int index, int value) {
        Node temp = getNode(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insertNode(int index, int value) {
        if (index < 0 || index > length) return false;
        
        if (index == 0) {
            prepend(value);
            return true;
        }
        
        if (index == length) {
            append(value);
            return true;
        }
        
        Node newNode = new Node(value);
        Node before = getNode(index - 1);
        Node after = before.next;
        
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        
        length++;
        return true;
    }

    public Node removeNode(int index) {
        if (index < 0 || index >= length) return null;
        
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        
        Node temp = getNode(index);
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        
        temp.next = null;
        temp.prev = null;
        
        length--;
        
        return temp;
    }

    public int getLength() {
        return length;
    }

    public void reverse() {
        if (length <= 1) return;
        
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            // Store the previous node
            temp = current.prev;
            
            // Swap the next and prev pointers
            current.prev = current.next;
            current.next = temp;
            
            // Move to the next node (which is now current.prev because we swapped)
            current = current.prev;
        }
        
        // Swap head and tail
        temp = head;
        head = tail;
        tail = temp;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }
    
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }
    
    public Node getHead() {
        return head;
    }
    
    public Node getTail() {
        return tail;
    }
    
    public int getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.value;
    }
    
    public int getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.value;
    }
    
    public boolean contains(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) return true;
            temp = temp.next;
        }
        return false;
    }
}   