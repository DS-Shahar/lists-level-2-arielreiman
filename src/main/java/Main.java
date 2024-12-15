public class Main {

    public static Node<Integer> createList(int[] a) {
        Node<Integer> h = new Node<>(-1);  
        Node<Integer> p = h;              
        Node<Integer> x;

        for (int i = 0; i < a.length; i++) {
            x = new Node<>(a[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return h.getNext(); 
    }
    public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> l3 = new Node<>(-1);
        Node<Integer> current = l3;    
        Node<Integer> head1 = l1;
        Node<Integer> head2 = l2;

        while (head1 != null && head2 != null) {
            if (head1.getValue() < head2.getValue()) {
                current.setNext(new Node<>(head1.getValue()));
                head1 = head1.getNext();
            } else {
                current.setNext(new Node<>(head2.getValue()));
                head2 = head2.getNext();
            }
            current = current.getNext();
        }

        while (head1 != null) {
            current.setNext(new Node<>(head1.getValue()));
            head1 = head1.getNext();
            current = current.getNext();
        }

        while (head2 != null) {
            current.setNext(new Node<>(head2.getValue()));
            head2 = head2.getNext();
            current = current.getNext();
        }

        return l3.getNext(); 
    }


    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> l1 = createList(new int[]{1,7, 7, 9, 12});
        Node<Integer> l2 = createList(new int[]{5, 8, 15, 20});
        

        Node<Integer> mergedList = ex1(l1, l2);
       
        System.out.print("Merged List: ");
        printList(mergedList);
    }
}
