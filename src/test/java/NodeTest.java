import org.junit.Assert;
import org.junit.Test;

public class NodeTest<SomeType> {


    @Test
    public void constructorTest(){

        Integer expected = 4;
        Node node = new Node(4, null);
        SomeType actual = (SomeType) node.getObj();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestNull(){
        SomeType expected = null;
        Node node = new Node(4, null);
        SomeType actual = (SomeType) node.getNext();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getterAndSetterTest(){
        int expected = 4;
        Node node = new Node(expected, null);

        node.setIndex(expected);

        int actual = node.getIndex();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setObjectTest(){
        Integer obj = 4;
        Node node = new Node(obj, null);
        Integer expected = 15;

        node.setObj(expected);

        SomeType actual = (SomeType) node.getObj();

        Assert.assertEquals(expected, actual);
    }

}
