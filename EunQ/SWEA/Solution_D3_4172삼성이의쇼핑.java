import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4172삼성이의쇼핑 {

	static int money, N, price[], sat[], maxSat;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			money = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			price = new int[N];
			sat = new int[N];
			
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				price[i] = Integer.parseInt(st.nextToken());
				sat[i] = Integer.parseInt(st.nextToken());
			}
			
			maxSat = 0;
			getMaxSat(0, 0, 0);
			answer.append("#"+tc+" "+maxSat+"\n");
		}
		System.out.println(answer);
	}

	private static void getMaxSat(int index, int curSat, int curPrice) {
		if(curPrice > money) return;
		
		if(index==N) {
			maxSat = Math.max(maxSat, curSat);
			return;
		}
		
		getMaxSat(index+1, curSat, curPrice);
		getMaxSat(index+1, curSat+sat[index], curPrice+price[index]);
	}

}
