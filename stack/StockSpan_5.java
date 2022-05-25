package stack;

import java.util.*;

public class StockSpan_5 {
    
	public static int[] ss(int[] days) {
		int n=days.length;
		Stack<Integer> st=new Stack<>();
		
		//jo pata hai
		st.push(1);
		int ans[]=new int[n];
		ans[0]=1;
		
		//calculation for other days through NGL
		
		for(int i=1;i<n;i++) {
		   
			while(st.size()!=0 && days[st.peek()-1]<days[i])
				st.pop();
			
			
			if(st.size()==0) ans[i]=i+1;
			
			else ans[i]=i+1-st.peek();
			
			//push karo current index
			
			st.push(i+1);
			
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scn=new Scanner(System.in);
		
		//input
		int n=scn.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scn.nextInt();
		}
		
		
		//output
		int[] out=ss(a);
		
		for(int i=0;i<out.length;i++) {
			System.out.print(out[i]);
		}

	}

	}


