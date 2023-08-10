package DSAProjects;

public class QueenKillCombination {

	public static void main(String[] args) {
		queen_kill(0,0,3,3,2,"",new boolean[3][3]);
	}
	public static void queen_kill(int r,int c,int max_r,int max_c,int select,String fill,boolean[][] board) {
		if (select==0) {
			System.out.println(fill);
			return;
		} 
		if (c==max_c) {
			r++;
			c=0;
		}
		if (r==max_r) {
			return; 
		}
		//board[r][c]=true;
		if (isSafe(board,r,c)) {
			board[r][c]=true;
		queen_kill(r,c+1,max_r,max_c,select-1,fill+"q{"+r+","+c+"}  ",board);
		    board[r][c]=false; 
		}
		//board[r][c]=false;
		queen_kill(r,c+1,max_r,max_c,select,fill,board);   	
	}
	public static boolean isSafe(boolean[][] board,int r,int c) {
		for (int r1=r-1;r1>=0;r1--) {
			if (board[r1][c]) {
				return false;
			}
		}
		for (int c1=c-1;c1>=0;c1--) {
			if (board[r][c1]) {
				return false;
			}
		}
		int r2=r-1;
		int c2=c-1;
		while (r2>=0 && c2>=0) {
			if (board[r2][c2]) {
				return false;
			}
			r2--;
			c2--;
		}
		int r3=r-1;
		int c3=c+1;
		while (r3>=0 && c3<board[0].length) {
			if (board[r3][c3]) {
				return false;
			}
			r3--;
			c3++;
		}
		return true;
	}

}
