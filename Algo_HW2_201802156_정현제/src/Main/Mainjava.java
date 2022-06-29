package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mainjava {

	public static int[] a, tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for (int j = 0; j < total; j++) {
			int re = Integer.parseInt(br.readLine());
			a = new int[re + 1];
			tmp = new int[re + 1];

			for (int i = 0; i < re; i++) {
				String Input = br.readLine();
				String[] Split = Input.split(" ");
				a[i] = Integer.valueOf(Split[i]);
			}
			mergeSort(a,0, re - 1);
			for (int i = 0; i < re; i++) {
				if(tmp[i]!=0) {
					System.out.println(tmp[i]);
				}
			}
			System.out.println();
		}
	}
	public static void mergeSort(int a[],int start, int end) {
		if (start >= end)
			return;
		
		int maximal=0;
		int x=end;
		int mid = (start + end) / 2;
		
		mergeSort(a,start, mid);
		
		while(x>=0) {
			if(a[x]>maximal) {
				maximal=a[x];
				x++;
			}
			else {
				tmp[x]=x;
				x++;
			}
		}
		
		mergeSort(a,mid + 1, end);
		
		
		while(x>=mid) {
			if(a[x]>maximal) {
				maximal=a[x];
				x++;
			}
			else {
				tmp[x]=x;
				x++;
			}
		}
	}
}