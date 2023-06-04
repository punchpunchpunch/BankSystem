package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientViewer extends JFrame {

	public ClientViewer() {
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Account");
		model.addColumn("Money");
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Client Viewer");
		this.setVisible(true);
	}

}
