package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InitGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumItems1;
	private JTextField textFieldBookID1;
	private JTextField textFieldQuantity1;
	private JTextField textFieldInfo1;
	private JTextField textFieldSubtotal1;
	
	private JLabel labelBookID1 = new JLabel("Enter Book ID for Item #1:");
	private JLabel lblQuantity1 = new JLabel("Enter quantity for Item #1:");
	private JLabel lblItemInfo = new JLabel("Item #1 info:");
	private JLabel lblOrderSubtotalOf = new JLabel("Order subtotal of Items(s):");
	
	private JButton btnProcessItem = new JButton("Process Item #1");
	private JButton btnConfirmItem = new JButton("Confirm Item #1");
	private JButton btnViewOrder = new JButton("View Order");
	private JButton btnFinishOrder = new JButton("Finish Order");
	private JButton btnNewOrder = new JButton("New Order");
	private JButton btnExit = new JButton("Exit");
	private int numOrders = 0;

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setTitle("Ye Olde Book Shoppe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(2);
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		
		panelButtons.add(btnProcessItem);
		panelButtons.add(btnConfirmItem);
		panelButtons.add(btnViewOrder);
		panelButtons.add(btnFinishOrder);
		panelButtons.add(btnNewOrder);
		panelButtons.add(btnExit);
		
		
		btnConfirmItem.setEnabled(false);
		btnViewOrder.setEnabled(false);
		btnFinishOrder.setEnabled(false);
		
		JPanel panelInputFields = new JPanel();
		contentPane.add(panelInputFields, BorderLayout.CENTER);
		
		JLabel lblItemNums = new JLabel("Enter number of items for this order:");
		lblItemNums.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldNumItems1 = new JTextField();
		textFieldNumItems1.setColumns(10);
		
		textFieldBookID1 = new JTextField();
		textFieldBookID1.setColumns(10);
		
		
		labelBookID1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldQuantity1 = new JTextField();
		textFieldQuantity1.setColumns(10);
		
		textFieldInfo1 = new JTextField();
		textFieldInfo1.setColumns(10);
		
		textFieldSubtotal1 = new JTextField();
		textFieldSubtotal1.setColumns(10);
		
		lblQuantity1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblItemInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		lblOrderSubtotalOf.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panelInputFields = new GroupLayout(panelInputFields);
		gl_panelInputFields.setHorizontalGroup(
			gl_panelInputFields.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelInputFields.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblOrderSubtotalOf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblItemInfo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblQuantity1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelBookID1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblItemNums, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldSubtotal1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldInfo1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldBookID1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldNumItems1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldQuantity1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
					.addGap(49))
		);
		
		gl_panelInputFields.setVerticalGroup(
			gl_panelInputFields.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelInputFields.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemNums)
						.addComponent(textFieldNumItems1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelBookID1)
						.addComponent(textFieldBookID1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldQuantity1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldInfo1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldSubtotal1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrderSubtotalOf))
					.addGap(22))
		);
		panelInputFields.setLayout(gl_panelInputFields);
		
		ButtonHandler actionhandler = new ButtonHandler();
		btnProcessItem.addActionListener(actionhandler);
		btnConfirmItem.addActionListener(actionhandler);
		btnViewOrder.addActionListener(actionhandler);
		btnFinishOrder.addActionListener(actionhandler);
		btnNewOrder.addActionListener(actionhandler);
		btnExit.addActionListener(actionhandler);
		
		
	}
	
	private class ButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			int bookIDNum = 0;
			int bookQuantity = 0;
			int count = 1;

			if(event.getActionCommand() == "Exit") {
				System.exit(0);
				
			}else {
				
			try {
				numOrders = Integer.valueOf(textFieldNumItems1.getText());
				bookIDNum = Integer.valueOf(textFieldBookID1.getText());
				bookQuantity = Integer.valueOf(textFieldQuantity1.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Please Enter a Valid Number!", "Error!", JOptionPane.ERROR_MESSAGE);
					
				}				
					
				if(event.getActionCommand().contains("Process")) {
					if(numOrders <= 0) {
						System.out.println(textFieldNumItems1.getText());
						JOptionPane.showMessageDialog(null,"Please Enter a Valid Number of Items!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else if(bookIDNum < 0) {
						JOptionPane.showMessageDialog(null,"Please Enter a Valid Book ID!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else if(bookQuantity <= 0) {
						JOptionPane.showMessageDialog(null,"Please Enter a Valid Quantity of Books!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						
						String acceptedMessage = "Item#" + Integer.toString(count) +" accepted.";
						JOptionPane.showMessageDialog(null,acceptedMessage, "Accepted", JOptionPane.PLAIN_MESSAGE);
						textFieldNumItems1.setEditable(false);
						btnConfirmItem.setEnabled(true);
						
					}
				
				}
				
			}
		}
	}
}
