import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception{    
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for (int i = 0; i < total; i++) {

			int c=Integer.parseInt(br.readLine());
			int k=Integer.parseInt(br.readLine());
			int p=Integer.parseInt(br.readLine());

			int[] money=new int[k+1];
			int count=0;
			money[0]=1;
			for(int j=1;j<k+1;j++) {
				money[j]=money[j-1]*c;
			}

			for(int j=k;j>=0;j--) {
				if(p/money[j]!=0) {
					count+=(p/money[j]);
					p=p%money[j];
				}
			}
			System.out.println(count);

		}
	}	
}
