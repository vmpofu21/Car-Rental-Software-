package edu.ithaca.dragon.datastructures.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class NodeUtilTest {


   
    @Test
    public void testLoopNodeUtil(){
        testAllNodeUtil(new LoopNodeUtil<>());
    }

    public void testAllNodeUtil(NodeUtil<Integer> toTest){
        countTest(toTest);
        containsTest(toTest);
        countOccurrencesTest(toTest);
        nodeAtIndexTest(toTest);
        indexOfFirstNodeContainingTest(toTest);
        removeFirstTest(toTest);
        removeAllTest(toTest);
    }

    public void countTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5)))));
        assertEquals(5, toTest.countNodes(example));
        assertEquals(4, toTest.countNodes(example.getNext()));
        assertEquals(3, toTest.countNodes(example.getNext().getNext()));
        assertEquals(2, toTest.countNodes(example.getNext().getNext().getNext()));
        assertEquals(1, toTest.countNodes(example.getNext().getNext().getNext().getNext()));
        
        assertEquals(1, toTest.countNodes(new LinkedNode<Integer>(12)));
        assertEquals(0, toTest.countNodes(null));
    }

    public void containsTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5)))));
        assertEquals(true, toTest.contains(example, 8));
        assertEquals(true, toTest.contains(example, 4));
        assertEquals(true, toTest.contains(example, 3));
        assertEquals(true, toTest.contains(example, 5));
        assertEquals(false, toTest.contains(example, 12));
        assertEquals(false, toTest.contains(example, 0));

        assertEquals(true, toTest.contains(example.getNext(), 8));
        assertEquals(false, toTest.contains(example.getNext().getNext(), 4));
        
        assertEquals(true, toTest.contains(new LinkedNode<Integer>(12), 12));
        assertEquals(false, toTest.contains(new LinkedNode<Integer>(12), 13));
        assertEquals(false, toTest.contains(null, 22));
    }

    public void countOccurrencesTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        assertEquals(2, toTest.countOccurrences(example, 8));
        assertEquals(1, toTest.countOccurrences(example, 4));
        assertEquals(1, toTest.countOccurrences(example, 3));
        assertEquals(3, toTest.countOccurrences(example, 5));
        assertEquals(1, toTest.countOccurrences(example, 2));
        assertEquals(0, toTest.countOccurrences(example, 0));
        assertEquals(0, toTest.countOccurrences(example, 6));

        assertEquals(1, toTest.countOccurrences(example.getNext(), 8));
        assertEquals(0, toTest.countOccurrences(example.getNext().getNext(), 4));
        
        assertEquals(1, toTest.countOccurrences(new LinkedNode<Integer>(12), 12));
        assertEquals(0, toTest.countOccurrences(new LinkedNode<Integer>(12), 13));
        assertEquals(0, toTest.countOccurrences(null, 22));
    }

    public void nodeAtIndexTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> second8 =  new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5)));
        assertEquals(8, toTest.nodeAtIndex(second8, 0).getItem().intValue());
        assertEquals(3, toTest.nodeAtIndex(second8, 1).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(second8, 2).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(second8, 3));

        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4,second8));
        assertEquals(4, toTest.nodeAtIndex(example, 1).getItem().intValue());
        assertEquals(3, toTest.nodeAtIndex(example, 3).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(example, 4).getItem().intValue());

        assertSame(example, toTest.nodeAtIndex(example, 0));
        assertSame(second8, toTest.nodeAtIndex(example, 2));

        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(example, 6));
        
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(null, 0));
    }

    public void indexOfFirstNodeContainingTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        assertEquals(0, toTest.indexOfFirstNodeContaining(example, 8));
        assertEquals(1, toTest.indexOfFirstNodeContaining(example, 4));
        assertEquals(3, toTest.indexOfFirstNodeContaining(example, 3));
        assertEquals(4, toTest.indexOfFirstNodeContaining(example, 5));
        assertEquals(6, toTest.indexOfFirstNodeContaining(example, 2));

        assertEquals(1, toTest.indexOfFirstNodeContaining(example.getNext(), 8));
        assertEquals(3, toTest.indexOfFirstNodeContaining(example.getNext(), 5));

        assertEquals(-1, toTest.indexOfFirstNodeContaining(example, 6));
        assertEquals(-1, toTest.indexOfFirstNodeContaining(example.getNext().getNext(), 4));
        
        assertEquals(0, toTest.indexOfFirstNodeContaining(new LinkedNode<Integer>(12), 12));
        assertEquals(-1, toTest.indexOfFirstNodeContaining(new LinkedNode<Integer>(12), 13));
        assertEquals(-1, toTest.indexOfFirstNodeContaining(null, 22));
    }

    public void indexOfLastNodeContainingTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        assertEquals(2, toTest.indexOfLastNodeContaining(example, 8));
        assertEquals(1, toTest.indexOfLastNodeContaining(example, 4));
        assertEquals(3, toTest.indexOfLastNodeContaining(example, 3));
        assertEquals(7, toTest.indexOfLastNodeContaining(example, 5));
        assertEquals(6, toTest.indexOfLastNodeContaining(example, 2));

        assertEquals(1, toTest.indexOfLastNodeContaining(example.getNext(), 8));
        assertEquals(6, toTest.indexOfFirstNodeContaining(example.getNext(), 5));


        assertEquals(-1, toTest.indexOfLastNodeContaining(example, 6));
        assertEquals(-1, toTest.indexOfLastNodeContaining(example.getNext().getNext(), 4));
        
        assertEquals(0, toTest.indexOfLastNodeContaining(new LinkedNode<Integer>(12), 12));
        assertEquals(-1, toTest.indexOfLastNodeContaining(new LinkedNode<Integer>(12), 13));
        assertEquals(-1, toTest.indexOfLastNodeContaining(null, 22));
    }

    //relies on nodeAtIndex as well
    public void removeFirstTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));

        final LinkedNode<Integer> removed = toTest.removeFirst(example, 4);
        assertEquals(8, toTest.nodeAtIndex(removed, 0).getItem().intValue());
        assertEquals(8, toTest.nodeAtIndex(removed, 1).getItem().intValue());
        assertEquals(3, toTest.nodeAtIndex(removed, 2).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed, 6).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed, 7));


        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        final LinkedNode<Integer> removed2 = toTest.removeFirst(example, 5);
        assertEquals(3, toTest.nodeAtIndex(removed2, 3).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed2, 4).getItem().intValue());
        assertEquals(2, toTest.nodeAtIndex(removed2, 5).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed2, 6).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed2, 7));

        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        final LinkedNode<Integer> removed3 = toTest.removeFirst(example, 8);
        assertEquals(4, toTest.nodeAtIndex(removed3, 0).getItem().intValue());
        assertEquals(8, toTest.nodeAtIndex(removed3, 1).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed3, 6).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed3, 7));

        assertNull(toTest.removeFirst(new LinkedNode<Integer>(12), 12));
        assertThrows(NoSuchElementException.class, ()-> toTest.removeFirst(new LinkedNode<Integer>(12), 13));
        assertThrows(NoSuchElementException.class, ()-> toTest.removeFirst(null, 13));

        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        for (int item : Arrays.asList(8, 4, 8, 3, 5, 5, 2, 5)){
            example = toTest.removeFirst(example, item);
        }
        assertNull(example);
    }

    //relies on nodeAtIndex as well
    public void removeAllTest(NodeUtil<Integer> toTest){
        LinkedNode<Integer> example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));

        final LinkedNode<Integer> removed = toTest.removeAll(example, 4);
        assertEquals(8, toTest.nodeAtIndex(removed, 0).getItem().intValue());
        assertEquals(8, toTest.nodeAtIndex(removed, 1).getItem().intValue());
        assertEquals(3, toTest.nodeAtIndex(removed, 2).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed, 6).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed, 7));
        assertSame(removed, toTest.removeAll(removed, 13));

        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        final LinkedNode<Integer> removed2 = toTest.removeAll(example, 5);
        assertEquals(3, toTest.nodeAtIndex(removed2, 3).getItem().intValue());
        assertEquals(2, toTest.nodeAtIndex(removed2, 4).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed2, 5));
        assertSame(removed2, toTest.removeAll(removed2, 13));


        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        final LinkedNode<Integer> removed3 = toTest.removeAll(example, 8);
        assertEquals(4, toTest.nodeAtIndex(removed3, 0).getItem().intValue());
        assertEquals(3, toTest.nodeAtIndex(removed3, 1).getItem().intValue());
        assertEquals(5, toTest.nodeAtIndex(removed3, 5).getItem().intValue());
        assertThrows(IndexOutOfBoundsException.class, ()-> toTest.nodeAtIndex(removed3, 6));
        assertSame(removed2, toTest.removeAll(removed2, 13));


        final LinkedNode<Integer> single = new LinkedNode<Integer>(12);
        assertNull(toTest.removeAll(single, 12));
        assertSame(single, toTest.removeAll(single, 13));

        example = new LinkedNode<>(8, new LinkedNode<>(4, new LinkedNode<>(8, new LinkedNode<>(3, new LinkedNode<>(5, new LinkedNode<>(5, new LinkedNode<>(2, new LinkedNode<>(5))))))));
        for (int item : Arrays.asList(8, 4, 3, 5, 2)){
            example = toTest.removeAll(example, item);
        }
        assertNull(example);
    }
}
