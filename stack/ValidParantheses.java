package stack;
import java.util.*;
public class ValidParantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		String exp=scn.nextLine();
		System.out.print(isValid(exp));
	}
	
public static boolean isValid(String s) {
        
        Stack<Character> st=new Stack<>();
        
        // traverse karo string me
        for(int i=0;i<s.length();i++){
            
            //get corresponding char
            char ch=s.charAt(i);
            
            // agar opening bracket hai to push kar do
            if(ch=='(' ||ch=='{'||ch=='[')  st.push(ch);
            
            // lekin agar closing bracket hai to pop karna hai cases bhi dhyan dena               //hai
            else if(ch==')'){
                
                //case 1: agar koi opening bracket hi nahi bachi hai to 
                if(st.size()==0){
                    
                    return false;
                }
                
                //case 2: agar galat opening backet hai to --> mismatch
               else if(st.peek()=='{' || st.peek()=='['){
                     return false;
                }
                
                //agar right opening bracket encounter huyi to
                else st.pop();
                
            } 
                
                
                //}
                
             else if(ch=='}'){
                
                //case 1: agar koi opening bracket hi nahi bachi hai to 
                if(st.size()==0){
                     return false;
                }
                
                 //case 2: agar galat opening backet hai to --> mismatch
                else if(st.peek()=='(' || st.peek()=='['){
                    return false;
                }
                
                //agar right opening bracket encounter huyi to
                else st.pop();
                    
             }
            
            
            
               // [
                    
           else if(ch==']'){
                
                //case 1: agar koi opening bracket hi nahi bachi hai to 
                if(st.size()==0){
                    return false;
                }
                
                //case 2: agar galat opening backet hai to --> mismatch
               else if(st.peek()=='{' || st.peek()=='('){
                    return false;
                }
                
                //agar right opening bracket encounter huyi to
                else st.pop();
            
                    
            }
                  
            
        }// for loop end
        
          //case 3: agar opening bracket abhi bhi hai stack me to 
            if(st.size()!=0){
                 return false;
            }
            
            else{
                return true;
            }
        
    }
}


