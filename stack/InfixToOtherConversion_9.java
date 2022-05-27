package stack;

import java.util.*;

public class InfixToOtherConversion_9 {
   
	// precedence function
	public static int precedence(char ch) {
		
		if(ch == '+' || ch== '-') return 1;
		
		else if(ch == '*' || ch=='/') return 2;
		
		else return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		String infixExp= scn.nextLine();
		
		infixConversion(infixExp);
		
	}// end of main function
	
	public static void infixConversion(String exp) {
		
		Stack<String> preSt= new Stack<>();
		
		Stack<String> postSt= new Stack<>();
		
		Stack<Character> opSt= new Stack<>();
		
		//traverse through the infix expresion
		
		for(int i=0;i<exp.length();i++) {
			
			//take out character
			char ch=exp.charAt(i);
			
			//decide whether it is operand or oprator
			if(ch>='a' && ch<='z') {
				
				//push into both of stack
				preSt.push(ch+"");
				postSt.push(ch+"");
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				
				//find the precedance and top of stack
				
				while(opSt.size()>0 && precedence(opSt.peek())
						>=precedence(ch)) {
					
					//first evaluate and then push
					char op=opSt.pop();
					String preOp2=preSt.pop();
					String preOp1=preSt.pop();
					
					String postOp2=postSt.pop();
					String postOp1=postSt.pop();
					
					//push result to both the stacks
					postSt.push(postOp1+postOp2+op);
					preSt.push(op+preOp1+preOp2);
					
				}//while loop end
					
				//push the character
				opSt.push(ch);	
			}
			
			else if(ch=='(') opSt.push(ch);
			
			else if(ch==')') {
				
				while(opSt.peek()!='(') {
					char op=opSt.pop();
					String preOp2=preSt.pop();
					String preOp1=preSt.pop();
					
					String postOp2=postSt.pop();
					String postOp1=postSt.pop();
					
					//push result to both the stacks
					postSt.push(postOp1+postOp2+op);
					preSt.push(op+preOp1+preOp2);
					
				}//end of while-loop
				
				opSt.pop();
			}// )
			
			else
			{
				// do nothing
			}
			
			
		}//end of for-loop
		
		while(opSt.size()!=0) {
			
			char op=opSt.pop();
			String preOp2=preSt.pop();
			String preOp1=preSt.pop();
			
			String postOp2=postSt.pop();
			String postOp1=postSt.pop();
			
			//push result to both the stacks
			postSt.push(postOp1+postOp2+op);
			preSt.push(op+preOp1+preOp2);
			
		}
		
		//print output
		
		System.out.println("prefix is: "+preSt.peek());
		System.out.println("postfix is: "+postSt.peek());
		
		
	}//end of conversion method

}// end of class
