package stack;

import java.util.*;

public class NextGreaterToRight_3 {
    public static int[] NGR(int[] a) {
    	System.out.println(a.length);
    	int n=a.length;
    	Stack<Integer> st=new Stack<>();
    	int[] ans=new int[n];
    	
    	//last ka hame pata hai
    	//in:1  5  4
    	//op:5 -1 -1
    	
    	
    	ans[n-1]=-1;
    	st.push(a[n-1]);
    	
    	
    	//cases
    	
    	for(int i=n-2;i>=0;i--) {
    		
    		while(st.size()!=0 && st.peek()<=a[i])
    			st.pop();
    		
    		if(st.size()==0) ans[i]=-1;
    		
    		else ans[i]=st.peek();
    		//last me push kar do wo element ko
    		st.push(a[i]);
    		
    	}
    	
    	
    	return ans;
    	
    }
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		//input
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scn.nextInt();
		}
		
		
		//output
		int[] out=NGR(a);
		System.out.println(out.length);
		for(int i=0;i<out.length;i++) {
			System.out.print(out[i]+" ");
		}

	}

}
