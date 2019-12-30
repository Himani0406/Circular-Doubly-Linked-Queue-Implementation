package com.cs635.assignment1;

import com.cs635.assignment1.pojo.Process;

public class Main {

	//Main method
	public static void main(String[] args)
	{
		//Creating a new queue with the initial capacity of 10
		Queue queue = new Queue(Constants.INITIAL_QUEUE_CAPACITY);
		
		//Creating processes to test
		Process adobeReader = new Process("AcroRd32.exe", "singh", 7920, 23, 0, 0.0056);
		Process googleChrome = new Process("chrome.exe", "singh", 13624, 31, 0.5, 0.101);
		Process windowsExplorer = new Process("explorer.exe", "singh", 8056, 86, 0.2, 0.03967);
		Process sysInternalProcessExplorer = new Process("procexp64.exe", "singh", 18600, 15, 4.6, 0.05783);
		
		//Adding the processes created to the queue
		queue.add(adobeReader);
		queue.add(googleChrome);
		queue.add(windowsExplorer);
		queue.add(sysInternalProcessExplorer);
		
		//Printing the queue according to the processID
		queue.print("processId");
	}
}
