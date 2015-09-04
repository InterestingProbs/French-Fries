
public class Compressor {

	public static void main(String[] args){
		Compressor compressor = new Compressor();
		String verify = "aabbccddaa";
		if(verify.equals(compressor.returnCompressed("aaabbbbccddaa", 2))){
			System.out.print("compressor works accurately");
		}
		else{
			System.out.print("compressor does not work accurately");
		}
	}
	
	/**
	 * Returns a string compressed to at most @numRet number of consecutive same characters in a row
	 * </br>e.g. returnCompressed(aaabbbbccdd,2) gives aabbccdd
	 * @param s - string to be compressed, cant be null or empty
	 * @param numRet, must be positive
	 * @return compressed string
	 */
	private String returnCompressed(String s, int numRet){
		if(s == null || s.length() == 0){
			return "";
		}
		if(s.length() == 1){
			return s;
		}
		if (numRet <= 0){
			return s;
		}
		StringBuilder compressed = new StringBuilder();
		int seqCount = 1;
		char curChar = s.charAt(0);
		compressed.append(curChar);
		for(int charCount = 0; charCount < s.length(); charCount++){
			char newChar = s.charAt(charCount);
			if((curChar == newChar) && seqCount < numRet){
				compressed.append(curChar);
				seqCount++;
			}
			else if(curChar != newChar){
				compressed.append(newChar);
				seqCount = 1;
			}
			curChar = newChar;
		}
		return compressed.toString();
	}
}
