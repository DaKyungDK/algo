import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		for(int t=1; t<=10; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[256][N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; ++j) {
				int height = Integer.parseInt(st.nextToken());
				for (int i = 0; i < height; ++i) {
					map[i][j] = 1;
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < 256; ++i) {
				for (int j = 0; j < N; ++j) {
					if(map[i][j] > 0) {
						if(j==0) {
							if(map[i][j+1]==0 && map[i][j+2]==0) ++count;
						} else if(j==1) {
							if(map[i][j-1]==0 && map[i][j+1]==0 && map[i][j+2]==0) ++count;
						} else if(j==N-1) {
							if(map[i][j-1]==0 && map[i][j-2]==0) ++count;
						} else if(j==N-2) {
							if(map[i][j-1]==0 && map[i][j-2]==0 && map[i][j+1]==0) ++count;
						} else {
							if(map[i][j-1]==0 && map[i][j-2]==0 && map[i][j+1]==0 && map[i][j+2]==0) ++count;
						}
					}
				}
			}
			
			answer.append("#"+t+" "+count+"\n");
		}
		System.out.println(answer);
	}

}
