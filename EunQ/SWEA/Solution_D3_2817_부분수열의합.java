import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합 {

	static int N, K, cnt, nums[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			go(0, 0);
			answer.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(answer);
	}

	private static void go(int index, int sum) {
		if(sum > K) return;
		
		if(sum == K) {
			++cnt;
			return;
		}
		
		if(index==N) return;
		
		go(index+1, sum+nums[index]);
		go(index+1, sum);
	}

}
