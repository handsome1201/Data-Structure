import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int N,M;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for(int l=0;l<total;l++) {
			int N = Integer.parseInt(br.readLine()); //가능범의 수
			int M = Integer.parseInt(br.readLine()); //입력 횟수

			parent=new int[N+1];
			for(int i=0;i<N;i++) {
				parent[i]=i;
			}

			for (int i=0; i<M; i++) {
				String[] q =br.readLine().split(" ");
				int first =Integer.parseInt(q[0]);
				int second =Integer.parseInt(q[1]);

				int firstparent=find(first);
				int secondparent=find(second);

				//부모가 같지 않을떄 union
				if(firstparent!=secondparent) {
					parent[secondparent]=firstparent;
				}
			}
			int arr[] = new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=find(i);
			}

			boolean[] c = new boolean[10]; 
			for(int j=0;j<N;j++) {
				if(!c[j]) {
					
					String out="";
					c[j]=true;
					int x=arr[j];
					for(int q=0;q<N;q++) {
						if(arr[q]==x) {
							c[q]=true;
							out+=q;
							out+=",";
						}
					}
					out=out.substring(0,out.length()-1);
					System.out.println(out);
				}
			}
			System.out.println();
		}
	}
	private static int find(int x) {
		if(x == parent[x])
			return x;
		else 
			return parent[x] = find(parent[x]);
	}
}

