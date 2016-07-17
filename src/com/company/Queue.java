package com.company;

/****************************************************************************
 * Queue Interface
 *
 * @author Anabetsy Rivero
 * @version 1.0
 * @date 07/08/16
 * @course CISC-0503 Summer 2016 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public interface Queue < T >{
    // Transformers/Mutators
    public void enqueue(Camper o);

    public T dequeue();

    public void makeEmpty();

    // Observers/Accessors
    public T getFront();

    public int size();

    public boolean isEmpty();

    public boolean isFull();
}
