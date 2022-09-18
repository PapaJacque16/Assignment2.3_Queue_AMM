package linkedlist;

import java.util.NoSuchElementException;

/**
 * This Queue class is a linear ordered data structure that follows FIFO 
 * (First In, First Out) ordering of elements. This means that the element inserted 
 * first in the queue will be the first element to be removed. 
 * @author Aaron McCarley
 * Assignment 2.3 
 * version 1.0
 * CS215
 * @param <T>
 */

public class QueueList<T> implements QueueInterface<T>{

	private T[] queue;
	private int head, tail; // beginning and end of queue
    private static final int DEFAULT_INITIAL_CAPACITY = 100; // number of elements on queue

    public QueueList() {
    	
    	this(DEFAULT_INITIAL_CAPACITY);
    	
    }// end default constructor
    
    public QueueList(int initialCapacity)
    {
    	T[] queues = (T[]) new Object [initialCapacity + 1];
    	queue = queues;
    	tail = initialCapacity;
    	head = 0;
    }//end constructor
 
	public boolean isEmpty() 
	{
    return head == (tail + 1) % queue.length; 
	}//end isEmpty
	
	public void enqueue(T newEntry) {
	capacity();
	tail = (tail + 1) % queue.length;
	queue[tail] = newEntry;
	}// end enqueue
	
	public T getFront() {
		if (isEmpty())
			throw new NoSuchElementException();
		else
			return queue[head];
	}//end getFront
	
	public T dequeue() {
		T first = null;
			if (!isEmpty())
			{
			first = queue[head];
			queue[head] = null;	
			head = (head + 1) % queue.length;
				}// end if
		return first;
	}// end dequeue
	
	// Increases the size of the Array queue if it is full to double.
	private void capacity() {
		if (head == ((tail + 2) % queue.length)) {
			
			//double size array
			T[] lastQueue = queue;
			int lastSize = lastQueue.length;
			
			//cast is safe new array contains null entries 
			T[] tempQuene = (T[]) new Object[2 * lastSize];
			queue = tempQuene;
			for (int index = 0; index < lastSize - 1; index++) {
				
			queue[index] = lastQueue[head];
			head = (head + 1) % lastSize;
			}// end for
			head = 0;
			tail = lastSize - 2;		
		}// end if
	}// end capacity


    public static void main(String[] args) { 
        // Create a queue of capacity 4 
		QueueList<String> queue = new QueueList<String>(); 
		//Add elements to the Queue
        queue.enqueue("Bill");
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        
        System.out.println("Elements in Queue:"+queue);
        //Removes and returns the entry at the front of this queue.
        System.out.println("A customer is served: "+queue.dequeue());
        //getFront returns head of the queue
        
        queue.enqueue("Jane arrives.");
        queue.enqueue("Hamed arrives.");
        
        System.out.println("Poll():Retrieves the Head of the queue: "+queue.getFront());
        //Peek returns head of the queue
        System.out.println("A customer is served: "+queue.dequeue());
        //getFront returns head of the queue
        System.out.println("Two customers are served total: "+queue.dequeue());
        //getFront returns head of the queue
        
        queue.enqueue("Jim arrives.");
        
        System.out.println("Another customer is served. "+queue.dequeue());
        //getFront returns head of the queue
        System.out.println("Another customer is served. "+queue.dequeue());
        //getFront returns head of the queue
        
        System.out.println("Final Queue:"+queue);

    }

}//end class
		
		
		