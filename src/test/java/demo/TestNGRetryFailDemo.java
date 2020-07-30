package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyzer;


public class TestNGRetryFailDemo{

	
	@Test
	public void test1()
	{
		System.out.println("Inside Test1");
	}
	
	@Test(retryAnalyzer= RetryAnalyzer.class)
	public void test2()
	{
		System.out.println("Inside Test2");
		int i=1/0;
	}
	
	@Test(retryAnalyzer= RetryAnalyzer.class)
	public void test13()
	{
		System.out.println("Inside Test3");
		Assert.assertTrue(0>1);
		
	}
}
