/**
 * 
 */
package common;

import java.util.Random;

/**
 * @author Austin
 *
 */
public class Deposit extends Transactions {
	private static Random rand = new Random();
	private Account thisAccount;
	private int depositFunds;
	private String threadName;
	
	public Deposit(Account bank)
	{
		thisAccount = bank;
	}
	
	public void run()
	{
		threadName = Thread.currentThread().getName();
		
		while(true)
		{
			depositFunds = rand.nextInt(199) + 1;
			if(depositFunds % 2 != 0)
			{
				depositFunds++;
			}
			thisAccount.deposit(depositFunds, threadName);
			//this.printMessage();
			
			try {
				Thread.sleep(rand.nextInt(750));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
	@Override
	public void printMessage() {
		// TODO Auto-generated method stub
		System.err.printf("%s deposited\n", threadName);
		
		
	}

}
