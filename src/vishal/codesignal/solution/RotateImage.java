package vishal.codesignal.solution;

public class RotateImage {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int temp = -1;
		RotateImage image = new RotateImage();
		image.rotateImage(a);
	}

	private void rotateImage(int[][] a) {
		int n = a.length;
		int temp;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				temp = a[i][j];
				a[i][j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = temp;
			}
		}
	}
}
