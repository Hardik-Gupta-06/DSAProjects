package DSAProjects;

public class EnglishRuler {

	public static void main(String[] args) {
		engRuler(4,3);
	}
	public static void engRuler(int majorTics,int scaleLength) {
		for (int i=1;i<=majorTics;i++) {
			System.out.print("- ");
		}
		System.out.println(0);
		for (int i=1;i<=scaleLength;i++) {
			patt(majorTics-1);
			for (int j=1;j<=majorTics;j++) {
				System.out.print("- ");
			}
			System.out.println(i);
		}
	}
	public static void patt(int n) {
		if (n==0) {
			return; 
		}
		patt(n-1);
		for (int i=1;i<=n;i++) {
			System.out.print("- ");
		}
		System.out.println();
		patt(n-1);
	}

}
