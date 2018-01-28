/**
 * Name: Austin Lowe
 * Course: CNT 4714 – Spring 2018
 * Assignment title: Program 1 – Event-driven Programming
 * Date: Sunday January 28, 2018
 * 
 */
package common;

import java.awt.EventQueue;
import views.InitGUI;

public class OleBookShoppe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitGUI frame = new InitGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
