package com.cs635.assignment1;

import com.cs635.assignment1.pojo.Process;

public class Sorting {

	public Process mergeSort(Process front, String sortingElement)
	{
		//Base case: if front is null
		if(front == null || front.getNextProcess() == null)
		{
			return front;
		}
		
		//Getting the middle of the queue
		Process middle = getMiddle(front);
		Process nextToMiddle = middle.getNextProcess();
		
		middle.setNextProcess(null);
		
		//Applying merge sort on the left list
		Process left = mergeSort(front, sortingElement);
		
		//Applying merge sort on the right list
		Process right = mergeSort(nextToMiddle, sortingElement);
		
		//Merging the left and right sorted lists
		Process sortedList = mergeSortedQueue(left, right, sortingElement);
		
		return sortedList;
	}
	
	//Method to find the middle element
	private Process getMiddle(Process front) {
		
		Process slow = front, fast = front;
		
		while(fast.getNextProcess() != null && fast.getNextProcess().getNextProcess() != null)
		{
			slow = slow.getNextProcess();
			fast = fast.getNextProcess().getNextProcess();
		}
		
		return slow;
	}

	public Process mergeSortedQueue(Process left, Process right, String sortingElement)
	{
		Process result = null;
		
		//Base Cases
		if(left == null)
		{
			return right;
		}
		if(right == null)
		{
			return left;
		}
		
		//Sorting the list according to the sorting Element provided
		switch(sortingElement.toLowerCase())
		{
		//Sorting the list according to processName
		case "processname":
			if(left.getProcessName().compareTo(right.getProcessName()) >= 0)
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		//Sorting the list according to processOwner
		case "processowner":
			if(left.getProcessOwner().compareTo(right.getProcessOwner()) >= 0)
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		//Sorting the list according to processId
		case "processid":
			if(left.getProcessId() >= right.getProcessId())
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		//Sorting the list according to numberOfThreads
		case "numberofthreads":
			if(left.getNumberOfThreads() >= right.getNumberOfThreads())
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		//Sorting the list according to percentOfCpu
		case "percentofcpu":
			if(left.getPercentOfCpu() >= right.getPercentOfCpu())
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		//Sorting the list according to totalCpuTime
		case "totalcputime":
			if(left.getTotalCpuTime() >= right.getTotalCpuTime())
			{
				result = left;
				result.setNextProcess(mergeSortedQueue(left.getNextProcess(), right, sortingElement));
			}
			else
			{
				result = right;
				result.setNextProcess(mergeSortedQueue(left, right.getNextProcess(), sortingElement));
			}
			break;
		}
		return result;
	}
}
