package gui;

import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import client.ClientInput;
import manuProto.ClientManager;

public class ClientViewer extends JPanel {
	
	WindowFrame frame;
	ClientManager clientManager;

	public ClientViewer(WindowFrame frame, ClientManager clientManager) {
		this.frame = frame;
		this.clientManager = clientManager;
		
		System.out.println("***" + clientManager.size() + "***");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Account");
		model.addColumn("Money");
		
		for (int i = 0; i < clientManager.size(); i++) {
			Vector row = new Vector();
			ClientInput ci = clientManager.get(i);
			row.add(ci.getId());
			row.add(ci.getName());
			row.add(ci.getAccount());
			row.add(ci.getMoney());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}

}
