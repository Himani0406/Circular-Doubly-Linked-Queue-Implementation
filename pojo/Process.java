package com.cs635.assignment1.pojo;

public class Process {
	
	//Properties
	private String processName;
	private String processOwner;
	private long processId;
	private long numberOfThreads;
	private double percentOfCpu;
	private double totalCpuTime;
	private Process nextProcess;
	private Process previousProcess;
	
	//Getter methods for properties
	public String getProcessName()
	{
		return processName;
	}
	
	public String getProcessOwner()
	{
		return processOwner;
	}

	public long getProcessId()
	{
		return processId;
	}

	public long getNumberOfThreads()
	{
		return numberOfThreads;
	}

	public double getPercentOfCpu()
	{
		return percentOfCpu;
	}

	public double getTotalCpuTime()
	{
		return totalCpuTime;
	}
	
	//Getter and Setter methods for nextProcess
	public Process getNextProcess()
	{
		return nextProcess;
	}
	
	public void setNextProcess(Process nextProcess)
	{
		this.nextProcess = nextProcess;
	}
	
	//Getter and Setter methods for previousProcess
	public Process getPreviousProcess()
	{
		return previousProcess;
	}
	
	public void setPreviousProcess(Process previousProcess)
	{
		this.previousProcess = previousProcess;
	}
	
	//Constructor for the Process Class
	public Process(String processName, String processOwner, long processId, long numberOfThreads, 
			double percentOfCpu, double totalCpuTime)
	{
		this.processName = processName;
		this.processOwner = processOwner;
		this.processId = processId;
		this.numberOfThreads = numberOfThreads;
		this.percentOfCpu = percentOfCpu;
		this.totalCpuTime = totalCpuTime;
	}

}
