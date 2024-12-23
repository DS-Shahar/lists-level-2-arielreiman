public class Main {

    public static Node<Integer> createList(int[] arr) {
        Node<Integer> head = new Node<>(-1);
        Node<Integer> p = head;
        for (int i = 0; i < arr.length; i++) {
            Node<Integer> x = new Node<>(arr[i]);
            p.setNext(x);
            p = p.getNext();
        }
        return head.getNext();
    }

    public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> cur = dummy;
        Node<Integer> c1 = l1;
        Node<Integer> c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.getValue() < c2.getValue()) {
                cur.setNext(new Node<>(c1.getValue()));
                c1 = c1.getNext();
            } else {
                cur.setNext(new Node<>(c2.getValue()));
                c2 = c2.getNext();
            }
            cur = cur.getNext();
        }
        while (c1 != null) {
            cur.setNext(new Node<>(c1.getValue()));
            c1 = c1.getNext();
            cur = cur.getNext();
        }
        while (c2 != null) {
            cur.setNext(new Node<>(c2.getValue()));
            c2 = c2.getNext();
            cur = cur.getNext();
        }
        return dummy.getNext();
    }

    public static Node<Integer> ex2(Node<Integer> head) {
        if (head == null || head.getNext() == null) return head;
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;
        Node<Integer> h = head;
        while (h != null) {
            Node<Integer> minNode = h;
            Node<Integer> minPrev = null;
            Node<Integer> c = h;
            Node<Integer> p = null;
            while (c != null) {
                if (c.getValue() < minNode.getValue()) {
                    minNode = c;
                    minPrev = p;
                }
                p = c;
                c = c.getNext();
            }
            if (minPrev == null) {
                h = h.getNext();
            } else {
                minPrev.setNext(minNode.getNext());
            }
            minNode.setNext(null);
            if (newHead == null) {
                newHead = minNode;
                newTail = minNode;
            } else {
                newTail.setNext(minNode);
                newTail = minNode;
            }
        }
        return newHead;
    }

    public static int ex3(Node<Integer> head, int val) {
        if (head == null) return -1;
        int length = 0;
        Node<Integer> tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.getNext();
        }
        int sum = 0;
        int index = 0;
        int found = 0;
        tmp = head;
        while (tmp != null) {
            if (tmp.getValue() == val) {
                found++;
                int distStart = index;
                int distEnd = (length - 1) - index;
                if (distStart < distEnd) sum += distStart; 
                else sum += distEnd;
            }
            index++;
            tmp = tmp.getNext();
        }
        if (found == 0) return -1;
        return sum;
    }

    public static boolean ex4(Node<Integer> head) {
        Node<Integer> outer = head;
        while (outer != null) {
            Node<Integer> inner = outer.getNext();
            while (inner != null) {
                if (outer.getValue().equals(inner.getValue())) {
                    return false;
                }
                inner = inner.getNext();
            }
            outer = outer.getNext();
        }
        return true;
    }

    public static Node<Integer> ex5(Node<Integer> head) {
        if (head == null) 
            return null;
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;
        Node<Integer> c = head;
        while (c != null) {
            if (!exists(newHead, c.getValue())) {
                Node<Integer> nn = new Node<>(c.getValue());
                if (newHead == null) {
                    newHead = nn;
                    newTail = nn;
                } else {
                    newTail.setNext(nn);
                    newTail = nn;
                }
            }
            c = c.getNext();
        }
        return newHead;
    }

    private static boolean exists(Node<Integer> head, int val) {
        Node<Integer> c = head;
        while (c != null) {
            if (c.getValue() == val)
                return true;
            c = c.getNext();
        }
        return false;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> cur = head;
        while (cur != null) {
            System.out.print(cur.getValue() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> l1 = createList(new int[]{1, 7, 7, 9, 12});
        Node<Integer> l2 = createList(new int[]{5, 8, 15, 20});
        Node<Integer> merged = ex1(l1, l2);
        printList(merged);
        Node<Integer> sorted = ex2(l1);
        printList(sorted);
        int s = ex3(l1, 7);
        System.out.println(s);
        boolean d = ex4(l1);
        System.out.println(d);
        Node<Integer> nd = ex5(l1);
        printList(nd);
    }
}
