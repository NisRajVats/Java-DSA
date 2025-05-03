// first moves n+1 steps ahead.

// second stops at the node before the one we want to remove.

// Works even when removing the first node.


public class List {

    private Node head;
    private Node tail;

    class Node {
        int value; 
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public List(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

	public Node findKthFromEnd(int k)
	{
	    if (head == null || k <= 0) return null;
	    Node first = head;
	    Node second = head;
	    
	    for (int i =0 ; i<k ; i++)
	    {
	        if (first == null) return null;
	        first = first.next;
	    }
	    while(first != null)
	    {
	        first =first.next;
	        second = second.next ;
	    }
	    
	    return second;
	    
	    
	}

}

