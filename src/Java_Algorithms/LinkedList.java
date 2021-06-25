package Java_Algorithms;

public class LinkedList {
    class Node<E>{
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public LinkedList(){
        head = crnt = null;
    }
    // ? super E means "unknown type that is, or is a super class of, E"
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head;

        while(ptr != null){
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void addFirst(E obj){
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    public void RemoveFirst(){
        if(head == null)
            return;
        else{
            head = crnt = head.next;
        }
    }

    public void RemoveLast(){
        if(head != null){
            if(head.next == null)
                RemoveFirst();
            else{
                Node<E> pre = head;
                Node<E> ptr = head;
                while(ptr.next != null)
                {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    public void Remove(Node P){
        if(head != null){
            if(P == head)
                RemoveFirst();
            else{
                Node<E> ptr = head;
                while(ptr.next != P){
                    ptr = ptr.next;
                    if(ptr == null)
                        return;
                }
                ptr.next = P.next;
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode(){
        Remove(crnt);
    }
}
