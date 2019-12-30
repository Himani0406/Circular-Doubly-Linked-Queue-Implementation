package com.cs635.assignment1.pojo;

public class QueueElements {
	
	//Defining Properties
	private Process front;
	private Process rear;
	
	//Getter and Setter methods for front
	public Process getFront()
	{
		return front;
	}
	
	public void setFront(Process front)
	{
		this.front = front;
	}
	
	//Getter and Setter methods for rear
	public Process getRear()
	{
		return rear;
	}
	
	public void setRear(Process rear)
	{
		this.rear = rear;
	}

}
