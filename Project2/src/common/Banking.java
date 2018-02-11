/**
 * 
 */
package common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Austin
 *
 */
public class Banking implements Account {
	
	private int accountBalance = 0;
	
	private Lock access = new ReentrantLock();
	private Condition enableDeposit = access.newCondition();
	private Condition enableWithdrawal = access.newCondition();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banking newAccount = new Banking();
		
		Deposit depositThread1 = new Deposit(newAccount);
		Deposit depositThread2 = new Deposit(newAccount);
		Deposit depositThread3 = new Deposit(newAccount);
		Deposit depositThread4 = new Deposit(newAccount);
		
		Withdraw withdrawThread1 = new Withdraw(newAccount);
		Withdraw withdrawThread2 = new Withdraw(newAccount);
		Withdraw withdrawThread3 = new Withdraw(newAccount);
		Withdraw withdrawThread4 = new Withdraw(newAccount);
		Withdraw withdrawThread5 = new Withdraw(newAccount);
		Withdraw withdrawThread6 = new Withdraw(newAccount);
		
		depositThread1.setName("D1");
		depositThread2.setName("D2");
		depositThread3.setName("D3");
		depositThread4.setName("D4");
		
		withdrawThread1.setName("W1");
		withdrawThread2.setName("W2");
		withdrawThread3.setName("W3");
		withdrawThread4.setName("W4");
		withdrawThread5.setName("W5");
		withdrawThread6.setName("W6");
		
		System.out.println("Your Bank Account");
		System.out.printf("%s\t\t%s\t\t%s\n", "Deposit Threads", "Withdrawal Threads", "Balance");
		System.out.printf("%s\t\t%s\t\t%s\n", "---------------", "------------------", "-----------");
		
		depositThread1.start();
		depositThread2.start();
		depositThread3.start();
		depositThread4.start();
		
		withdrawThread1.start();
		withdrawThread2.start();
		withdrawThread3.start();
		withdrawThread4.start();
		withdrawThread5.start();
		withdrawThread6.start();
		
	}


	@Override
	public void deposit(int value, String threadName) {
		// TODO Auto-generated method stub
		access.lock();
		try 
		{
			accountBalance += value;
			System.out.printf("Thread %s deposits $%d\t\t\t\t\tBalance is $%d\n", threadName, value, accountBalance);
			
			enableWithdrawal.signalAll();
			enableDeposit.await();
			
		}catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}finally
		{
			access.unlock();
		}
	}


	@Override
	public void deduct(int value, String threadName) {
		// TODO Auto-generated method stub
		access.lock();
		try 
		{
			if(accountBalance > value)
			{
				accountBalance -= value;
				System.out.printf("\t\t\tThread %s withdraws $%d\t\tBalance is $%d\n", threadName, value, accountBalance);
			}else {
				System.out.printf("\t\t\tThread %s withdraws $%d\tWithdrawal - Blocked - Insufficient Funds\n", threadName, value);
				
			}
		}catch(Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}finally
		{
			enableDeposit.signalAll();
			try {
				enableWithdrawal.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
			access.unlock();
		}
	}

}
