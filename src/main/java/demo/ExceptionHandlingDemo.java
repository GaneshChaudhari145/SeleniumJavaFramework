package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		try
		{
			System.out.println("Hi..");
			int i=1/0;
			System.out.println("completed");
		}
		catch (Exception e) {
			System.out.println("Inside the catch block");
		}

	}

}
