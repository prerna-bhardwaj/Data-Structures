/*
On an 8x8 chessboard, there can be multiple Black Queens and one White King.

Given an array of integer coordinates queens that represents the positions of the Black Queens, and a pair of coordinates king that 
represent the position of the White King, return the coordinates of all the queens (in any order) that can attack the King.

*/
import java.util.*;

class QueensThatAttackTheKing {

	public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>>ans = new ArrayList();
        int dirX[] = {1, 1, 0, -1, -1, -1, 0, 1};
        int dirY[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int board[][] = new int[8][8];
        for(int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = 1;
        }
        for(int i = 0; i < 8; i++) {
            int x = king[0], y = king[1];
            while(x >= 0 && y >= 0 && x < 8 && y < 8) {
                if(board[x][y] == 1) {
                    List<Integer>curr = new ArrayList();
                    curr.add(x);
                    curr.add(y);
                    ans.add(curr);
                    break;
                }
                x += dirX[i];
                y += dirY[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    	/*
			Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
			Output: [[0,1],[1,0],[3,3]]
			Explanation:  
			The queen at [0,1] can attack the king cause they're in the same row. 
			The queen at [1,0] can attack the king cause they're in the same column. 
			The queen at [3,3] can attack the king cause they're in the same diagnal. 
			The queen at [0,4] can't attack the king cause it's blocked by the queen at [0,1]. 
			The queen at [4,0] can't attack the king cause it's blocked by the queen at [1,0]. 
			The queen at [2,4] can't attack the king cause it's not in the same row/column/diagnal as the king.
    	*/
    	int queens[][] = {{0, 1},{1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
    	int king[] = {0, 0};
    	System.out.println(queensAttacktheKing(queens, king));
    }
}