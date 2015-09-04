import java.util.Arrays;
import java.util.Scanner;
/**
 * Check if two elements in the array sum up to a specific value
 * @author copied from internet
 *
 */
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        in.nextLine();
        int[] intArray = new int[size];
        for(int i=0;i<size;i++){
        	intArray[i] = in.nextInt();
        }
        Arrays.sort(intArray);
        int[] diffArray = new int[size-1];
        for(int i=0;i<size-1;i++){
        	diffArray[i] = intArray[i+1]-intArray[i];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<size-1;i++){
            if(diffArray[i] < min)
                min = diffArray[i];
        }
        for(int i=0;i<size-1;i++){
            if(diffArray[i] == min)
                System.out.print(intArray[i]+" "+intArray[i+1]+" ");
        }
    }
}
