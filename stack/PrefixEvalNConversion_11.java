package stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvalNConversion_11 {

	public static int solve(int op1,int op2,char ch) {
		if(ch=='+') return op1+op2;
		
		else if(ch=='-') return op1-op2;
		
		else if(ch=='*') return op1*op2;
		
		else return op1/op2;
	
	}
    

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		String postfixExp= scn.nextLine();
		
		prefixEvalNConv(postfixExp);


	}
	
public static void prefixEvalNConv(String exp) {
		
		Stack<String> postSt= new Stack<>();
		
		Stack<String> infixSt= new Stack<>();
		
		Stack<Integer> evalSt= new Stack<>();
		
		//traverse through the infix expresion
		
		for(int i=exp.length()-1;i>=0;i--) {
			
			//take out character
			char ch=exp.charAt(i);
			
           if(ch>='0' && ch<='9') {
				
				//push into both of stack
				postSt.push(ch+"");
				infixSt.push(ch+"");
				evalSt.push(ch-'0');
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				char op=ch;
				String Op2=infixSt.pop();
				String Op1=infixSt.pop();
				
				String postOp2=postSt.pop();
				String postOp1=postSt.pop();
				
				int intOp2=evalSt.pop();
				int intOp1=evalSt.pop();
				
				//push into both of stack
				postSt.push(postOp1+postOp2+op);
				infixSt.push('('+Op1+op+Op2+')');
				evalSt.push(solve(intOp1,intOp2,ch));
			  
		  }	
			else {
				//do nothing
			}
	}
		
		System.out.println("value "+evalSt.peek());
		
		System.out.println("infix conversion "+infixSt.peek());

		System.out.println("postfix conversion "+postSt.peek());


}//end of function


}
