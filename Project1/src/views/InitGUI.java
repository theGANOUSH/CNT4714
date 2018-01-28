package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Book;
import common.FileIO;
import common.Invoice;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class InitGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumItems;
	private JTextField textFieldBookID;
	private JTextField textFieldQuantity;
	private JTextField textFieldInfo;
	private JTextField textFieldSubtotal;
	
	private JLabel labelBookID1 = new JLabel("Enter Book ID for Item #1:");
	private JLabel lblQuantity = new JLabel("Enter quantity for Item #1:");
	private JLabel lblItemInfo = new JLabel("Item #1 info:");
	private JLabel lblOrderSubtotalOf = new JLabel("Order subtotal of 0 Items(s):");
	
	private JButton btnProcessItem = new JButton("Process Item #1");
	private JButton btnConfirmItem = new JButton("Confirm Item #1");
	private JButton btnViewOrder = new JButton("View Order");
	private JButton btnFinishOrder = new JButton("Finish Order");
	private JButton btnNewOrder = new JButton("New Order");
	private JButton btnExit = new JButton("Exit");
	private int numOrders = 0;
	private int count = 1;
	private double purchaseTotal = 0.0;
	
	private List<Book> purchase = new ArrayList<Book>();
	private List<Invoice> purchaseOrder = new ArrayList<Invoice>();
	
	private Book item = null;
	private Invoice itemInvoice = null;
	
	private int bookIDNum = 0;
	private int bookQuantity = 0;

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InitGUI.class.getResource("/views/noun_2051_cc.png")));
		setTitle("Ye Olde Book Shoppe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 249);
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
		
		textFieldNumItems = new JTextField();
		textFieldNumItems.setColumns(20);
		
		textFieldBookID = new JTextField();
		textFieldBookID.setColumns(20);
		
		
		labelBookID1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(20);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setEditable(false);
		textFieldInfo.setColumns(20);
		
		textFieldSubtotal = new JTextField();
		textFieldSubtotal.setEditable(false);
		textFieldSubtotal.setColumns(20);
		
		lblQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		
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
						.addComponent(lblQuantity, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelBookID1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblItemNums, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldSubtotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldInfo, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldBookID, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldNumItems, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
						.addComponent(textFieldQuantity, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
					.addGap(49))
		);
		
		gl_panelInputFields.setVerticalGroup(
			gl_panelInputFields.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelInputFields.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblItemNums)
						.addComponent(textFieldNumItems))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelBookID1)
						.addComponent(textFieldBookID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblItemInfo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInputFields.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldSubtotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		private String strDiscount = null;
		double discount = 0.0;
		double subtotal = 0.0;
		
		private String getViewMessage() {
			
			String viewMessage = "";
			for(int i =1; i <count; i++) {

				viewMessage = viewMessage.concat(i + ". " + purchase.get(i-1).getID() + " " + purchase.get(i-1).getTitle() + " $" + purchase.get(i-1).getPrice() +" " + purchaseOrder.get(i-1).getQuantity() + " " + purchaseOrder.get(i-1).getStrDiscount()+ " " + purchaseOrder.get(i-1).getTotal() + "\n");
			}
			
			return viewMessage;
		}
		
		private void getDiscount(int num, double price) {
			
			if(num >= 15) {
				discount = price * 0.20;
				strDiscount = "20%";
			}
				
			else if(num > 9 && num < 15) {
				discount = price * 0.15;
				strDiscount = "15%";
			}
			else if(num > 4 && num < 10) {
				discount = price * 0.10;
				strDiscount = "10%"; 
			}
			else if(num > 0 && num < 5) {
				discount = price * 0.0;
				strDiscount = "0%"; 
			}
		}

		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			
			String acceptedMessage = "Item #" + Integer.toString(count) +" accepted.";

			if(event.getActionCommand() == "Exit") {
				System.exit(0);
				
			}else {
				try {
					numOrders = Integer.valueOf(textFieldNumItems.getText());
					bookIDNum = Integer.valueOf(textFieldBookID.getText());
					bookQuantity = Integer.valueOf(textFieldQuantity.getText());
					
					}catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Please Enter a Valid Number!", "Error!", JOptionPane.ERROR_MESSAGE);
						
					}
			if(event.getActionCommand().contains("New")) {
				
				count=1;
				purchaseTotal = 0.0;
				purchaseOrder = new ArrayList<Invoice>();
				purchase = new ArrayList<Book>();
				
				textFieldNumItems.setEditable(true);
				textFieldQuantity.setEditable(true);
				textFieldNumItems.setEnabled(true);
				textFieldQuantity.setEnabled(true);
				
				textFieldSubtotal.setText("");
				textFieldInfo.setText("");
				textFieldNumItems.setText("");
				textFieldQuantity.setText("");
				textFieldBookID.setText("");
				
				btnConfirmItem.setEnabled(false);
				btnViewOrder.setEnabled(false);
				btnFinishOrder.setEnabled(false);
				textFieldBookID.setEnabled(true);
				btnProcessItem.setEnabled(true);
				
				labelBookID1.setText("Enter Book ID for item #" + count);
				lblItemInfo.setText("Item #" + count+ " info:");
				lblQuantity.setText("Enter quantity for item #" + count);
				btnProcessItem.setText("Process Item #" + count);
				btnConfirmItem.setText("Confirm Item #" + count);
			
			}
			else if(event.getActionCommand().contains("Finish")) {
				Format transaction = new SimpleDateFormat("YYMMDDHHMMSS");
				Format paneForm = new SimpleDateFormat("dd/MM/yy HH:mm:ss zzzz");
				Date timestamp = new Date();
				String transMessage = "";
				
				for(int i =1; i <count; i++) {
					transMessage = transMessage.concat(transaction.format(timestamp) + ", " + purchase.get(i-1).getID() + ", " + purchase.get(i-1).getTitle() + ", " + purchase.get(i-1).getPrice() +", " + purchaseOrder.get(i-1).getQuantity() + ", " + purchaseOrder.get(i-1).getDiscount()+ ", " + purchaseOrder.get(i-1).getTotal() + ", " + paneForm.format(timestamp) + "\n");
					FileIO.writeTransaction(transMessage);
				}
				
				double tax = 0.06;
				
				String finishMessage = "";
				finishMessage = finishMessage.concat("Date:"+ paneForm.format(timestamp) + "\n\n" +"Number of line items: "+numOrders+"\n\n" + "Item# / ID / Title / Price / Qty / Disc% / Subtotal:\n\n");
				finishMessage = finishMessage.concat(getViewMessage());
				finishMessage = finishMessage.concat("\n\nOrder subtotal: $" + purchaseTotal);
				finishMessage = finishMessage.concat("\n\nTax Rate:  6%\n\n");
				finishMessage = finishMessage.concat("Tax amount:  $" + tax * purchaseTotal);
				finishMessage = finishMessage.concat("\n\nOrder Total:  $" + purchaseTotal * 1.06);
				finishMessage = finishMessage.concat("\n\nThanks for shopping at the Ye Olde Book Shoppe!");
				
				
				JOptionPane.showMessageDialog(null,finishMessage, "Invoice", JOptionPane.PLAIN_MESSAGE);
				
			}
			else if(event.getActionCommand().contains("View")) {
				JOptionPane.showMessageDialog(null,getViewMessage(), "Order", JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(event.getActionCommand().contains("Confirm")) {
				purchase.add(item);
				purchaseOrder.add(itemInvoice);
				
				JOptionPane.showMessageDialog(null,acceptedMessage, "Accepted", JOptionPane.PLAIN_MESSAGE);
				purchaseTotal += subtotal;
				count++;
				
				if(count < numOrders + 1) {
					labelBookID1.setText("Enter Book ID for item #" + count);
					lblItemInfo.setText("Item #" + count+ " info:");
					lblQuantity.setText("Enter quntity for item #" + count);
					btnProcessItem.setText("Process Item #" + count);
					btnConfirmItem.setText("Confirm Item #" + count);
					btnConfirmItem.setEnabled(false);
					
					btnViewOrder.setEnabled(true);
					btnFinishOrder.setEnabled(true);
					
					textFieldSubtotal.setText(Double.toString(purchaseTotal));
					btnProcessItem.setEnabled(true);
					
				}
				else {
					btnConfirmItem.setEnabled(false);
					textFieldNumItems.setEnabled(false);
					
					//textFieldBookID.setText("");
					textFieldBookID.setEnabled(false);
					
					//textFieldQuantity.setText("");
					textFieldQuantity.setEnabled(false);
					
					btnProcessItem.setEnabled(false);
				}	
			}
			
			
			else if(event.getActionCommand().contains("Process")) {
				if(numOrders <= 0) {
					JOptionPane.showMessageDialog(null,"Please Enter a Valid Number of Items!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
				else if(bookIDNum < 0) {
					JOptionPane.showMessageDialog(null,"Please Enter a Valid Book ID!", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				else if(bookQuantity <= 0) {
					JOptionPane.showMessageDialog(null,"Please Enter a Valid Quantity of Books!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
				else {
					try {
						item = FileIO.search(bookIDNum);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(item == null) {
						JOptionPane.showMessageDialog(null,"Book ID " + bookIDNum + " was not found!", "Warning!", JOptionPane.WARNING_MESSAGE);
						}
					else {
						
						getDiscount(bookQuantity, Double.valueOf(item.getPrice()));
						subtotal = (Double.valueOf(item.getPrice()) - discount) * Double.valueOf(bookQuantity);
						itemInvoice = new Invoice(bookQuantity,discount, subtotal, strDiscount);
						
						btnProcessItem.setEnabled(false);
						textFieldInfo.setText(item.toString() + bookQuantity + " " + strDiscount  + " " + "$" + subtotal);
						textFieldNumItems.setEditable(false);
						btnConfirmItem.setEnabled(true);
						btnViewOrder.setEnabled(false);
						lblOrderSubtotalOf.setText("Order subtotal of "+ numOrders + " Items(s):");
						
						}
					}	
				}
			}
		}
	}
}
