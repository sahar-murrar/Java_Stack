public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head=null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    public void remove(){
        if(head == null) {
            System.out.println("The List is Empty, there us nothing to remove!!");
        }
        else if(head.next==null){
            this.head=null;

        }
        else{
            Node current = new Node(this.head.value);
            current= this.head;
            while(current.next != null){
                if(current.next.next == null){
                    current.next=null;
                    break;
                }
                current= current.next;
            }
        }
    }
    public void printValues(){
        Node current = new Node(this.head.value);
        current=this.head;
            
        if(head == null) {    
            System.out.println("The List is empty");        
        }    
        System.out.println("Singly linked list nodes Values: ");    
        while(current != null) {      
            System.out.print(current.value + " ");    
            current = current.next;    
        }    
        System.out.println();    
    } 
    public Node find(int value){
        Node current = new Node(this.head.value);
        current=this.head;
         if(head == null) {    
            System.out.println("The List is empty");     
            return null;   
        } 
        else if(head.next==null){
            return this.head;

        }
        else{
            Node temp = new Node(this.head.value);
            Node notFound= new Node(this.head.value);
         while(current.next != null){
             if(current.value == value){
                 temp=current;
                 return current;
             }
                current= current.next;
            }
            notFound.value=-1;
            return notFound;
        }

    } 
    public void removeAt(int n){
        Node current = new Node(this.head.value);
        current=this.head;
        Node current1 = new Node(this.head.value);
        current1=this.head;
        int count=0;
        int count1=0;
        //traversing throught the list to count how many nodes we have in it
        while(current1.next != null) {      
            count1 +=1;
            current1 = current1.next;    
        } 
        if(n> count1){
            System.out.println("There is no such this number in the list!! please enter a smaller number.");
        }   
        else if(n==0){
            this.head=this.head.next;
            current.next=null;
        }
        else if(current.next == null){
            this.remove();
        }
        else{
            while(current != null){
                count +=1;
                if(count == n){
                    Node t= new Node(3);
                    t=current.next;
                    current.next= current.next.next;
                    t.next=null;

                }
                current= current.next;
            }
        }
        

        
    }  

}