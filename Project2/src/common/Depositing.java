/** Name:Austin Lowe
 * Course: CNT 4714 Spring 2018
 * Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
 * Due Date: February 11, 2018
*/
package common;

import java.util.Random;

/**
 * @author au965898
 *
 */
public class Depositing extends Thread {
	
	private static Random rand = new Random();
	private Account thisAccount;
	private int saved;
	private String thread;
	
	
	public Depositing(Account bankAccount)
	{
		thisAccount = bankAccount;
		
	}
	
	public void run()
	{
		thread = Thread.currentThread().getName();
		
		while(true)
		{
			
			saved = rand.nextInt(199) + 1;
			
			if(saved %2 !=0)
			{
				saved++;
			}
			
			
			
			try 
			{
				Thread.sleep(rand.nextInt(300));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
