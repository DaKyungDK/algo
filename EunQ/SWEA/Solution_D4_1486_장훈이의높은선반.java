import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반 {

	static int N, B, ans;
	static int[] tall;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			// N: 점원 수 , B: 선반 높이
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			// 점원들 키
			tall = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				tall[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 200000;
			getAns(0, 0);
			
			answer.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(answer);
	}

	private static void getAns(int index, int sum) {
		if(sum >= B) {
			ans = Math.min(sum-B, ans);
			return;
		}
		
		if(index > N-1) {
			return;
		}
		
		getAns(index+1, sum+tall[index]);
		getAns(index+1, sum);
	}

}
