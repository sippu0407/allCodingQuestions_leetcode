package stack;

import java.util.*;

public class SlidingWindow_7 {
    public static void sw(int[] a,int k) {
    	
    	//deque create karo
    	Deque<Integer> dq=new ArrayDeque<>();
    	
    	//fist window k liye 
    	for(int i=0;i<k;i++) {
    		
    		while(dq.size()>0 && a[dq.getLast()]<a[i])
    			dq.removeLast();
    		
    		dq.addLast(i);
    	}
    	System.out.print(a[dq.peek()]+" ");
    	
    	//ab k se leke last element tak
    	for(int i=k;i<a.length;i++) {
    		
    		while(dq.size()>0 && a[dq.getLast()]<a[i])
    			dq.removeLast();
    		
    		dq.addLast(i);
    		
    		if(dq.peek()<=i-k) dq.removeFirst();
    		
    		System.out.print(a[dq.peek()]+" ");
    	}
    	
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
		int k=scn.nextInt();
		
		//output
		sw(a,k);
	}

}
