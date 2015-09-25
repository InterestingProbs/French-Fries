public class AddBinaryStrings {
	
	
	public static void main(String[] a){
		System.out.println(addBinary("10110000","0000000010110000"));
	}
	// Given as input two binary numbers, represented as Strings containing only the characters '0' and '1', return the result of the addition of the two numbers, represented in the same way as the input.

	// firstNum = "1"
	// secondNum = "11"

	public static String addBinary(String firstNum, String secondNum){
	    StringBuilder addition = new StringBuilder();
	    String shortString = firstNum.length()<secondNum.length() ? firstNum : secondNum;
	    String longString = firstNum.length()>=secondNum.length() ? firstNum : secondNum;
	    int shortStringLength = shortString.length();

	    int carryOver = 0;
	    int longStringValueAtIndex;
	    int shortStringValueAtIndex = 0;
	    for(int i = longString.length() - 1; i >= 0; i--){
	       shortStringLength--;
	       longStringValueAtIndex = Integer.parseInt(String.valueOf(longString.charAt(i)));
	       
	       if(shortStringLength >= 0){
	           shortStringValueAtIndex = Integer.parseInt(String.valueOf(shortString.charAt(shortStringLength)));
		       if(longStringValueAtIndex == 1 && shortStringValueAtIndex == 1){
		           if(carryOver == 1){      
		               addition.append('1');
		            }
		            else{
		                addition.append('0');
		            }
		           carryOver = 1;
		       }
		       else{
		           int result = longStringValueAtIndex + shortStringValueAtIndex;
		           if(result == 1 && carryOver == 1){
		               addition.append('0');
		           }
		           else if(result == 0 && carryOver == 1){
		               addition.append('1');
		               carryOver = 0;
		           }
		           else{
		               addition.append(result);
		           }
		           
		       }
	       }
	       else{
	    	   if(carryOver == 1){
	    		   if(1 == Integer.parseInt(String.valueOf(longString.charAt(i)))){
	    			   addition.append('0');
	    			   carryOver = 1;
	    		   }
	    		   else{
	    			   addition.append('1');
	    			   carryOver = 0;
	    		   }
	    	   }
	    	   addition.append(longString.charAt(i));
	       }

	    }
	    
	    String returnString = addition.reverse().toString();
	    if(carryOver == 1){
	    	return "1"+returnString;
	    }
	    return returnString;
	    
	}
}
