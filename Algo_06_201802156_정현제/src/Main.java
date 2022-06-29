import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int Num = Integer.parseInt(br.readLine());

		for(int a=0; a<Num; a++) {
			String line = br.readLine();
			int n = line.length();

			line = br.readLine();
			int numbers[] = new int[line.length()];
			for(int i=0; i<line.length(); i++) {
				numbers[i]= line.charAt(i)-'0';
			}

			int cost[][] = new int[n][n];
			for(int i=0; i<n; i++) {
				cost[i][i] = 0;
			}

			for(int l=1; l<n; l++) {
				for(int i=0; i<n; i++) {
					int j = i+l;
					if(j<n) {
						for(int k=i; k<j; k++) {
							if(numbers[k]==1) {
								if(cost[i][j]==0) {
									cost[i][j] = cost[i][k] + cost[k+1][j] + (j-i+1);
								}
								else {
									cost[i][j] = Math.min(cost[i][j], (cost[i][k] + cost[k+1][j] + j-i+1) );
								}
							}
						}
					}

				}

			}
			System.out.println(cost[0][n-1]);
		}
	} 
}