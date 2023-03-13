package kr.or.ddrt.basic;

public class ArgTest {
	// 메서드 만들기
	public int sumArr(int[] data) {
		int sum=0;
		for(int i=0; i<data.length;i++) {
			sum+=data[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		ArgTest test = new ArgTest();
		int[] nums = {100,200,300};
		System.out.println(test.sumArr(nums));
	}

}
