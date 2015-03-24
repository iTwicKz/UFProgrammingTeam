import java.util.Scanner;
public class integerLists {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		for(int cases = 0; cases < testCases; cases++){
			
			String formula = input.next();
			int listLength = input.nextInt();
			String listString = input.next();
			String list = "";
			int q = 1;
			
			for(int i = 0; i < listLength; i++){
				list += listString.charAt(q);
				q += 2;
			}
			
			//System.out.println(list);
			
			for(int i = 0; i < formula.length(); i++){
				
			    if(list.length() == 0){
			    	System.out.println("error");
			    }
				
				else if((formula.charAt(i)) == 'R'){
					list = reversed(list);
					//System.out.println("R");
				}
				
				else if((formula.charAt(i)) == 'D'){
					
					list = list.substring(1);
					//System.out.println("D");
				}
			    //System.out.println(list);
			}
			
			String output = "[";
			for(int i = 0; i < list.length(); i++){
				output += list.charAt(i) + ",";
			}
			output = output.substring(0, output.length() - 1);
			if(output.length() > 1)
				System.out.println(output + "]");
		}
	}
	
	static String reversed(String list){
		String reverse = "";
		
		for(int i = 0; i < list.length(); i++){
			reverse += list.charAt(list.length() - i - 1);
			
		}
		return reverse;
	}
}
