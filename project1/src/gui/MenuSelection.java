package gui;

import javax.swing.*;

import listeners.ButtonAddListener;
import listeners.ButtonViewListener;

import java.awt.BorderLayout;

public class MenuSelection extends JPanel {
	
	WindowFrame frame;
	
	public MenuSelection(WindowFrame frame) {
		
		this.frame = frame;
		
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JLabel label = new JLabel("Menu Selection");
		JButton button1 = new JButton("Add Client");
		JButton button2 = new JButton("Delete Client");
		JButton button3 = new JButton("View Client");
		JButton button4 = new JButton("Deposit/Withdraw");
		JButton button5 = new JButton("Edit Client");
		JButton button6 = new JButton("Exit");
		
		button1.addActionListener(new ButtonAddListener(frame));
		button3.addActionListener(new ButtonViewListener(frame));
		
		panel1.add(label);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		
	}
	
}
