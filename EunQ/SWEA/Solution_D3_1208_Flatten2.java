import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten2 {

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
			
			int min = 0;
			int max = 0;
			
			for (int i = 0; i < dump; ++i) {
				for (int j = 0; j < 100; ++j) {
					if(boxes[j] < boxes[min]) min = j;
					if(boxes[j] > boxes[max]) max = j;
				}
				boxes[min]++;
				boxes[max]--;
			}
			
			for (int i = 0; i < 100; ++i) {
				if(boxes[i] < boxes[min]) min = i;
				if(boxes[i] > boxes[max]) max = i;
			}
			
			answer.append("#" + t + " " + (boxes[max]-boxes[min]) + "\n");
		}
		System.out.println(answer);
	}

}
