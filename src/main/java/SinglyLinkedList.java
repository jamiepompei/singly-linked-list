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

    public void add(SomeType obj){
        if(head == null)
            addFirstElement(obj);
        else if (tail == null)
            addSecondElement(obj);
        else
            addThirdElementOnwards(obj);
        length++;
    }

    public void shiftIndex(Node<SomeType> node, int currentIndex){
        while(node !=null){
            node.setIndex(currentIndex);
            node = node.getNext();
            currentIndex++;
        }
    }

    public void removeFirstIndex(){
        Node<SomeType> newHead = head.getNext();
        head.setNext(null);
        head = newHead;
        head.setIndex(0);
        shiftIndex(tail.getNext(), 0);
    }

    public void removeSecondIndex(){
        Node<SomeType> tempNode = head.getNext();
        Node<SomeType> nextNode = tempNode.getNext();
        head.setNext(nextNode);
        nextNode.setIndex(1);
        tempNode.setNext(null);
        shiftIndex(head.getNext(), 1);
    }

    public void removeInTheMiddle(Node<SomeType> tempNode, Node<SomeType> toReplace, int index){
        Node<SomeType> toConnect = toReplace.getNext();
        tempNode.setNext(toConnect);
        toReplace.setNext(null);
        toConnect.setIndex(index + 1);
        shiftIndex(toConnect.getNext(), toConnect.getIndex());
    }

    public Node<SomeType> findNodeToReconnect(Node<SomeType> tempNode, int index){
        while (tempNode.getIndex() != index -1){
            tempNode = tempNode.getNext();
        }
        return tempNode;
    }


}
