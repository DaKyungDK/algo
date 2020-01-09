import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D2_1288_새로운불면증치료법 {
	static boolean[] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			count = new boolean[10];
			
			int X = 0;
			while(!sawAll()) {
				int num = N*++X;
				while(num > 0) {
					count[num % 10] = true;
					num /= 10;
				}
			}
			
			answer.append("#"+tc+" "+ X*N +"\n");
		}
		System.out.println(answer);
	}

	private static boolean sawAll() {
		int cnt = 0;
		for (int i = 0; i <= 9; ++i) {
			if(count[i]) cnt++;
		}
		return cnt==10 ? true : false;
	}

}
