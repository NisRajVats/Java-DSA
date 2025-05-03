


class LinkedList
{
    private Node head ;
    private Node tail;
    private int length ;
    
    class Node{
        int value;
        Node next;
        
        Node(int value)
        {
            this.value=value;
        }
    }
    
    public LinkedList(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length =1;
    }
    
    public void print()
    {
        Node temp = head ;
        while (temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    
    public boolean append(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head =newNode;
            tail= newNode;
        }else{
            tail.next = newNode;
            tail=newNode;
        }
        length++;
        return true;
    }
    
    public boolean prepend(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next =head;
            head = newNode;
        }
        length++;
        return true;
    }
    
    public Node removeLast()
    {
        Node temp = head;
        Node pre =head;
        if(length == 0) return null;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }
        
       
        while (temp.next != null){
            pre = temp;
            temp =temp.next;
        }
        tail = pre;
        pre.next = null;
        length --;
        return temp;
    }
    
    
    public Node removeFirst()
    {
        Node temp = head;
        if(length == 0) return null;
        if (length == 1) 
        {
            head = null;
            tail = null;
            length--;
            return temp;
        }
        
        head = head.next;
        temp.next =null;
        length--;
        return temp;
    }
    
    public Node get(int index)
    {
        if(index <0 || index >= length ) return null;
        Node temp =head;
        for (int i=0; i<index ; i++)
        {
            temp = temp.next;
        }
        return temp;
    }
    
    public boolean set(int index , int value)
    {
        if(index <0 || index >= length ) return false;
        
        Node temp = get(index);
        temp.value = value;
        return true;
    }
    
    public boolean insert(int index, int value) {
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
        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = newNode;
        newNode.next = temp;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;

    return temp;
    }
    
    public void reverse() {
        Node temp = head;
        head = tail;
        tail =temp;

        Node after = temp.next ;
        Node before = null;
        for(int i=0; i<length ; i++)
        {
           after = temp.next;
           temp.next=before;
           before = temp;
           temp=after; 
        }
        tail.next = null;
    }
    
    
    
}