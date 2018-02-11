/**
 * 
 */
package common;

/**
 * @author Austin
 *
 */
public interface Account {
	public void deposit(int value,String threadName );
	public void deduct(int value, String threadName);
}
