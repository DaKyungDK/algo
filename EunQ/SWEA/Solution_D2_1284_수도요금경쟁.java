import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1284_수도요금경쟁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			// P: A사 리터당 요금
			// Q: B사 기본 요금
			// R: B사 월간 사용량 R리터 이하인 경우 기본 요금
			// S: B사 R리터 초과시 초과량만 리터당 요금
			// W: 월 수도 사용량
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int feeA = P * W;
			int feeB = W<=R ? Q : Q + (W-R) * S;
			answer.append("#"+tc+" "+Math.min(feeA, feeB)+"\n");
		}
		System.out.println(answer);
	}

}
