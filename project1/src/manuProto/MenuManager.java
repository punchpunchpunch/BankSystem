package manuProto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import log.EventLogger;

/**
 *학생 은행 프로그램의 메뉴 화면
 */
public class MenuManager {
	
	static EventLogger logger = new EventLogger("log.txt");
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ClientManager clientManager = getObject("clientmanager.ser");
		if (clientManager == null) {
			clientManager = new ClientManager(sc);
		}
		
		selectMenu(sc, clientManager);
		putObject(clientManager, "clientmanager.ser");
		
		System.out.println("End the program");
	}
	
	public static void selectMenu(Scanner sc, ClientManager clientManager) {
		int num = -1;
		while(num != 6) {
			try {
				showMenu();
				
				num = sc.nextInt();
				
				// switch문을 사용하여 num 변수에 따라 각각 다른 메소드 수행
				switch(num) {
				case 1:
					clientManager.addClient();
					logger.log("add a client");
					break;
				case 2:
					clientManager.deleteClient();
					logger.log("delete a client");
					break;
				case 3:
					clientManager.viewClient();
					logger.log("view a client");
					break;
				case 4:
					clientManager.dwFunction();
					logger.log("deposit or withdraw");
					break;
				case 5:
					clientManager.edit();
					logger.log("edit a client");
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put a integer between 1 and 5!");
				if (sc.hasNext()) {
					sc.next();
				}
				num = -1;
			}
		}
	}

	public static void showMenu() {
		System.out.println("Menu");
		System.out.println("\t1. New Account");
		System.out.println("\t2. Delete Acoount");
		System.out.println("\t3. Infomation");
		System.out.println("\t4. Deposit/Withdrawal");
		System.out.println("\t5. Client Editor");
		System.out.println("\t6. Exit");
		System.out.print("Select one number between 1 ~ 6: ");
	}
	
	public static ClientManager getObject(String filename) {
		ClientManager clientManager = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			clientManager = (ClientManager) in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return clientManager;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientManager;
	}
	
	public static void putObject(ClientManager clientManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(clientManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}