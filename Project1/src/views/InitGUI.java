package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class InitGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumItems1;
	private JTextField textFieldBookID1;
	private JTextField textFieldQuantity1;
	private JTextField textFieldInfo1;
	private JTextField textFieldSubtotal1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public InitGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InitGUI.class.getResource("/common/noun_2051_cc.png")));
		setTitle("Ye Olde Book Shoppe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//Input Panel
		JPanel panelInputFields = new JPanel();
		contentPane.add(panelInputFields, BorderLayout.CENTER);
		
		JLabel lblItemNums = new JLabel("Enter number of items for this order:");
		lblItemNums.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldNumItems1 = new JTextField();
		textFieldNumItems1.setColumns(10);
		
		textFieldBookID1 = new JTextField();
		textFieldBookID1.setColumns(10);
		
		JLabel labelBookID1 = new JLabel("Enter Book ID for Item #1:");
		labelBookID1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldQuantity1 = new JTextField();
		textFieldQuantity1.setColumns(10);
		
		textFieldInfo1 = new JTextField();
		textFieldInfo1.setColumns(10);
		
		textFieldSubtotal1 = new JTextField();
		textFieldSubtotal1.setColumns(10);
		
		JLabel lblQuantity1 = new JLabel("Enter quantity for Item #1:");
		lblQuantity1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblItemInfo = new JLabel("Item #1 info:");
		lblItemInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblOrderSubtotalOf = new JLabel("Order subtotal of Items(s):");
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
		
		//Button Panel
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(2);
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnProcessItem = new JButton("Process Item #1");
		panelButtons.add(btnProcessItem);
		
		JButton btnConfirmItem = new JButton("Confirm Item #1");
		btnConfirmItem.setEnabled(false);
		panelButtons.add(btnConfirmItem);
		
		JButton btnViewOrder = new JButton("View Order");
		btnViewOrder.setEnabled(false);
		panelButtons.add(btnViewOrder);
		
		JButton btnFinishOrder = new JButton("Finish Order");
		btnFinishOrder.setEnabled(false);
		panelButtons.add(btnFinishOrder);
		
		JButton btnNewOrder = new JButton("New Order");
		panelButtons.add(btnNewOrder);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panelButtons.add(btnExit);
	}
}
