package stack;

import java.util.*;

public class DupicateBracket_1 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String exp=scn.nextLine();
		
		duplicateBracket(exp);
	}
    
	public static void duplicateBracket(String exp) {
		Stack<Character> st=new Stack<>();
		
		//logic
		
	for(int i=0;i<exp.length();i++) {
		
		char ch=exp.charAt(i);
		
		if(ch!=')') st.push(ch);
		
		else {
			if(st.peek()=='(') {
				System.out.print(true);
				return;
			}
			
			while(st.peek()!='(') st.pop();
			st.pop();
		}
	}
	System.out.print(false);
		
	}
}
