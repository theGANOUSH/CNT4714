/**
 * Author: Austin Lowe
 * Date: Jan 27, 2018
 * Project1_2
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
