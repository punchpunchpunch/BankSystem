package manuProto;

import java.util.Scanner;

public class Client {

	protected ClientKind kind = ClientKind.Twenties;
	protected String name;
	protected int id;
	protected int account;
	protected int money = 0;
	
	public Client() {
	}
	
	public Client(String name, int id, int account){
		this.name = name;
		this.id = id;
		this.account = account;
		this.money = money;
	}
	
	public Client(String name, int id, int account, int money){
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
		this.money = this.money - m;
	}
	
	public void inMoney(int m) {
		this.money = this.money + m;
	}
	
	public void printInfo() {
		System.out.println("name : "+name+", id: "+id+", account : "+account+", money : "+money);
	}//this.name으로 써도 상관X
	
	public void getUserInput(Scanner sc) {
		System.out.print("등록할 고객의 아이디를 적어주세요 : ");
		int id = sc.nextInt();
		this.setId(id);
		
		System.out.print("등록할 고객의 이름을 적어주세요 : ");
		String name = sc.next();
		this.setName(name);
		
		System.out.print("등록할 고객의 계좌를 적어주세요 : ");
		int account = sc.nextInt();
		this.setAccount(account);
		
		System.out.print("정보 등록이 완료되었습니다.\n");
	}
}