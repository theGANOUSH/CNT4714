/**
 * Name: Austin Lowe
 * Course: CNT 4714 – Spring 2018
 * Assignment title: Program 3 – Two-Tier Client-Server Application Development With MySQL and JDBC
 * Date: Sunday March 4, 2018
 * 
 */
package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;

public class DBConnectorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7986607807936678977L;
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JTextArea textAreaCommand;
	private JLabel lblConnection;
	private JComboBox<String> comboBoxDriver;
	private JComboBox<String> comboBoxURL;
	private JTable tableResults;
	private boolean isConnected = false;
	private JScrollPane scrollPaneResults;
	
	/**
	 * Create the frame.
	 */
	public DBConnectorView() {
		setTitle("SQL Client GUI");
		String[] driverList = new String[]{ "com.mysql.jdbc.Driver", "oracle.jdbc.driver.OracleDriver", "com.ibm.db2.jdbc.netDB2Driver", "com.jdbc.odbc.jdbcOdbcDriver" };
		String[] urlList = new String[] { "jdbc:mysql://localhost:3306/project3", "jdbc:mysql://192.168.1.14:3306/project3"};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		JPanel dbInfopanel = new JPanel();
		
		textAreaCommand = new JTextArea();
		GridBagLayout gbl_dbInfopanel = new GridBagLayout();
		gbl_dbInfopanel.columnWidths = new int[] {75, 75, 0};
		gbl_dbInfopanel.rowHeights = new int[]{27, 27, 27, 27, 0};
		gbl_dbInfopanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_dbInfopanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		dbInfopanel.setLayout(gbl_dbInfopanel);
		
		JLabel jdbclbl = new JLabel("JDBC Driver:");
		GridBagConstraints gbc_jdbclbl = new GridBagConstraints();
		gbc_jdbclbl.fill = GridBagConstraints.BOTH;
		gbc_jdbclbl.insets = new Insets(0, 0, 5, 5);
		gbc_jdbclbl.gridx = 0;
		gbc_jdbclbl.gridy = 0;
		dbInfopanel.add(jdbclbl, gbc_jdbclbl);
		
		comboBoxDriver = new JComboBox(driverList);
		
		
		GridBagConstraints gbc_comboBoxDriver = new GridBagConstraints();
		gbc_comboBoxDriver.fill = GridBagConstraints.BOTH;
		gbc_comboBoxDriver.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxDriver.gridx = 1;
		gbc_comboBoxDriver.gridy = 0;
		dbInfopanel.add(comboBoxDriver, gbc_comboBoxDriver);
		
		JLabel dbURLlbl = new JLabel("Database URL:");
		GridBagConstraints gbc_dbURLlbl = new GridBagConstraints();
		gbc_dbURLlbl.fill = GridBagConstraints.BOTH;
		gbc_dbURLlbl.insets = new Insets(0, 0, 5, 5);
		gbc_dbURLlbl.gridx = 0;
		gbc_dbURLlbl.gridy = 1;
		dbInfopanel.add(dbURLlbl, gbc_dbURLlbl);
		
		comboBoxURL = new JComboBox(urlList);
		GridBagConstraints gbc_comboBoxURL = new GridBagConstraints();
		gbc_comboBoxURL.fill = GridBagConstraints.BOTH;
		gbc_comboBoxURL.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxURL.gridx = 1;
		gbc_comboBoxURL.gridy = 1;
		dbInfopanel.add(comboBoxURL, gbc_comboBoxURL);
		
		JLabel userNamelbl = new JLabel("Username:");
		userNamelbl.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_userNamelbl = new GridBagConstraints();
		gbc_userNamelbl.fill = GridBagConstraints.BOTH;
		gbc_userNamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_userNamelbl.gridx = 0;
		gbc_userNamelbl.gridy = 2;
		dbInfopanel.add(userNamelbl, gbc_userNamelbl);
		
		textFieldUserName = new JTextField();
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.fill = GridBagConstraints.BOTH;
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 2;
		dbInfopanel.add(textFieldUserName, gbc_textFieldUserName);
		
		textFieldUserName.setColumns(10);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		dbInfopanel.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		dbInfopanel.add(passwordField, gbc_passwordField);
		
		
		JButton btnConnect = new JButton("Connect to Database");
		JButton btnClearSqlCommand = new JButton("Clear SQL Command");
		JButton btnExecuteSqlCommand = new JButton("Execute SQL Command");
		
		lblConnection = new JLabel("No Connection");
		
		scrollPaneResults = new JScrollPane();
		
		JButton btnClearResults = new JButton("Clear Results Window");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPaneResults, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(dbInfopanel, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblConnection)
									.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
									.addComponent(btnConnect)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnClearSqlCommand)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExecuteSqlCommand)))
							.addGap(4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnClearResults)
							.addContainerGap(527, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dbInfopanel, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExecuteSqlCommand)
						.addComponent(btnClearSqlCommand)
						.addComponent(btnConnect)
						.addComponent(lblConnection))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneResults, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(btnClearResults))
		);
		
		textAreaCommand.setLineWrap(true);
		scrollPane.setViewportView(textAreaCommand);
		contentPane.setLayout(gl_contentPane);
		
		ButtonHandler actionhandler = new ButtonHandler();
		
		btnClearSqlCommand.addActionListener(actionhandler);
		btnConnect.addActionListener(actionhandler);
		btnClearResults.addActionListener(actionhandler);
		btnExecuteSqlCommand.addActionListener(actionhandler);
		
	}
	
	private class ButtonHandler implements ActionListener{
		
		Connection connection;
		ResultSet resultSet;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getActionCommand() == "Clear SQL Command") {
				textAreaCommand.setText(null);
			
			}
			if(arg0.getActionCommand() == "Connect to Database") {
				//textFieldUserName.setEditable(false);
				//passwordField.setEditable(false);
				
				String password = new String(passwordField.getPassword());
				
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setUser(textFieldUserName.getText());
				dataSource.setPassword(password);
				dataSource.setURL(comboBoxURL.getSelectedItem().toString());
				
				try {
					
					connection = dataSource.getConnection();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog( null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE );
				}
				lblConnection.setText("Connected to " + comboBoxURL.getSelectedItem());
				isConnected = true;
			}
			if(arg0.getActionCommand() == "Clear Results Window") {
				DefaultTableModel model = (DefaultTableModel) tableResults.getModel();
				model.getDataVector().removeAllElements();
				model.setColumnCount(0);
				model.fireTableDataChanged();
			
			}
			
			if(arg0.getActionCommand() == "Execute SQL Command") {
				if(!isConnected) {
					JOptionPane.showMessageDialog(null,"Please Connect to a Database!", "Warning!", JOptionPane.WARNING_MESSAGE);
				}
				if(isConnected && textAreaCommand.getText() != null ) {
					try {
						Statement statement = connection.createStatement();
						
						if(textAreaCommand.getText().contains("select") || textAreaCommand.getText().contains("SELECT")) {
							resultSet = statement.executeQuery(textAreaCommand.getText());
							
							tableResults = new JTable(resultSetToTableModel(resultSet));
							scrollPaneResults.setViewportView(tableResults);
						}
						else{
							
							statement.executeUpdate(textAreaCommand.getText());
						}
						}catch (SQLException e) {
							JOptionPane.showMessageDialog( null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE );
					}
				}
				
			}
		}
		
		public TableModel resultSetToTableModel(ResultSet rs) {
	        try {
	            java.sql.ResultSetMetaData metaData = rs.getMetaData();
	            int numberOfColumns = metaData.getColumnCount();
	            Vector<String> columnNames = new Vector<String>();

	            // Get the column names
	            for (int column = 0; column < numberOfColumns; column++) {
	                columnNames.addElement(metaData.getColumnLabel(column + 1));
	            }

	            // Get all rows.
	            Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

	            while (rs.next()) {
	                Vector<Object> newRow = new Vector<Object>();

	                for (int i = 1; i <= numberOfColumns; i++) {
	                    newRow.addElement(rs.getObject(i));
	                }

	                rows.addElement(newRow);
	            }

	            return new DefaultTableModel(rows, columnNames);
	        } catch (Exception e) {
	            e.printStackTrace();

	            return null;
	        }
	    }
		
		
		
	}
}
