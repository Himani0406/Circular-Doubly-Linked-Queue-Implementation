package com.cs635.assignment1.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs635.assignment1.Constants;
import com.cs635.assignment1.Queue;
import com.cs635.assignment1.pojo.Process;

import org.junit.Assert;

public class QueueTest {

	private static Queue queue;
	private static Process pAdobeReader, pGoogleChrome, pWindowsExplorer, pSysInternalProcessExplorer, pInvalidNameInput, pInvalidOwnerInput, pInvalidIDInput, 
	pInvalidThreadCountInput, pInvalidCpuPercentInput, pInvalidTotalCpuTimeInput;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeClass
	public static void setUp()
	{
		queue = new Queue(Constants.INITIAL_QUEUE_CAPACITY);
		pAdobeReader = new Process("AcroRd32.exe", "singh", 7920, 23, 0, 0.0056);
		pGoogleChrome = new Process("chrome.exe", "singh", 13624, 31, 0.5, 0.101);
		pWindowsExplorer = new Process("explorer.exe", "singh", 8056, 86, 0.2, 0.03967);
		pSysInternalProcessExplorer = new Process("procexp64.exe", "singh", 18600, 15, 4.6, 0.05783);
		pInvalidNameInput = new Process("", "singh", 7920, 23, 0, 0.0056);
		pInvalidOwnerInput = new Process("procexp64.exe", "  ", 18600, 15, 4.6, 0.05783);
		pInvalidIDInput = new Process("procexp64.exe", "singh", -5, 15, 4.6, 0.05783);
		pInvalidThreadCountInput = new Process("procexp64.exe", "singh", 18600, -1, 4.6, 0.05783);
		pInvalidCpuPercentInput = new Process("procexp64.exe", "singh", 18600, 15, -2, 0.05783);
		pInvalidTotalCpuTimeInput = new Process("procexp64.exe", "singh", 18600, 15, 4.6, -2.8);
	}
	
	@Before
	public void before()
	{
		queue.add(pAdobeReader);
		queue.add(pGoogleChrome);
		queue.add(pWindowsExplorer);
		queue.add(pSysInternalProcessExplorer);
	}
	
	@Test
	public void testAddElement()
	{
		Assert.assertEquals(4, queue.count());
		Assert.assertEquals(pAdobeReader.getProcessId(), queue.peek().getProcessId());
	}
	
	@Test
	public void testShouldRemoveElement()
	{
		Assert.assertEquals(4, queue.count());
		Process removedProcess = queue.remove();
		Assert.assertEquals(pAdobeReader.getProcessId(), removedProcess.getProcessId());
		Assert.assertEquals(3, queue.count());
	}
	
	@Test
	public void testPeekElement()
	{
		Process peek = queue.peek();
		Assert.assertEquals(pAdobeReader.getProcessId(), peek.getProcessId());
	}
	
	@Test
	public void testInvalidNameInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.PROCESS_NAME_MISSING_MESSAGE);
		queue.add(pInvalidNameInput);
	}
	
	@Test
	public void testInvalidOwnerInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.PROCESS_OWNER_MISSING_MESSAGE);
		queue.add(pInvalidOwnerInput);
	}
	
	@Test
	public void testInvalidIDInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.PROCESS_ID_INVALID_MESSAGE);
		queue.add(pInvalidIDInput);
	}
	
	@Test
	public void testInvalidThreadCountInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.INVALID_NO_OF_THREADS_MESSAGE);
		queue.add(pInvalidThreadCountInput);
	}
	
	@Test
	public void testInvalidCpuPercentInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.INVALID_PERCENTAGE_OF_CPU_MESSAGE);
		queue.add(pInvalidCpuPercentInput);
	}
	
	@Test
	public void testInvalidTotalCpuTimeInput()
	{
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(Constants.INVALID_TOTAL_AMT_CPU_MESSAGE);
		queue.add(pInvalidTotalCpuTimeInput);
	}
	
	@After
	public void after()
	{
		queue.clear();
	}
}
