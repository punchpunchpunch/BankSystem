package gui;

import javax.swing.*;

public class ClientAdder extends JFrame {
	
	public ClientAdder() {
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelID = new JLabel("ID: ", JLabel.TRAILING);
		JTextField fieldID = new JTextField(10);
		labelID.setLabelFor(fieldID);
		panel.add(labelID);
		panel.add(fieldID);
		
		JLabel labelName = new JLabel("Name: ", JLabel.TRAILING);
		JTextField fieldName = new JTextField(10);
		labelName.setLabelFor(fieldName);
		panel.add(labelName);
		panel.add(fieldName);
		
		JLabel labelAccount = new JLabel("Account: ", JLabel.TRAILING);
		JTextField fieldAccount = new JTextField(10);
		labelAccount.setLabelFor(fieldAccount);
		panel.add(labelAccount);
		panel.add(fieldAccount);
		
		JLabel labelMoney = new JLabel("Money: ", JLabel.TRAILING);
		JTextField fieldMoney = new JTextField(10);
		labelMoney.setLabelFor(fieldMoney);
		panel.add(labelMoney);
		panel.add(fieldMoney);
		
		JButton buttonSave = new JButton("Save");
		JButton buttonCancel = new JButton("Cancel");
		
		SpringUtilities.makeCompactGrid(panel, 4, 2, 6, 6, 6, 6);
		
		this.setContentPane(panel);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(getTitle());
		this.setVisible(true);
		
	}

}
