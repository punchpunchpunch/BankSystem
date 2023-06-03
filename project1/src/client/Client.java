package client;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Client implements ClientInput, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3578097752952216421L;
	protected ClientKind kind = ClientKind.UNIVERSITY;
	protected String name;
	protected int id;
	protected int account;
	protected int money = 0;
	
	public Client() {
	}
	
	public Client(ClientKind kind) {
		this.kind = kind;
	}
	
	public Client(String name, int id, int account){
		this.name = name;
		this.id = id;
		this.account = account;
	}
	
	public Client(String name, int id, int account, int money){
		this.name = name;
		this.id = id;
		this.account = account;
		this.money = money;
	}
	
	public Client(ClientKind kind, String name, int id, int account, int money){
		this.kind = kind;
		this.name = name;
		this.id = id;
		this.account = account;
		this.money = money;
	}
	
	public ClientKind getKind() {
		return kind;
	}

	public void setKind(ClientKind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getAccount() {
		return account;
	}
	
	public void setAccount(int account) {
		this.account = account;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void outMoney(int m) {
		setMoney(this.money - m);
	}
	
	public void inMoney(int m) {
		setMoney(this.money + m);
	}
	
	public abstract void printInfo();
	
	public void setClientId(Scanner sc) {
		System.out.print("Client ID : ");
		int id = sc.nextInt();
		this.setId(id);
	}
	
	public void setClientName(Scanner sc) {
		System.out.print("Client Name : ");
		String name = sc.next();
		this.setName(name);
	}
	
	public void setClientAccount(Scanner sc) {
		System.out.print("Client Account : ");
		int account = sc.nextInt();
		this.setAccount(account);
	}
	
	public void setClientMoney(Scanner sc) {
		System.out.print("Client Money: ");
		int money = sc.nextInt();
		this.setMoney(money);
	}
	
	public String getKindString() {
		String ckind ="none";
		switch (this.kind) {
		case UNIVERSITY :
			ckind = "대학생";
			break;
		case HIGHSCHOOL :
			ckind = "고등학생";
			break;
		case MIDDLESCHOOL :
			ckind = "중학생";
			break;
		case ELEMENTARY :
			ckind = "초등학생";
			break;
		default:
		}
		return ckind;
	}
	
}