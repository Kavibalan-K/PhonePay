package phonepe;

public class Validation {
	public int countOfNumber(long a) {
		int count=0;
		while(a!=0) {
			count++;
			a/=10;
		}
		return count;
	}
	public int countOfNumberA(int a) {
		int count=0;
		while(a!=0) {
			count++;
			a/=10;
		}
		return count;
	}
}
