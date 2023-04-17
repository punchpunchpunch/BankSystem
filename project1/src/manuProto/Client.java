package manuProto;

public class Client {
	String name;
	int id;
	int account;
	int money =0;
	
	public Client() {
	}
	
	public Client(String name, int id, int account, int money){
		this.name = name;
		this.id = id;
		this.account = account;
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
}