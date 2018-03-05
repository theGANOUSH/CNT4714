/**
 * Name: Austin Lowe
 * Course: CNT 4714 – Spring 2018
 * Assignment title: Program 3 – Two-Tier Client-Server Application Development With MySQL and JDBC
 * Date: Sunday March 4, 2018
 * 
 */
package common;

import java.awt.EventQueue;

import views.DBConnectorView;

/**
 * @author Austin
 *
 */
public class DBConnector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnectorView frame = new DBConnectorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
