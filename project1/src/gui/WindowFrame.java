package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import manuProto.ClientManager;

public class WindowFrame extends JFrame {
	
	ClientManager clientManager;
	MenuSelection menuSelection;
	ClientAdder clientAdder;
	ClientViewer clientViewer;
	
	public WindowFrame(ClientManager clientManager) {
		this.clientManager = clientManager;
		this.menuSelection = new MenuSelection(this);
		this.clientAdder = new ClientAdder(this);
		this.clientViewer = new ClientViewer(this, this.clientManager);

		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(getTitle());
		
		this.setupPanel(menuSelection);
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuSelection() {
		return menuSelection;
	}

	public void setMenuSelection(MenuSelection menuSelection) {
		this.menuSelection = menuSelection;
	}

	public ClientAdder getClientAdder() {
		return clientAdder;
	}

	public void setClientAdder(ClientAdder clientAdder) {
		this.clientAdder = clientAdder;
	}

	public ClientViewer getClientViewer() {
		return clientViewer;
	}

	public void setClientViewer(ClientViewer clientViewer) {
		this.clientViewer = clientViewer;
	}

}
