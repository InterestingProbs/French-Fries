import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class AmicableChains {
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
		amicableChains(input);
	}
	private static void amicableChains(int value){
		int count = 0;
		int initialValue = value;
		Set<Integer> set = new HashSet<Integer>();
		while(count != initialValue){
			count = 0;
			for (int i = 1; i <= value / 2; i++) {
	            if (value % i == 0) {
	            	count = count + i;
	            }
	        }
			value = count;
			if(count != initialValue)
				set.add(count);
		}
		Iterator it = set.iterator();
		int min = Integer.MAX_VALUE;
		while(it.hasNext()){
			int num = (Integer)it.next();
			min = min>num? num: min;
			System.out.println(num);

		}
		//System.out.println(min);

	}
}