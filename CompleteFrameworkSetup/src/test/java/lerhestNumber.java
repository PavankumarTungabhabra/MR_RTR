import java.util.Iterator;

import org.testng.annotations.Test;

public class lerhestNumber {

	
	@Test
	public void findTheLargestNumber() {
		int a[]= {20,35,16};
		
		int sizz= a.length;
		int maxNum=0;
//		
//		if (a[0]>a[1]) {
//			
//			maxNum=a[0];
//			
//			
//		}
//		else {
//			maxNum=a[1];
//		}
		
		for (int i = 1; i < a.length-1; i++) {
			
			if (a[i]>a[i+1]) {
				maxNum=a[i];
			}
			else {
				maxNum=a[i+1];
			}
			
		}
		System.out.println(maxNum);
	}
}
