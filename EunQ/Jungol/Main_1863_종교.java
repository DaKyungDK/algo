import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		}
		
		int answer = 0;
		for (int i = 0; i < N; ++i) {
			if(parent[i] < 0) ++answer;
		}
		System.out.println(answer);
	}
	
	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return;
		
		parent[xRoot] += parent[yRoot];
		parent[yRoot] = xRoot;
	}

	private static int find(int x) {
		if(parent[x]<0) return x;
		return parent[x]=find(parent[x]);
	}

}
