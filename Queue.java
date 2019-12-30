package com.cs635.assignment1;

import com.cs635.assignment1.pojo.Process;
import com.cs635.assignment1.pojo.QueueElements;

public class Queue {

	//Declaring class variables
	private int initialCapacity, numberOfElements;
	private QueueElements queueElements;
	private static Sorting sorting;
	
	//Constructor to check the initial capacity and instantiate class objects required
	public Queue(int initialCapacity)
	{
		if(initialCapacity <= 1)
		{
			throw new IllegalArgumentException(Constants.INVALID_INITIAL_CAPACITY);
		}
		
		this.initialCapacity = initialCapacity;
		this.numberOfElements = 0;
		queueElements = new QueueElements();
		sorting = new Sorting();
	}
	
	//Method to add a new process to the queue
	public void add(Process process)
	{
		if(validate(process))
		{
			//Increasing the initial capacity to twice the value in case the number of elements exceed it
			if(numberOfElements == initialCapacity)
			{
				initialCapacity *= 2;
			}
			
			//If queue is empty, value for front is to be set.
			if(queueElements.getFront() == null)
			{
				queueElements.setFront(process);
			}
			else
			{
				queueElements.getRear().setNextProcess(process);
				process.setPreviousProcess(queueElements.getRear());
			}
			
			queueElements.setRear(process);
			queueElements.getRear().setNextProcess(queueElements.getFront());
			queueElements.getFront().setPreviousProcess(process);
			
			numberOfElements++;
		}
		
	}
	
	//Function to remove a process from the queue
	public Process remove()
	{
		Process processReturned = null;
		
		//Checking if the queue is empty
		if(isEmpty())
		{
			System.out.println(Constants.QUEUE_EMPTY_MESSAGE);
			return null;
		}
		else
		{
			//Condition to check if only 1 element exists in the queue
			if(queueElements.getFront() == queueElements.getRear())
			{
				processReturned = queueElements.getFront();
				queueElements.setFront(null);
				queueElements.setRear(null);
			}
			else
			{
				processReturned = queueElements.getFront();
				queueElements.setFront(processReturned.getNextProcess());
				queueElements.getRear().setNextProcess(queueElements.getFront());
				queueElements.getFront().setPreviousProcess(queueElements.getRear());
			}
			numberOfElements--;
			return processReturned;
		}
	}
	
	//Method to clear the queue
	public void clear()
	{
		queueElements = new QueueElements();
		numberOfElements = 0;
	}
	
	//Method to print the queue
	public void print(String sortingElement)
	{
		//Condition to check if the queue is empty
		if(isEmpty())
		{
			System.out.println(Constants.QUEUE_EMPTY_MESSAGE);
		}
		//Condition to check if the sorting element provided is a valid type
		else if(sortingElement.equalsIgnoreCase("processname") && sortingElement.equalsIgnoreCase("processowner") && sortingElement.equalsIgnoreCase("processid") && 
				sortingElement.equalsIgnoreCase("numberofthreads") && sortingElement.equalsIgnoreCase("percentofcpu") && sortingElement.equalsIgnoreCase("totalcputime"))
		{
			System.out.println(Constants.INVALID_SORT_ELEMENT_MESSAGE);
		}
		else
		{
			//Cloning the queue to sort it
			QueueElements sortedElements = cloneQueue();
			
			//Sorting the queue according to the element provided
			sortedElements.setFront(sorting.mergeSort(sortedElements.getFront(), sortingElement));
			
			Process front = sortedElements.getFront();
			
			//Print the sorted queue
			do
			{
				System.out.println("Process Name: " + front.getProcessName() + "|Process Owner: " + front.getProcessOwner()
				+ "|Process ID: " + front.getProcessId() + "|Number Of Threads: " + front.getNumberOfThreads()
				+ "|Percentage of CPU Time: " + front.getPercentOfCpu() + "|Total CPU Time Used: " + front.getTotalCpuTime());
				
				front = front.getNextProcess();
				
			}while(front != null);
			
		}
	}
	
	//Method to return the top element in the queue
	public Process peek()
	{
		if(isEmpty())
		{
			System.out.println(Constants.QUEUE_EMPTY_MESSAGE);
			return null;
		}
		else
		{
			return queueElements.getFront();
		}
	}

	//Method to get the number of elements in the queue.
	public int count()
	{
		return numberOfElements;
	}
	
	//Method to get the capacity of the queue.
	public int size()
	{
		return initialCapacity;
	}
		
	//Method to clone the queue
	private QueueElements cloneQueue() {
		
		QueueElements sortedElements = new QueueElements();
		
		Process front = queueElements.getFront();
		Process copyElement = new Process(front.getProcessName(), front.getProcessOwner(), front.getProcessId(), front.getNumberOfThreads(), front.getPercentOfCpu(), front.getTotalCpuTime());
		copyElement.setNextProcess(null);
		
		//Copying the first element in the cloned queue
		sortedElements.setFront(copyElement);
		sortedElements.setRear(copyElement);
		
		//Copying all the remaining elements to the new queue
		while(front.getNextProcess() != queueElements.getFront())
		{
			copyElement = front.getNextProcess();
			Process newElement = new Process(copyElement.getProcessName(), copyElement.getProcessOwner(), copyElement.getProcessId(), copyElement.getNumberOfThreads(),
					copyElement.getPercentOfCpu(), copyElement.getTotalCpuTime());
			
			newElement.setNextProcess(null);
			sortedElements.getRear().setNextProcess(newElement);
			sortedElements.setRear(newElement);
			
			front = copyElement;
		}
		
		return sortedElements;
	}

	//Method to check if the queue is empty
	private boolean isEmpty() {
		if(numberOfElements == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Method to validate the elements of the process
	private boolean validate(Process process) {
		
		if(process.getProcessName().isEmpty() || process.getProcessName().isBlank())
		{
			throw new IllegalArgumentException(Constants.PROCESS_NAME_MISSING_MESSAGE);
		}
		
		if(process.getProcessOwner().isEmpty() || process.getProcessOwner().isBlank())
		{
			throw new IllegalArgumentException(Constants.PROCESS_OWNER_MISSING_MESSAGE);
		}
		
		if(process.getProcessOwner().isEmpty() || process.getProcessOwner().isBlank())
		{
			throw new IllegalArgumentException(Constants.PROCESS_OWNER_MISSING_MESSAGE);
		}
		
		if(process.getProcessId() < 0)
		{
			throw new IllegalArgumentException(Constants.PROCESS_ID_INVALID_MESSAGE);
		}
		
		if(process.getNumberOfThreads() < 0)
		{
			throw new IllegalArgumentException(Constants.INVALID_NO_OF_THREADS_MESSAGE);
		}
		
		if(process.getPercentOfCpu() < 0)
		{
			throw new IllegalArgumentException(Constants.INVALID_PERCENTAGE_OF_CPU_MESSAGE);
		}
		
		if(process.getTotalCpuTime() < 0)
		{
			throw new IllegalArgumentException(Constants.INVALID_TOTAL_AMT_CPU_MESSAGE);
		}
		
		return true;
	}
}
