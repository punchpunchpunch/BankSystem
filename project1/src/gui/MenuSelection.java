package gui;

import javax.swing.*;
import java.awt.BorderLayout;

public class MenuSelection extends JFrame {
	
	public MenuSelection() {
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Menu Selection");
		JButton button1 = new JButton("Add Client");
		JButton button2 = new JButton("Delete Client");
		JButton button3 = new JButton("View Client");
		JButton button4 = new JButton("Deposit/Withdraw");
		JButton button5 = new JButton("Edit Client");
		JButton button6 = new JButton("Exit");
		
		panel1.add(label);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);

		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(getTitle());
		this.setVisible(true);
		
	}
	
}
