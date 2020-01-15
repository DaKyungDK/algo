package Study;
//��Ž+����ġ��..�� �̿�
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112_��ȣ�ʸ�_�̴ٰ� {
	static int D,W,K;
	static int[][] map = new int[15][25];
	static boolean[] line;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			line = new boolean[D];

			for (int d = 0; d < D; d++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[d][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			int d = D/2;
			combi(d,0);
			
		}//end tc..
	}

	private static boolean check(int d) {
		int cntA=0;
		int cntB=0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < D; j++) {
				if(map[i][j]==0) {
					cntA++;
					cntB=0;
				}else {
					cntB++;
					cntA=0;
				}
			}
			if(cntA<K && cntB<K) {
				return false;
			}
		}
		return true;
	}

	private static boolean combi(int d,int i) {
		if(i==d) {
			//�˻�
			for (int j = 0; j < D; j++) {
				if(line[j]) {
					for (int k = 0; k < W; k++) {
						map[j][k]=1;
						//0�ΰ�쵵 �ؾ��ϴµ� �׷��� 2^d ��ŭ �ؾߵǳ�....�ڵ屸���� ���������� �𸣰ھ� ����...
					}
				}
			}
			check(d);
		}
		if(D-i>D/2-d) {
			line[i] = false;
			combi(d,i+1);
		}
		if(D/2>d) {
			line[i] = true;
			combi(d+1,i+1);
		}
		return false;
	}

}
