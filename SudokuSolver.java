package DSAProjects;

import java.util.Scanner;

public class SudokuSolver {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int N=scn.nextInt();
		int[][] arr=new int[N][N];
		for (int r=0;r<arr.length;r++) {
			for (int c=0;c<arr[0].length;c++) {
				arr[r][c]=scn.nextInt();
			}
		}
		System.out.println("=========================");
		sudoku(arr,0,0);
	}
	public static void sudoku(int[][] arr,int r,int c) {
		if (c==arr[0].length) {
			r++;
			c=0;
		}
		if (r==arr.length) {
			print(arr);
			return;
		}
		if (arr[r][c]!=0) {
			sudoku(arr,r,c+1);
			return;
		}
		else {
			for (int i=1;i<=9;i++) {
				if (safe(arr,r,c,i)) {
				arr[r][c]=i;
				sudoku(arr,r,c+1);
				}
			}
		//	arr[r][c]=0;
		}
		arr[r][c]=0;
	}
	public static boolean safe(int[][] arr,int r,int c,int i) {
		for (int c1=0;c1<arr[0].length;c1++) {
			if (arr[r][c1]==i) {
				return false;
			}
		}
		for (int r1=0;r1<arr.length;r1++) {
			if (arr[r1][c]==i) {
				return false;
			}
		}
		int boxr=r/3;
		int boxc=c/3;
		for (int rr=boxr*3;rr<=boxr*3+2;rr++) {
			for (int cc=boxc*3;cc<=boxc*3+2;cc++) {
				if (arr[rr][cc]==i) {
					return false;
				}
			}
		}
		return true;
	}
	public static void print(int[][] arr) {
		for (int[] i:arr) {
			for (int e:i) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}

}
