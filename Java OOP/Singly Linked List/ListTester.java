public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);
        sll.printValues();
        sll.add(4);
        sll.printValues();
        sll.add(10);
        sll.printValues();
        sll.add(5);
        sll.printValues();
        sll.add(15);
        sll.printValues();
        sll.add(2);
        sll.printValues();
        sll.remove();
        sll.printValues();
        sll.remove();
        sll.printValues();
        Node n= sll.find(10);
        if(n.value==-1){
            System.out.println("there is no node with this value!!");

        }
        else{
            System.out.println("the wanted node value is: "+n.value);
        }
        Node n1= sll.find(4);
        if(n1.value==-1){
            System.out.println("there is no node with this value!!");

        }
        else{
            System.out.println("the wanted node value is: "+n1.value);
        }
        Node n2= sll.find(0);
        if(n2.value==-1){
            System.out.println("there is no node with this value!!");

        }
        else{
            System.out.println("the wanted node value is: "+n2.value);
        }
        sll.removeAt(0);
        sll.printValues();
    }
}