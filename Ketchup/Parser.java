import java.util.Stack;

/**
 * Tell if a set of parenthesis is correctly balanced
 * @author 
 *
 */
public class Parser {

	
	static boolean checkParenthesesBalance(String str){
		if(str == null){
			return false;
		}
		if(str.isEmpty()){
			return true;
		}
		if(str.length()%2 == 1){
			return false;
		}
		int count1 = 0, count2 = 0;
		for(int i = 0; i < str.length(); i++){
			switch(str.charAt(i)){
			case '{':
				count1++;
				break;
			case '}':
				count1--;
				break;
			case '(':
				count2++;
				break;
			case ')':
				count2--;
				break;
			default:
				continue;
			}
			if(count1 < 0 || count2 < 0){
				return false;
			}
		}
		
		return true;
	}
	public static void main(String args[]){
		String string = "{{}}{}{}()";
		boolean result = checkParenthesesBalance(string);
		System.out.println(result);
	}
}
