
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception{
		System.out.println("zz");
		
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int total = Integer.parseInt(br.readLine());
		for (int k = 0; k < total; k++) {
			String st = br.readLine();
			
			char[][] matrix = new char[st.length()][st.length()];
			boolean answer = true;
			for (int i=0; i<st.length(); i++) {
				matrix[i][i] = st.charAt(i);
			}
			
			
			for(int i=1;i<st.length(); i++) {
				
				for(int j= i-1;j>=0;j--) {
					char c1 = solution(matrix[j][j], matrix[i][j+1]);
					char c2 = solution(matrix[i-1][j], matrix[i][i]);
					if(c1 == c2) {
						matrix[i][j] = c1;
					}else {
						matrix[i][j] = 'c';
					}
				}
			}
			
			for(int i=0;i<matrix.length; i++) {
				for(int j=0; j<matrix.length; j++) {
					System.out.print(matrix[i][j]);
				}
				System.out.println();
				
			}
			
			//System.out.println(matrix[st.length()-1][0]);
		}
		
		
		
	}
	
	private static char solution(char a, char b) {
		if(a == 'a' && b == 'b') {
			return 'a';
		}else if (a == 'c' && b == 'c'){
			return 'c';
		}else if (a == 'a' && b == 'c'){
			return 'c';
		}else if (a == 'c' && b == 'b'){
			return 'c';
		}else {
			return 'b';
		}
	}
}
