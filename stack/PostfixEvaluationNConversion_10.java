package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationNConversion_10 {
	
	public static int solve(int op1,int op2,char ch) {
		if(ch=='+') return op1+op2;
		
		else if(ch=='-') return op1-op2;
		
		else if(ch=='*') return op1*op2;
		
		else return op1/op2;
	
	}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		Scanner scn=new Scanner(System.in);
		String postfixExp= scn.nextLine();
		
		postfixEvalNConv(postfixExp);
	}
	
public static void postfixEvalNConv(String exp) {
		
		Stack<String> preSt= new Stack<>();
		
		Stack<String> infixSt= new Stack<>();
		
		Stack<Integer> evalSt= new Stack<>();
		
		//traverse through the infix expresion
		
		for(int i=0;i<exp.length();i++) {
			
			//take out character
			char ch=exp.charAt(i);
			
           if(ch>='0' && ch<='9') {
				
				//push into both of stack
				preSt.push(ch+"");
				infixSt.push(ch+"");
				evalSt.push(ch-'0');
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				char op=ch;
				String Op2=infixSt.pop();
				String Op1=infixSt.pop();
				
				String preOp2=preSt.pop();
				String preOp1=preSt.pop();
				
				int intOp2=evalSt.pop();
				int intOp1=evalSt.pop();
				
				//push into both of stack
				preSt.push(op+preOp1+preOp2);
				infixSt.push('('+Op1+op+Op2+')');
				evalSt.push(solve(intOp1,intOp2,ch));
			  
		  }	
			else {
				//do nothing
			}
	}
		
		System.out.println("value "+evalSt.peek());
		
		System.out.println("infix conversion "+infixSt.peek());

		System.out.println("prefix conversion "+preSt.peek());


}//end of function

}//end of class
