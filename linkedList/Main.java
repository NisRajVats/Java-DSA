
public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(10);

        myList.append(20);
        myList.append(30);
        myList.prepend(5);

        System.out.println("Initial list:");
        myList.print();

        System.out.println("\nReversed linkedList:");
        myList.reverse();
        myList.print();

        
    }

    
}
