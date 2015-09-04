import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class PangramSolution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input == null || input.length() < 26){
        	System.out.print("not pangram");
        	return;
        }
        panagram(input);
    }
    
    private static void panagram(String input){
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    	for (char ch = 'A'; ch <= 'Z'; ++ch){ 
    		  map.put(ch, 0);
    	}
    	for(int i = 0; i < input.length(); i++){
    		Character c = Character.toUpperCase(input.charAt(i));
    		if(map.containsKey(c)){
    			map.put(c, map.get(c) + 1);
    		}
    	}
        Iterator it = map.entrySet().iterator();
        int value = 0;
        Set<Integer> values = new HashSet<Integer>();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            value = (Integer)pair.getValue();
            if(value == 0){
            	System.out.println("not pangram");
            	return;
            }
            values.add(value);
            it.remove(); // avoids a ConcurrentModificationException
        }
        if(values.size() == 1){
        	if(value == 1){
                    System.out.println("pangram");        		
        	}
        	if(value > 1){
                    System.out.println("multiple pangram " + value);        		    		
        	}
        }
        else{
            System.out.println("pangram");        		
        }
        
    }
}
