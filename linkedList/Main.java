class Main {
    public static void main(String[] args) {
        LinkedList  myList = new LinkedList (4);
        myList.append(8);
        myList.append(10);
        myList.append(14);
        myList.prepend(18);
        myList.prepend(24);
        myList.prepend(16);
        myList.removeLast();
        myList.removeFirst();
        
        
        System.out.println("The element is :" + myList.get(3).value); 
        myList.set(2,6);
        myList.insert(2, 20);
        myList.remove(5);
        myList.print();
        

    }
}