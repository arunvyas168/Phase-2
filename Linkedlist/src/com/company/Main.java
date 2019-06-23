package com.company;

public class Main {


    public static Node buildList(int count){
        if (count == 0){
            return null;
        }
        Node head = new Node(1);
        Node pointer = head;
        for (int i=2; i<count+1; i++){
            pointer.next = new Node(i);
            pointer = pointer.next;
        }
        return head;
    }

    public static void printList(Node head){
        if (head == null){
            return;
        }
        while(head!=null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void reorder(Node head){
        if ((head == null)|| (head.next == null)){
            return;
        }
        Node first = head;
        Node slow = head;
        Node fast = head;
        // Find Mid pointer
        while ((fast != null)&&(fast.next!=null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);

        while (slow.next != null){
            Node temp = slow.next;
            slow.next = temp.next;
            temp.next = first.next;
            first.next = temp;
            first = temp.next;
        }
    }

    public static void reArrangeOddEven1(Node head){
        if ((head==null)|| (head.next==null)|(head.next.next == null)){
            return;
        }
        Node current = head;
        Node evenhead=null;

        while (current.next!=null){
            Node temp = current.next;
            current.next = current.next.next;
            temp.next=null;
            evenhead = addnNodeToEnd(temp,evenhead);
            current = current.next;
        }
        current.next=evenhead;
    }

    public static Node addnNodeToEnd(Node node, Node head){
        if (head == null){
            return node;
        }
        Node current = head;
        while (current!=null){
            if (current.next == null){
                current.next=node;
                return head;
            }
            current = current.next;
        }
        return head;
    }


    public static Node reverseList(Node head){
        Node current = head;
        Node result = null;
        Node next;
        while (current != null){
            next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }

    public static void reArrangeOddEven2(Node head){
        if ((head==null)||(head.next==null)){
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenFirst = even;

        while(true){
            if (even.next == null){
                odd.next = evenFirst;
                return;
            }
            odd.next = even.next;
            odd = even.next;

            if (odd.next == null){
                even.next = null;
                odd.next = evenFirst;
                return;
            }
            even.next = odd.next;
            even = even.next;

        }
    }

    public static void main(String[] args) {

        //reorder
        Node head1 = buildList(5);
        System.out.println("Original List:");
        printList(head1);
        reorder(head1);
        System.out.println("After reorder:");
        printList(head1);

        //reArrangeOddEven1
        Node head2 = buildList(5);
        reArrangeOddEven1(head2);
        System.out.println("After reArrangeOddEven1:");
        printList(head2);

        //reArrangeOddEven2
        Node head3 = buildList(5);
        reArrangeOddEven2(head3);
        System.out.println("After reArrangeOddEven2:");
        printList(head3);
    }
}
