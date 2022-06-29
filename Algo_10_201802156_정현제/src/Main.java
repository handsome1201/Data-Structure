import java.io.*;
import java.util.*;


public class Main {
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited = new boolean[100];	
	public static int[] basket = new int[100];
	public static int t=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		int total = Integer.parseInt(br.readLine());
		for(int l=0;l<total;l++) {
			int N = Integer.parseInt(br.readLine()); //가능범의 수
			int M = Integer.parseInt(br.readLine()); //입력 횟수
			visited = new boolean[N];
			graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < 9; i++) {
				graph.add(new ArrayList<Integer>());
			}
			for (int i=0; i<M; i++) {
				String[] q =br.readLine().split(" ");
				int first =Integer.parseInt(q[0]);
				int second =Integer.parseInt(q[1]);
				graph.get(first).add(second);
			}
			dfs(0);
			System.out.println();
			visited = new boolean[N];
			basket=new int[N];
			t=0;
			dfs1(0);
			for(int i=basket.length-1;i>=0;i--) {
				System.out.print(basket[i]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void dfs(int x) {

		if(visited[x]) {
			return;
		}
		// 현재 노드를 방문 처리
		visited[x] = true;
		System.out.print(x + " ");
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited[y]) { 
				dfs(y);
			}
		}
	}
	public static void dfs1(int x) {
		// 현재 노드를 방문 처리
		visited[x] = true;
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited[y]) {
				dfs1(y);
				basket[t]=y;
				t++;
			}
		}
	}
}





