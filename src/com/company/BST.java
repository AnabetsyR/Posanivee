package com.company;

/****************************************************************************
 * Binary Search Tree class
 *
 * @author Provided by Instructor
 * @version 1.0
 * @date Date
 * @course MCIS-0503 Fall 2012 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public class BST <T> {

    private class Node <T> {
        Comparable <T> item;
        Node left, right;
    }

    public Node root;  // ref to the root of the bst
    int count;
    public QueueLL Q; // create  for info

    public static final int PREORDER = 0;
    public static final int INORDER = 1;
    public static final int POSTORDER = 2;

    public BST() { // create an empty BST object
        root = null;
        count = 0;
        Q = new QueueLL<T>();  // create new LL for objects
    }

    public void makeEmpty() {
        root = null;
        count = 0;
        Q.makeEmpty();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return count;
    }

    public Comparable lookup(Comparable x) {
        return lookup(root, x);
    }

    private Comparable lookup(Node r, Comparable x) { // base cases
        if (r == null)
            return null;
        if (r.item.compareTo(x) == 0)
            return r.item;
        //recursive case
        if (x.compareTo(r.item) < 0)
            return lookup(r.left, x);
        else
            return lookup(r.right, x);
    }

    public void insert(Comparable x) {
        root = insert(root, x);
        count++;
    }

    // returns a reference to the root of the tree with x inserted
    private Node insert(Node r, Comparable x) {
        // base case
        if (r == null) {
            Node t = new Node();
            t.item = x;
            t.left = t.right = null;
            return t;
        }
        // recursive case
        if (x.compareTo(r.item) < 0) {
            r.left = insert(r.left, x);
            return r;
        } else {
            r.right = insert(r.right, x);
            return r;
        }
    }

    private Comparable todelete; // item that gets deleted

    public Comparable delete(Comparable x)
    // returns the item deleted, or null if not found
    {
        todelete = lookup(x);
        if (todelete != null)
            root = delete(root, x);
        return todelete;
    }

    // returns a reference to the root of the modified tree
    private Node delete(Node r, Comparable x) {
        // base case: all the work is here
        if (r.item.compareTo(x) == 0) {
            // code to handle 3 cases
            // 0 children
            if (r.left == null && r.right == null)
                return null;
            // 1 child
            if (r.left == null) // we have only a right child
                return r.right; // promote the right child
            if (r.right == null)
                return r.left;
            // 2 children case
            Comparable successor = min(r.right);
            r.item = successor;
            r.right = delete(r.right, successor);
            return r;
        }
        // recursive case
        if (x.compareTo(r.item) < 0) {
            r.left = delete(r.left, x);
            return r;
        } else {
            r.right = delete(r.right, x);
            return r;
        }
    }

    private Comparable min(Node r) {
        // base cases
        if (r == null)
            return null;
        if (r.left == null)
            return r.item;
        // recursive case
        return min(r.left);
    }

    // Iterator functions

    public void reset() {
        reset(INORDER);
    }

    public void reset(int order) {
        Q.makeEmpty();
        traverse(root, order);
    }


    public void traverse(Node r, int order) {
        if (r == null)
            return;

        if (order == PREORDER)
            Q.enqueue((Camper) r.item);
        traverse(r.left, order);
        if (order == INORDER)
            Q.enqueue((Camper) r.item);
        traverse(r.right, order);
        if (order == POSTORDER)
            Q.enqueue((Camper) r.item);
    }

    public String toString(){
        reset();
        return Q.toString();
    }
}

