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
public class Withdrawing
{
	
	private static Random rand = new Random();
	private Account thisAccount;
	private int removed;
	private String thread;
	
	public Withdrawing(Account deduction)
	{
		thisAccount = deduction;
		
	}
	
	public void run()
	{
		thread = Thread.currentThread().getName();
		
		while(true)
		{
			
			removed = rand.nextInt(49) + 1;
			
			if(removed %2 !=0)
			{
				removed++;
			}
			
			
			try 
			{
				Thread.sleep(rand.nextInt(150));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}