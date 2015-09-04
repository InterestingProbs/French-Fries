
/**
 * 
 * @author vb
 * Compress aaaaaaa to a7
 * bbbbaaaa to b4a4
 */
public class Compress {
	static String compress(String str){
		if(str == null || str.isEmpty()){
			return "";
		}
		StringBuilder stringToReturn = new StringBuilder();
		char previous = str.charAt(0);
		stringToReturn.append(previous);
		char current;
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			current = str.charAt(i);
			if(previous == current){
				count++; 
				if(i == str.length() -1){
					stringToReturn.append(count);
				}
			}
			else{
				if(count == 1){
					stringToReturn.append(current);
				}
				else{
					stringToReturn.append(count);
					stringToReturn.append(current);
					count = 1;
				}
			}
			previous = current;
		}
		return stringToReturn.toString();
	}
	
	public static void main(String[] args){
		String ret = compress("aa");
		System.out.println(ret);
	}
}
