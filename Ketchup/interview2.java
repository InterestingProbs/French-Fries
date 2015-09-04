
public class interview2 {
	public static void main(String[] args){
		char[] charArray ={ 'a', 'b', 'c', 'd', 'e' }; 

		System.out.println(reverse(charArray));
	}
	public  static String reverse(char[] array) {
	    //char[] array = s.toCharArray();
	    char tmp;
	    for(int i=array.length/2; i >= 0; i--) {
	        tmp = array[i];
	        array[i] = array[array.length-1-i];
	        array[array.length-1-i] = tmp;
	        String[] let = new String[10];
	    }
	    return new String(array);
	}

	
	public static void reverseLetters(char[] letters){
		int i = 0;
		int j = letters.length;
		System.out.println("legnth" + letters.length);
		while(i < j){
			char temp = letters[i];
			letters[j-1] = temp;
			letters[i] = letters[j-1];
			 i++;
			 j--;
		}
		System.out.println(letters);
	}
}
