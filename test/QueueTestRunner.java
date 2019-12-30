package com.cs635.assignment1.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class QueueTestRunner {

	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(QueueTest.class);
		
		for(Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
		
		System.out.println("Result = " + result.wasSuccessful());
	}
}
