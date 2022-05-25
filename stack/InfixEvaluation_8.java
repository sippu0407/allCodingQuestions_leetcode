package stack;
import java.util.*;
public class InfixEvaluation_8 {
	public static int solve(int op1,int op2,char ch) {
		if(ch=='+') return op1+op2;
		
		else if(ch=='-') return op1-op2;
		
		else if(ch=='*') return op1*op2;
		
		else return op1/op2;
	
	}
    public static int precedence(char ch) {
    	
    	if(ch=='+' || ch== '-') return 1;
    	
    	else if(ch=='*' || ch =='/') return 2;
    	
    	else return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String exp=scn.nextLine();
		infixEvaluation(exp);
	}
	
	public static void infixEvaluation(String exp) {
		
		//create 2 stack
		Stack<Integer> st1=new Stack<>();
		Stack<Character> st2=new Stack<>();
		
		//traverse through the string
		for(int i=0;i<exp.length();i++) {
			
			//takeout character and check to which stack
			//it should be pushed
			char ch=exp.charAt(i);
			
			if(ch>='0' && ch<='9') st1.push(ch-'0');
			
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				
				//check st2.peek() char and its precedence
				//with respect to ch
				//agar >=ch the pop and solve 
				while(st2.size()>0 && precedence(st2.peek())
						>=precedence(ch)) {
					
					char operat=st2.pop();
					
					int op2=st1.pop();
					
					int op1=st1.pop();
					
					//push the result to stack one
					st1.push(solve(op1,op2,operat));
					
				}
				
				// agar size zero hai ya precedence zyada hai
				//to direct push
				
				st2.push(ch);
			}
			
			else if(ch == '(') st2.push(ch);
			
			else if(ch == ')') {
				while(st2.peek()!='(') {
					
                   char operat=st2.pop();
					
					int op2=st1.pop();
					
					int op1=st1.pop();
					
					//push the result to stack one
					st1.push(solve(op1,op2,operat));
					
				}
				
				//pop the (
				st2.pop();
			}
			
		}// for loop end 
		
		//agar stack 2 ab bhu bhara hai to khali kar do
		while(st2.size()!=0) {

            char operat=st2.pop();
				
				int op2=st1.pop();
				
				int op1=st1.pop();
				
				//push the result to stack one
				st1.push(solve(op1,op2,operat));
		}
		
		//print the result
		
		System.out.print(st1.peek());
		
	}

}
