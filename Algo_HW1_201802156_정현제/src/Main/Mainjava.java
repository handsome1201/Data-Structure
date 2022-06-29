package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mainjava {

	public static int[] rannumber,tmp;
	public static int count;
	
	public static void main(String[] args) throws IOException {
		for(int j=0; j<args.length; j++) {
			BufferedReader br = new BufferedReader(new FileReader(args[j]));

			while(true) {
				String line =br.readLine();
				
				if(line ==null) {
					break;
				}
				
				String arr[]=line.split(",");
				int n=arr.length;
				
				rannumber=new int[n+1];
				tmp = new int[n+1];
				
				for(int i=0;i<n;i++) {
					rannumber[i]=Integer.valueOf(arr[i]);
				}
				count=0;
				mergeSort(0, n-1); 
				
				System.out.println(count);
				
			}
			br.close();
		}
	}
	
	public static void mergeSort(int start, int end) {
		if (start>=end) return;
		int mid = (start+end) / 2; 
		mergeSort(start, mid); 
		mergeSort(mid+1, end);
		merge(start, mid, end);
	}

	public static void merge(int start, int mid,  int end) {
		
		int x = start; 
		int y = mid + 1;    
		int k = start;    

		while(x <= mid || y <= end) {    
			if (y > end || (x <= mid && rannumber[x] < rannumber[y])) {
				

				tmp[k] = rannumber[x++];
				
			}
			else {
				count+=(mid-x+1);
			
				tmp[k]=rannumber[y++];
				
			}
			k++;
		}
		
		for(int i=start; i<=end; i++) {
			rannumber[i] = tmp[i];
		}
	}
}