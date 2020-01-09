import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1204_최빈수구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; ++i) {
			int tc = Integer.parseInt(br.readLine());
			int[] score = new int[101];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				++score[Integer.parseInt(st.nextToken())];
			}
			
			int answer = 0;
			
			for (int j = 0; j <= 100; ++j) {
				if(score[j] > score[answer]) answer = j;
				else if(score[j] == score[answer] && j > answer) answer = j;
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}
