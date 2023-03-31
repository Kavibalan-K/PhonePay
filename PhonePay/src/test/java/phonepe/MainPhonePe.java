package phonepe;

import java.util.*;


public class MainPhonePe {
	Scanner sc = new Scanner(System.in);
	Validation  v = new Validation();
	static Bank b1 = new SBI() ;
	static Bank b2 = new HDFC();
	static Bank b3 = new BOB();
	int count=2;
	static int a=0,b=0,c=0;
	static int correctUpin;
	PhonePeSingleTon p =PhonePeSingleTon.getInstance();
	static {
		System.out.println("Welcome to PhonePe.\nIndia's most Trusted Application for Money Transfer.\n===================================================");
	}
	public void buffering(long rate) throws InterruptedException{
		Thread.sleep(rate);
	}
	public void loading() throws InterruptedException {
		for(int i=0;i<=7;i++) {
			System.out.print('.');
			buffering(500);
		}
		System.out.println();
	}
	public void getMobile() {
		try {
			long mobile= sc.nextLong();
			if(v.countOfNumber(mobile)!=10) {
				System.out.println("Mobile Number Should contains 10 Digits");
				getMobile();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Mobile Number Should be in Number Format");
			sc.nextLine();
			getMobile();
		}
		
	}
	public int generateOtp() {
		int random = (int) (Math.random()*10000);
		int otp = random<1000? random+1000: random;
		System.out.println("Otp : "+ otp);
		return otp;
	}
	public void validateOtp(int otp) throws InterruptedException {
		System.out.print("Enter Otp: ");
		try {
			int rEotp = sc.nextInt();
			if(count==0 && otp!=rEotp) {
				System.out.println("Maximum Attempts Reached. Check After 24 Hours.");
				buffering(500);
				System.out.println("Thank You");
				System.exit(0);
			}
			if(otp!=rEotp) {
				System.out.println("Incorrect Otp. "+ count+ " attempts left");
				count--;
				validateOtp(otp);
			}
		}catch(InputMismatchException e) {
			System.out.println("Otp Should be in Number Format");
			sc.nextLine();
			validateOtp(otp);
		}
		
	}
	public void chooseBank() throws InterruptedException{
		System.out.println("----------------------------------------------------------");
		System.out.println("Choose Bank\nPress 1 - SBI\nPress 2 - HDFC\nPress 3 - BOB.\nPress Any Number to Exit.");
		try {
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				if(a==0) {
					setUpin();
					p.setuPin_1(correctUpin);
					System.out.println("UPI Pin Setted");
					a++;
				}
				display(b1);
				break;
			case 2:
				if(b==0) {
					setUpin();
					p.setuPin_2(correctUpin);
					System.out.println("UPI Pin Setted");
					b++;
				}
				display(b2);
				break;
			case 3:
				if(c==0) {
					setUpin();
					p.setuPin_3(correctUpin);
					System.out.println("UPI Pin Setted");
					c++;
				}
				display(b3);
				break;
			default:
				System.out.println("Thanks For Using PhonePe");
				System.exit(0);
		}
		}catch(InputMismatchException e) {
			System.out.println("It Should be in Number Format");
			sc.nextLine();
			chooseBank();
		}
	}
	public void display(Bank b) throws InterruptedException {
		System.out.println("=======================");
		System.out.println("Enter 1 - Check Balance.\nEnter 2 - Transfer Money");
		try {
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				b.balance();
				break;
			case 2:
				b.transfer();
				break;
			default:
				System.out.println("Invalid Selection");
				display(b);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("It Should be in Number Format");
			sc.nextLine();
			display(b);
		}
		
	}
	public void reEnterCheck(int pin) throws InterruptedException {
		
		try {
			System.out.println("Re-Enter Upi Pin");
			int upin = sc.nextInt();
			if(count==0 && upin!=pin) {
				System.out.println("Maximum Attempts reached. Check After 24 Hours.\nThank You");
				System.exit(0);
			}
			if(upin!=pin) {
				System.out.println("Incorrect UPI Pin. "+ count-- + " attempts Left.");
				reEnterCheck(pin);
			}
			else {
				correctUpin = pin;
				count=2;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("UPI Pin Should be in Number Format");
			sc.nextLine();
			reEnterCheck(pin);
		}
		
	}
	public void setUpin() throws InterruptedException{
		
		try {
			System.out.println("Set UPI Pin (6 Digits)");
			int upin = sc.nextInt();
			if(v.countOfNumber(upin)!=6) {
				System.out.println("Upi Pin should contains 6 Digit");
				setUpin();
			}
			else {
				new MainPhonePe().reEnterCheck(upin);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("UPI Pin Should be in Number Format");
			sc.nextLine();
			setUpin();
		}
		
	}
	
	public void execution() throws InterruptedException{
		System.out.println("Enter Your Mobile Number linked with Bank");
		getMobile();
		System.out.print("Checking Mobile Number");
		loading();
		int otp = generateOtp();
		new MainPhonePe().validateOtp(otp);
		System.out.print("Verifying");
		loading();
		System.out.println("Mobile Number verified.");
		System.out.print("Fetching Information");
		loading();
		while(true) {
			chooseBank();
			buffering(1000);
		}
	}
	public static void main(String[] args) throws InterruptedException{
		MainPhonePe m = new MainPhonePe();
		m.execution();
	}
}
