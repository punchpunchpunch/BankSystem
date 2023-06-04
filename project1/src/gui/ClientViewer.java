package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientViewer extends JFrame {

	public ClientViewer() {
		String column[] = {"ID", "Name", "Account", "Money"};
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Account");
		model.addColumn("Money");
		model.addColumn("Contact Info.");
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Client Viewer");
		this.setVisible(true);
	}

}
