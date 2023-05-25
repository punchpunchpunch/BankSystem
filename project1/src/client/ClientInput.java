package client;

import java.util.Scanner;

public interface ClientInput {
	
	public int getId();
	public void setId(int id);
	
	public void setName(String name);
	public void setAccount(int account);
	
	public int getMoney();
	public void setMoney(int money);
	
	public void outMoney(int m);
	public void inMoney(int m);
	
	public void getUserInput(Scanner sc);
	public void printInfo();
	
	public void setClientId(Scanner sc);
	public void setClientName(Scanner sc);
	public void setClientAccount(Scanner sc);
	public void setClientMoney(Scanner sc);
}