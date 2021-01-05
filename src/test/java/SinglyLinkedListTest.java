import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList<String> stringList;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;

    @Before
    public void setUp(){
        first = "first";
        second = "second";
        third = "third";
        fourth = "fourth";
        fifth = "fifth";

        stringList = new SinglyLinkedList<String>();

        stringList.add(first);
        stringList.add(second);
        stringList.add(third);
        stringList.add(fourth);
        stringList.add(fifth);
    }

    @Test
    public void addTest1(){
        String expected = first;
        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){

        String expected = second;
        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest3(){
        String expected = third;
        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest(){
        String expected = third;
        stringList.swap(second, third);

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest1(){
        String expected = second;
        stringList.swap(second, third);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest2(){
        String expected = first;
        stringList.swap(second, third);

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest3(){
        String expected = fourth;
        stringList.swap(second, third);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest(){
        String expected = third;
        stringList.set(1, third);

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest1(){
        String expected = first;
        stringList.set(1, third);

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest2(){
        String expected = third;
        stringList.set(1, third);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFirstIndex(){
        String expected = second;

        stringList.removeFirstIndex();

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFirstIndex1(){
        String expected = third;

        stringList.removeFirstIndex();

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeSecondIndex(){
        String expected = third;

        stringList.removeSecondIndex();

        String actual = stringList.get(1);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeSecondIndex1(){
        String expected = first;

        stringList.removeSecondIndex();

        String actual = stringList.get(0);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeSecondIndex2(){
        String expected = fourth;

        stringList.removeSecondIndex();

        String actual = stringList.get(2);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeOtherIndexes(){
        String expected = fifth;

        stringList.removeOtherIndex(3);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOtherIndexes1(){
        String expected = third;

        stringList.removeOtherIndex(3);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastIndex(){
        String expected = fourth;
        stringList.remove(4);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastIndex1(){
        String expected = first;
        stringList.remove(4);

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastIndex2(){
        String expected = second;
        stringList.remove(4);

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastIndex3(){
        String expected = third;
        stringList.remove(4);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsFirstTest(){
        String expected = first;

        Assert.assertTrue(stringList.contains(expected));
    }

    @Test
    public void containsSecondTest(){
        String expected = second;

        Assert.assertTrue(stringList.contains(expected));
    }

    @Test
    public void containsThirdTest(){
        String expected = third;

        Assert.assertTrue(stringList.contains(expected));
    }

    @Test
    public void containsFourthTest(){
        String expected = fourth;

        Assert.assertTrue(stringList.contains(expected));
    }

    @Test
    public void containsFifthTest(){
        String expected = fifth;

        Assert.assertTrue(stringList.contains(expected));
    }

    @Test
    public void sizeTest(){
        int expected = 5;

        int actual = stringList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyListSizeTest(){
        SinglyLinkedList<String> emptyList = new SinglyLinkedList<String>();
        int expected = 0;
        int actual = emptyList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyListContainsTest(){
        SinglyLinkedList<String> emptyList = new SinglyLinkedList<String>();

        Assert.assertFalse(emptyList.contains(first));
    }

    @Test
    public void findFirstTest(){
        int expected = 0;
        int actual = stringList.find(first);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findSecondTest(){
        int expected = 1;
        int actual = stringList.find(second);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findThirdTest(){
        int expected = 2;
        int actual = stringList.find(third);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findFourthTest(){
        int expected = 3;
        int actual = stringList.find(fourth);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findFifthTest(){
        int expected = 4;
        int actual = stringList.find(fifth);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void stringListCopySizeOneValueLong(){
        for (int i = 0; i < 4; i++) {
            stringList.remove(0);
        }

        SinglyLinkedList<String> stringListCopy = stringList.copy();

        String expectedValueOriginal = fifth;
        String actualValueOriginl = stringList.get(0);
        String expectedValueCopy = fifth;
        String actualValueCopy = stringListCopy.get(0);

        int expectedSizeOriginal = 1;
        int actualSizeOriginal = stringList.size();
        int expectedSizeCopy = 1;
        int actualSizeCopy = stringListCopy.size();

        Assert.assertEquals(expectedValueOriginal, actualValueOriginl);
        Assert.assertEquals(expectedSizeOriginal, actualSizeOriginal);
        Assert.assertEquals(expectedValueCopy, actualValueCopy);
        Assert.assertEquals(expectedSizeCopy, actualSizeCopy);
        Assert.assertEquals(actualValueOriginl, actualValueCopy);
        Assert.assertEquals(actualSizeOriginal, actualSizeCopy);
        Assert.assertNotSame(stringList, stringListCopy);
    }

    @Test
    public void stringListCopyEmptyTest(){
        for (int i = 0; i < 5; i++) {
            stringList.remove(0);
        }

        SinglyLinkedList<String> stringListCopy = stringList.copy();

        int expectedSizeOriginal = 0;
        int actualSizeOriginal = stringList.size();
        int expectedSizeCopy = 0;
        int actualSizeCopy = stringListCopy.size();

        Assert.assertEquals(expectedSizeOriginal, actualSizeOriginal);
        Assert.assertEquals(expectedSizeCopy, actualSizeCopy);
        Assert.assertNotSame(stringList, stringListCopy);
    }

    @Test
    public void stringListCopyTwoValuesTest(){
        for (int i = 0; i < 3; i++) {
            stringList.remove(0);
        }

        SinglyLinkedList<String> stringListCopy = stringList.copy();

        String expectedValueOneOriginal = fourth;
        String actualValueOneOriginl = stringList.get(0);
        String expectedValueOneCopy = fourth;
        String actualValueOneCopy = stringListCopy.get(0);

        String expectedValueTwoOriginal = fifth;
        String actualValueTwoOriginal = stringList.get(1);
        String expectedValueTwoCopy = fifth;
        String actualValueTwoCopy = stringListCopy.get(1);

        int expectedSizeOriginal = 2;
        int actualSizeOriginal = stringList.size();
        int expectedSizeCopy = 2;
        int actualSizeCopy = stringListCopy.size();

        Assert.assertEquals(expectedValueOneOriginal, actualValueOneOriginl);
        Assert.assertEquals(expectedValueOneCopy, actualValueOneCopy);
        Assert.assertEquals(actualValueOneOriginl, actualValueOneCopy);

        Assert.assertEquals(expectedValueTwoOriginal, actualValueTwoOriginal);
        Assert.assertEquals(expectedValueTwoCopy, actualValueTwoCopy);
        Assert.assertEquals(actualValueTwoOriginal, actualValueTwoCopy);

        Assert.assertEquals(expectedSizeOriginal, actualSizeOriginal);
        Assert.assertEquals(expectedSizeCopy, actualSizeCopy);
        Assert.assertEquals(actualSizeOriginal, actualSizeCopy);

        Assert.assertNotSame(stringList, stringListCopy);
    }

    @Test
    public void copyAllValuesTest(){
        SinglyLinkedList<String> stringListCopy = stringList.copy();

        for (int i = 0; i < 5; i++) {
            String expected = stringList.get(i);
            String actual = stringListCopy.get(i);

            Assert.assertEquals(expected, actual);
        }

        int expectedSize = stringList.size();
        int actualSize = stringListCopy.size();

        Assert.assertEquals(expectedSize, actualSize);

        Assert.assertNotSame(stringList, stringListCopy);

    }

    @Test
    public void bubbleSortTest(){
        stringList.bubbleSort();

        String expected = fifth;
        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bubbleSortTest1(){
        stringList.bubbleSort();

        String expected = first;
        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bubbleSortTest2(){
        stringList.bubbleSort();

        String expected = fourth;
        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bubbleSortTest3(){
        stringList.bubbleSort();

        String expected = second;
        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bubbleSortTest4(){
        stringList.bubbleSort();

        String expected = third;
        String actual = stringList.get(4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sliceTest(){
        SinglyLinkedList<String> slicedStringList = stringList.slice(1,4);

        String expectedOriginal = second;
        String actualOriginal = stringList.get(1);

        String expectedCopy = second;
        String actualCopy = slicedStringList.get(0);

        Assert.assertEquals(expectedOriginal, actualOriginal);
        Assert.assertEquals(expectedCopy, actualCopy);
        Assert.assertEquals(expectedOriginal, actualCopy);
    }

    @Test
    public void sliceTest1(){
        SinglyLinkedList<String> slicedStringList = stringList.slice(1,4);

        String expectedOriginal = third;
        String actualOriginal = stringList.get(2);

        String expectedCopy = third;
        String actualCopy = slicedStringList.get(1);

        Assert.assertEquals(expectedOriginal, actualOriginal);
        Assert.assertEquals(expectedCopy, actualCopy);
        Assert.assertEquals(expectedOriginal, actualCopy);
    }

    @Test
    public void sliceTest2(){
        SinglyLinkedList<String> slicedStringList = stringList.slice(1,4);

        String expectedOriginal = fourth;
        String actualOriginal = stringList.get(3);

        String expectedCopy = fourth;
        String actualCopy = slicedStringList.get(2);

        Assert.assertEquals(expectedOriginal, actualOriginal);
        Assert.assertEquals(expectedCopy, actualCopy);
        Assert.assertEquals(expectedOriginal, actualCopy);
    }

    @Test
    public void sliceTest3(){
        SinglyLinkedList<String> slicedStringList = stringList.slice(1,4);

        String expectedOriginal = fifth;
        String actualOriginal = stringList.get(4);

        String expectedCopy = fifth;
        String actualCopy = slicedStringList.get(3);

        Assert.assertEquals(expectedOriginal, actualOriginal);
        Assert.assertEquals(expectedCopy, actualCopy);
        Assert.assertEquals(expectedOriginal, actualCopy);
    }

    @Test
    public void reverseTest(){
        stringList.reverse();

        String expected = fifth;
        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void reverseTest1(){
        stringList.reverse();

        String expected = fourth;
        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest2(){
        stringList.reverse();

        String expected = third;
        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest3(){
        stringList.reverse();

        String expected = second;
        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest4(){
        stringList.reverse();

        String expected = first;
        String actual = stringList.get(4);

        Assert.assertEquals(expected, actual);
    }


}
