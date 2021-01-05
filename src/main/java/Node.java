public class Node <SomeType>{
    //reference to the next node in the chain, or null if there isn't one
    private Node next;
    //data carried by this node. could be of any type if needed
    private SomeType obj;
    private int index = 0;

    //Node constructor
    public Node(SomeType obj, Node next){
        this.obj = obj;
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public SomeType getObj(){
        return obj;
    }

    public void setObj(SomeType obj){
        this.obj = obj;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

}
