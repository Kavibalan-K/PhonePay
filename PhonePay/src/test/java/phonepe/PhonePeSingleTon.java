package phonepe;

public class PhonePeSingleTon {
	private int uPin_1;
	private int uPin_2;
	private int uPin_3;
	public static PhonePeSingleTon p = null;
	private PhonePeSingleTon() {
		
	}
	public static PhonePeSingleTon getInstance() {
		if(p==null) {
			p=new PhonePeSingleTon();
		}
		return p;
	}
	public int getuPin_1() {
		return uPin_1;
	}
	public void setuPin_1(int uPin_1) {
		this.uPin_1 = uPin_1;
	}
	public int getuPin_2() {
		return uPin_2;
	}
	public void setuPin_2(int uPin_2) {
		this.uPin_2 = uPin_2;
	}
	public int getuPin_3() {
		return uPin_3;
	}
	public void setuPin_3(int uPin_3) {
		this.uPin_3 = uPin_3;
	}
}
