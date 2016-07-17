package com.company;

import static com.company.CampPosanivee.o;

/****************************************************************************
 * Queue Implementation
 *
 * @author Anabetsy Rivero
 * @version 1.0
 * @date 07/08/16
 * @course CISC-0503 Summer 2016 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public class QueueLL < T > implements Queue < T > {
    private class node {
        public Object data;
        public node next;
    }

    node front, back;
    int count;

    public QueueLL(int i) {

        makeEmpty();
    }

    // Transformers/Mutators
    public void enqueue(Object x) {
        node nn = new node();
        nn.data = x;
        nn.next = null;
        if (isEmpty())
            front = nn;
        else
            back.next = nn;
        back = nn;
        count++;
    }

    @Override
    public void enqueue(Camper o) {

    }

    @Override
    public String toString(){
        return o.getName()+":"+o.getAge()+" ";
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T frontItem = (T) getFront();
        front = front.next;
        count--;
        if (count == 0)
            back = null;
        return (T) frontItem;
    }

    public void makeEmpty() {
        front = back = null;
        count = 0;
    }

    // Observers/Accessors
    public T getFront() {
        if (isEmpty())
            return null;
        return (T) front.data;
    }

    public int size() {

        return count;
    }

    public boolean isEmpty() {

        return count == 0;
    }

    public boolean isFull() {

        return false;
    }
}

