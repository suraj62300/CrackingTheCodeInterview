package com.suraj.code.interviewbook;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	
	private static class QueueNode<T> { 
		private T data; 
		private QueueNode<T> next;
		public QueueNode(T data) { 
			this.data = data; 
		}
	}
	
	private QueueNode<T> first; 
	private QueueNode<T> last; 
	
	public void add(T item) { 
		QueueNode<T> t = new QueueNode<T>(item); 
		if (last != null) {
			last.next= t; 
		}
		last = t; 
		if (first== null) { 
			first= last; 
		} 
	}
	
	public T remove() { 
		if (first== null) throw new NoSuchElementException(); 
		T data= first.data; 
		first= first.next; 
		if (first == null) { 
			last=  null; 
		}
		return data; 
	}
	
	public T peek() { 
		if (first== null) throw new NoSuchElementException(); 
		return first.data; 
	}
	
	public boolean isEmpty() { 
		return first== null; 
	}
	
	@Override
	public String toString() {
		String string = new String();
		while(!isEmpty()) {
			string = string + " "+ peek();
			first = first.next;
		}
		return string;
	}
	
	public static void main(String[] args) {

		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.add(25);
		myQueue.add(35);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.toString());
	
	}

}
