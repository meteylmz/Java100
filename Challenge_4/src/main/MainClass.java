package main;

import Member.basicMember;
import Member.premiumMember;
import Member.proMember;
import Member.proPlusMember;

public class MainClass {

	public static void main(String[] args) {
		basicMember basic = new basicMember();
		proMember pro = new proMember();
		premiumMember premium = new premiumMember();
		proPlusMember proplus = new proPlusMember();
	}

}
