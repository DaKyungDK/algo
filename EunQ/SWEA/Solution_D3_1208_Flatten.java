import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		for (int t = 1; t <= 10; ++t) {
			int[] boxes = new int[100];
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 100; ++i) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dump; ++i) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[99]--;
			}
			
			Arrays.sort(boxes);
			answer.append("#" + t + " " + (boxes[99]-boxes[0]) + "\n");
		}
		System.out.println(answer);
	}

}
