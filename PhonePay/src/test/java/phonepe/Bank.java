package phonepe;

import java.util.*;

public abstract class Bank {
	Scanner sc = new Scanner(System.in);
	 Validation v = new Validation();
	 public abstract void balance();
	 public abstract void transfer() throws InterruptedException;
	 public void transferring() throws InterruptedException {
			System.out.print("Transferring");
			for(int i=0;i<=5;i++) {
				System.out.print(".");
				Thread.sleep(500);
			}
			System.out.println();
	}
}
class SBI extends Bank {
	double money = 5000.00;
	int count=3;
	long mobile;
	PhonePeSingleTon p = PhonePeSingleTon.getInstance();
	public void checkPin() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_1()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_1()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("UPI Pin Should be in Number Format.");
			sc.nextLine();
			checkPin();
		}
	}
	public void checkPin1() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_1()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_1()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin1();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("UPI Pin Should be in Number Format.");
			sc.nextLine();
			checkPin1();
		}
	}
	public void currentBalance() {
		System.out.println("Current Balance : "+ money);
	}
	public void debit() throws InterruptedException {
		
		try {
			System.out.println("Enter Amount to Transfer from SBI");
			double transfer = sc.nextDouble();
			checkPin1();
			if(transfer>money) {
				System.err.println("Insufficent Balance");
			}
			else {
				transferring();
				System.out.println(transfer + " transfered to "+ mobile + " from SBI" );
				money-=transfer;
				currentBalance();
			}
		}
		
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			debit();
		}
	}
	@Override
	public void balance() {
		checkPin();
		System.out.println("Your Balance : "+ money);
	}
	@Override
	public void transfer() throws InterruptedException {
		
		try {
			System.out.println("Enter Receiver Mobile Number: ");
			long mobile = sc.nextLong();
			this.mobile=mobile;
			if(v.countOfNumber(mobile)!=10) {
				System.out.println("Mobile Number Should contains 10 Digits");
				transfer();
			}
			else {
				debit();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Mobile Number Should be in Number Format.");
			sc.nextLine();
			transfer();
		}
	}
}
class HDFC extends Bank {
	double money = 15000.00;
	int count=3;
	long mobile;
	PhonePeSingleTon p = PhonePeSingleTon.getInstance();
	public void checkPin() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_2()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_2()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			checkPin();
		}
		
	}
	public void checkPin1() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_2()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_2()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin1();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			checkPin1();
		}
		
		
	}
	public void currentBalance() {
		System.out.println("Current Balance : "+ money);
	}
	public void debit() throws InterruptedException{
		
		try {
			System.out.println("Enter Amount to Transfer from HDFC");
			double transfer = sc.nextDouble();
			checkPin1();
			if(transfer>money) {
				System.err.println("Insufficent Balance");
			}
			else {
				transferring();
				System.out.println(transfer + " transfered to "+ mobile + " from HDFC" );
				money-=transfer;
				currentBalance();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			debit();
		}
		
	}
	@Override
	public void balance() {
		checkPin();
		System.out.println("Your Balance : "+ money);
	}
	@Override
	public void transfer() throws InterruptedException {
		try {
			System.out.println("Enter Receiver Mobile Number: ");
			long mobile = sc.nextLong();
			this.mobile=mobile;
			if(v.countOfNumber(mobile)!=10) {
				System.out.println("Mobile Number Should contains 10 Digits");
				transfer();
			}
			else {
				debit();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Mobile Number Should be in Number Format.");
			sc.nextLine();
			transfer();
		}
		
	}
}
class BOB extends Bank {
	double money = 8000.00;
	int count=3;
	long mobile;
	PhonePeSingleTon p = PhonePeSingleTon.getInstance();
	public void checkPin() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_3()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_3()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			checkPin();
		}
		
		
	}
	public void checkPin1() {
		
		try {
			System.out.println("Enter UPI Pin");
			int upi = sc.nextInt();
			if(count==1 && p.getuPin_3()!=upi) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				System.out.println("Thank You");
				System.exit(0);
			}
			if(p.getuPin_3()!=upi) {
				System.out.println("Incorrect Upin. "+ --count + " attempts Left");
				checkPin1();
			}
			else {
				count=3;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			checkPin1();
		}
		
		
	}
	public void currentBalance() {
		System.out.println("Current Balance : "+ money);
	}
	public void debit() throws InterruptedException {
		
		try {
			System.out.println("Enter Amount to Transfer from BOB");
			double transfer = sc.nextDouble();
			checkPin1();
			if(transfer>money) {
				System.err.println("Insufficent Balance");
			}
			else {
				transferring();
				System.out.println(transfer + " transfered to "+ mobile + " from BOB" );
				money-=transfer;
				currentBalance();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Amount Should be in Number Format.");
			sc.nextLine();
			debit();
		}
		
	}
	@Override
	public void balance() {
		checkPin();
		System.out.println("Your Balance : "+ money);
	}
	@Override
	public void transfer() throws InterruptedException {
		
		try {
			System.out.println("Enter Receiver Mobile Number: ");
			long mobile = sc.nextLong();
			this.mobile=mobile;
			if(v.countOfNumber(mobile)!=10) {
				System.out.println("Mobile Number Should contains 10 Digits");
				transfer();
			}
			else {
				debit();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Mobile Number Should be in Number Format.");
			sc.nextLine();
			transfer();
		}
	}
}