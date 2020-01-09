import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1285_아름이의돌던지기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int min = 100001;
			int count = 0;
			
			while(st.hasMoreTokens()) {
				int num = (int) Math.abs(Integer.parseInt(st.nextToken()));
				if(num == min) count++;
				if(num < min) {
					min = num;
					count = 1;
				}
			}
			
			answer.append("#"+tc+" "+min+" "+count+"\n");
		}
		System.out.println(answer);
	}

}
