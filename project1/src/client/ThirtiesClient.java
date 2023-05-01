package client;

import java.util.Scanner;

import manuProto.Client;

public class ThirtiesClient extends Client {
	public void gerUserInput(Scanner sc) {
		System.out.print("등록할 고객의 아이디를 적어주세요 : ");
		int id = sc.nextInt();
		this.setId(id);
		
		System.out.print("등록할 고객의 이름을 적어주세요 : ");
		String name = sc.next();
		this.setName(name);
		
		System.out.print("등록할 고객의 계좌를 적어주세요 : ");
		int account = sc.nextInt();
		this.setAccount(account);
	}

}
