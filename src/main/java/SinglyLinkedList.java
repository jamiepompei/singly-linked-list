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

    public void removeOtherIndex(int index){
        Node<SomeType> tempNode = head.getNext();
        tempNode = findNodeToReconnect(tempNode, index);
        int tempIndex = tempNode.getIndex();
        Node<SomeType> toReplace = tempNode.getNext();
        if(toReplace.getNext() == null){
            tempNode.setNext(null);
        }
        else{
            removeInTheMiddle(tempNode, toReplace, tempIndex);
        }
    }

    public void remove(int index){
        if(index == 0 && this.size() == 1)
            removeLastElement();
        else if(index ==0)
            removeFirstIndex();
        else if(index == 1)
            removeSecondIndex();
        else
            removeOtherIndex(index);
        length--;
    }

    private void removeLastElement(){ head = null;}

    public int size(){
        return length;
    }

    public boolean contains(SomeType obj){
        Node<SomeType> tempNode = head;
        if(head == null)
            return false;
        else
            for(int i = 0; i < this.size(); i++){
                if(tempNode.getObj().equals(obj))
                    return true;
                else
                    tempNode = tempNode.getNext();
            }
        return false;
    }

    public SomeType get(int index){
        int tempIndex = head.getIndex();
        Node<SomeType> tempNode = head;
        while(tempIndex != index){
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        return tempNode.getObj();
    }

    public void set(int index, SomeType obj){
        int tempIndex = head.getIndex();
        Node<SomeType> tempNode = head;
        while(tempIndex != index){
            tempIndex++;
            tempNode = tempNode.getNext();
        }
        tempNode.setObj(obj);
    }

    public int find(SomeType obj){
        Node<SomeType> tempNode = head;
        int nodeCount = 0;
        if(head == null)
            return -1;
        while(tempNode != null){
            if(tempNode.getObj() == obj)
                return nodeCount;
            nodeCount++;
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    public SinglyLinkedList<SomeType> copyBySize(){
        SinglyLinkedList<SomeType> copy = new SinglyLinkedList<SomeType>();
        Node<SomeType> tempNode = head;
        while(tempNode != null){
            copy.add(tempNode.getObj());
            tempNode = tempNode.getNext();
        }
        return copy;
    }

    public SinglyLinkedList<SomeType> copy(){
        int sizeOfCopy = this.size();
        if(sizeOfCopy == 0)
            return new SinglyLinkedList<SomeType>();
        else
            return copyBySize();
    }

    public SinglyLinkedList<SomeType> slice(int startIndexInclusive, int endIndexInclusive){
        SinglyLinkedList<SomeType> copy = this.copy();
        for (int i = 0; i < copy.size(); i++) {
            if(i < startIndexInclusive || i >= endIndexInclusive)
                copy.remove(i);
        }
        return copy;
    }

    public void reverse(){
        int size =  this.size();
        for (int i = 0; i < size; i++) {
            this.add(this.get(size -1 - i));
        }
        for (int i = 0; i < size; i++) {
            this.remove(0);
        }
    }

    public void swap(SomeType obj1, SomeType obj2){
        Node<SomeType> tempNode = head;
        int indexObj1 = -1;
        int indexObj2 = 1;
        while(tempNode != null){
            if(tempNode.getObj() == obj1)
                indexObj1 = tempNode.getIndex();
            else if (tempNode.getObj() == obj2)
                indexObj2 = tempNode.getIndex();
            tempNode = tempNode.getNext();
        }
        this.set(indexObj2, obj1);
        this.set(indexObj1, obj2);
    }

    public void bubbleSort(){
        for (int i = 0; i < length - 1; i++) {
            SomeType currentIndexI = get(i);
            for (int j = i + 1; j < length ; j++) {
                SomeType currentIndexJ = get(j);
                if(currentIndexI.compareTo(currentIndexJ) > 0){
                    swap(currentIndexI, currentIndexJ);
                    currentIndexI = currentIndexJ;
                }
            }
        }
    }


}
