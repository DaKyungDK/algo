import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_4192_수영대회 {

	static int N, map[][], sX, sY, eX, eY;
	static Queue<int[]> queue;
	static int[][] dir = {
			{-1,0}, {0,1}, {1,0}, {0,-1}
	};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			sX = Integer.parseInt(st.nextToken());
			sY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			eX = Integer.parseInt(st.nextToken());
			eY = Integer.parseInt(st.nextToken());
			
			queue = new LinkedList<int[]>();
			queue.offer(new int[] {sX, sY, 0});
			map[sX][sY] = 1;
			answer.append("#"+tc+" "+getTime()+"\n");
		}
		System.out.println(answer);
	}

	private static int getTime() {
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int x = info[0];
			int y = info[1];
			int time = info[2];
			
			if(x==eX && y==eY) return time;
			
			int nx, ny;
			for (int d = 0; d < 4; ++d) {
				nx = x + dir[d][0];
				ny = y + dir[d][1];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N
						|| map[nx][ny]==1) continue;
				
				queue.offer(new int[] {nx, ny, time+1});
				map[nx][ny] = 1;
			}
		}
		return -1;
	}

}
