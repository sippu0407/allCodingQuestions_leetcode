package languageFundamentls;

public class PrePostIncrement {

	public static void main(String[] args) {
		

		int i=10;
		if(i++==i)
			System.out.print(i+" is good");
		else 
			System.out.print(i+" is bad");
		
		int j=20;
		if(++j==j)
			System.out.print(j+" is good");
		else 
			System.out.print(j+" is bad");
	}

}
