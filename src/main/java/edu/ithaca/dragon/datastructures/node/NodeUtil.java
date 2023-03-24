package edu.ithaca.dragon.datastructures.node;

import java.util.NoSuchElementException;

public interface NodeUtil<T> {

    /**
     * @return the number of nodes in the chain of linked nodes starting at aNode
     */
    public int countNodes(LinkedNode<T> aNode);

    /**
     * @return true if any node in the chain of linked nodes starting at aNode holds itemToFind, false otherwise
     */
    //@returns 
    public boolean contains(LinkedNode<T> aNode, T itemToFind);

    /**
     * @return the number of times itemToFind in the chain of linked nodes starting at aNode
     */
    public int countOccurrences(LinkedNode<T> aNode, T itemToFind);

    /**
     * @throws IndexOutOfBoundsException if index is invalid
     * @return a pointer to the node that is at the index given in the chain of linked nodes starting at aNode
     */
    public LinkedNode<T> nodeAtIndex(LinkedNode<T> aNode, int index);

    /**
     * @return the index of the first node in the chain of linked nodes starting at aNode, or -1 if item is not present
     */
    public int indexOfFirstNodeContaining(LinkedNode<T> aNode, T itemToFind);

    /**
     * @return the index of the last node in the chain of linked nodes starting at aNode, or -1 if item is not present
     */
    public int indexOfLastNodeContaining(LinkedNode<T> aNode, T itemToFind);

    /**
     * @post the chain of linked nodes starting at aNode may be changed (a node removed from the middle)
     * @throws NoSuchElementException if itemToRemove is not present
     * @return a pointer to the head node of the chain of linked nodes with the first instance of itemToRemove removed
     */
    public LinkedNode<T> removeFirst(LinkedNode<T> aNode, T itemToRemove);

    /**
     * @post the chain of linked nodes starting at aNode may be changed (nodes removed from the middle)
     * @return a pointer to the head node of the chain of linked nodes with the all instances of itemToRemove removed
     *         or a pointer to the same chain of linked nodes if itemToRemove is not present
     */
    public LinkedNode<T> removeAll(LinkedNode<T> aNode, T itemToRemove);
}
