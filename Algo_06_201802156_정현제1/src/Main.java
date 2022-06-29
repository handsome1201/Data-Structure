import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception{    
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for (int k = 0; k < total; k++) {
			String[] w = br.readLine().split("");//문자 입력
			String[] n = br.readLine().split("");//숫자 입력

			String[][] collect = new String[w.length][2];
			int count=0;

			for(int i=0; i<w.length; i++) {
				collect[i][0]=w[i];
			}
			for(int i=0; i<n.length; i++) {
				collect[i][1]=n[i];
			}
			int i=0;
			if(collect[i][1]=="1") {
				if(i!=n.length) {
					count=count+(collect[i][0].length()-i);
					i++;
				}
				else {
					System.out.println(count);
				}
			}
			System.out.println(count);
		}
	}
}