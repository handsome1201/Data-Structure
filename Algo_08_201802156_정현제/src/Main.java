import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static int[] basket; 
	public static int[] tmp;


	public static void main(String[] args) throws Exception{    
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for (int i = 0; i < total; i++) {
			int number=Integer.parseInt(br.readLine());
			String[] changebasket=new String[number];
			changebasket= br.readLine().split(",");

			basket=new int[number];
			tmp = new int[basket.length];
			int[] basketresult=new int[number];
			int result=0;
			for(int j=0;j<number;j++) {
				basket[j]=Integer.parseInt(changebasket[j]);
			}

			mergeSort(0, basket.length-1);
			
			if(number==2) {
				result=basket[0];
			}
			else if(number==1) {
				result=0;
			}
			else {
				for(int j=0;j<number-1;j++) {
					basketresult[j]+=basket[j];
				}
				for(int j=1;j<number-1;j++) {
					basketresult[j]=basket[j]+basketresult[j-1];
				}
				for(int j=0;j<number-1;j++) {
					result+=basketresult[j];
				}
			}
			System.out.println(result);
			for(int j=0;j<number-1;j++) {
				System.out.print(basket[j]+",");
			}
			System.out.print(basket[number-1]);
			System.out.println();
			
		}

	}

	public static void mergeSort(int start, int end) { 
		if (start<end) { 
			int mid = (start+end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			int p = start;
			int q = mid + 1; 
			int idx = p; 
			while (p<=mid || q<=end) { 
				if (q>end || (p<=mid && basket[p]<basket[q])) { 
					tmp[idx++] = basket[p++]; 
				}
				else { 
					tmp[idx++] = basket[q++]; 
				} 
			} 
			for (int i=start;i<=end;i++) { 
				basket[i]=tmp[i]; 
			} 
		} 
	}
}
