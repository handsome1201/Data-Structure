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
			a = new int[re];
			tmp = new int[re];

			String[] Input = br.readLine().split(" ");

			for (int i = 0; i < re; i++) {
				a[i] = Integer.valueOf(Input[i]);
			}

			mergeSort(a,0,re - 1);
			int i=0;

			for (i = 0; i < re; i++) {

				if(tmp[i]!=0) {
					break;
				}

			}
			System.out.print(i-1);
			System.out.println();
		}
	}
	public static void mergeSort(int a[] ,int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		mergeSort(a,start, mid);
		int maximal=0;
		int x=start;
		while(x<=mid) {
			if(a[x]>maximal) {
				maximal=a[x];
				x++;
			}
			else {
				tmp[x]=a[x];
				x++;

			}
		}
		mergeSort(a,mid + 1, end);
		while(x<=end) {
			if(a[x]>maximal) {
				maximal=a[x];
				x++;
			}
			else {
				tmp[x]=a[x];
				x++;
			}
		}
	}
}