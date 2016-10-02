package com.bj58;


public class JVM {
	
	public static void main(String[] args) throws Exception {
		
		int count=10000;
		
		int sum=0;
		for (int i = 0; i < count; i++) {
			sum+=fn(i);
		}
		Thread.sleep(5000);
		for (int i = 0; i < count; i++) {
			sum+=fn(i);
		}
		System.out.println(sum);
		System.in.read();
		
	}
	private static int fn(int age){
		User user=new User(age);
		int i=user.getAge();
		return i;
		
	}

}
class User{
	private int age;
	
	public User(int age){
		this.age=age;
	}
	public int getAge() {
		return age;
	}
}