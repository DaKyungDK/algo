import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		for (int t = 0; t < 10; ++t) {
			int tc = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			int dSum1 = 0;
			int dSum2 = 0;
			for (int i = 0; i < 100; ++i) {
				int wSum = 0;
				int hSum = 0;
				for (int j = 0; j < 100; ++j) {
					wSum += arr[i][j];
					hSum += arr[j][i];
				}
				if(wSum > max) max = wSum;
				if(hSum > max) max = hSum;
				dSum1 += arr[i][i];
				dSum2 += arr[i][99-i];
			}
			
			if(dSum1 > max) max = dSum1;
			if(dSum2 > max) max = dSum2;
			
			answer.append("#"+tc+" "+max+"\n");
		}
		System.out.println(answer);
	}

}
