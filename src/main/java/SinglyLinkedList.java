public class SinglyLinkedList <SomeType extends Comparable<SomeType>> {

    private Node<SomeType> head;
    private Node<SomeType> tail;
    private int length;

    public SinglyLinkedList(Node<SomeType> head, Node<SomeType> tail, int length) {
        head = null;
        tail = null;
        length = 0;
    }

    public void addFirstElement(SomeType obj){
        head = new Node<SomeType>(obj, null);
        head.setIndex(0);
    }

    public void addSecondElement(SomeType obj){
        tail = new Node<SomeType>(obj, null);
        head.setNext(tail);
        tail.setIndex(1);
    }

    public void addThirdElementOnwards(SomeType obj){
        int nextIndex = tail.getIndex() + 1;
        tail.setNext(new Node<SomeType>(obj, null));
        tail = tail.getNext();
        tail.setIndex(nextIndex);
    }
}
