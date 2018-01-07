package game;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MoveButton extends JFrame{
	
	public static void moveUp(Gui gui) {
		MyButton[][] jb = gui.getJb();
//		System.err.println("向上移动");
		int[][] numBe = new int[4][4];
		int[][] numAf = new int[4][4];
		for (int i = 0; i < 4; i++) {//将jb里的数字取到数组，使用数组进行操作
			for (int j = 0; j < 4; j++) {
				numBe[i][j] = jb[i][j].getNum();
				numAf[i][j] = jb[i][j].getNum();

			}
		}

		//println(numBe);


		//第一次移动，将所有数字往前移
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 0;
			for (int j = 0; j < 4; j++) {
				if(numAf[j][i] != 0){
					temp[k++] = numAf[j][i];
				}
			}
			for (int j = 0; j < 4; j++) {
					numAf[j][i] = temp[j];
			}
		}
		//println(numAf);

		//相同的数字结合
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if(numAf[j][i] == numAf[j + 1][i]) {
					numAf[j][i] *= 2;
					gui.getScore_jl().setText((Integer.parseInt(gui.getScore_jl().getText()) + numAf[j + 1][i] + ""));
					numAf[j + 1][i] = 0;
				}
			}
		}
		
		//第二次去0
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 0;
			for (int j = 0; j < 4; j++) {
				if(numAf[j][i] != 0){
					temp[k++] = numAf[j][i];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[j][i] = temp[j];
			}
		}

		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				jb[i][j].setNum(numAf[i][j]);
			}
		}
		if(!compare(numBe,numAf)) {
			addNum(gui);
		}

	}
	
	public static void moveRight(Gui gui) {
		MyButton[][] jb = gui.getJb();
//		System.err.println("向上移动");
		int[][] numBe = new int[4][4];
		int[][] numAf = new int[4][4];
		for (int i = 0; i < 4; i++) {//将jb里的数字取到数组，使用数组进行操作
			for (int j = 0; j < 4; j++) {
				numBe[i][j] = jb[i][j].getNum();
				numAf[i][j] = jb[i][j].getNum();

			}
		}

		//println(numBe);


		//第一次移动，将所有数字往右移
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 3;
			for (int j = 3; j >= 0; j--) {
				if(numAf[i][j] != 0){
					temp[k--] = numAf[i][j];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[i][j] = temp[j];
			}
		}
		//println(numAf);

		//相同的数字结合
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if(numAf[i][j] == numAf[i][j + 1]) {
					numAf[i][j] *= 2;
					gui.getScore_jl().setText((Integer.parseInt(gui.getScore_jl().getText()) + numAf[i][j + 1] + ""));
					numAf[i][j + 1] = 0;
				}
			}
		}
		//第二次去0
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 3;
			for (int j = 3; j >= 0; j--) {
				if(numAf[i][j] != 0){
					temp[k--] = numAf[i][j];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[i][j] = temp[j];
			}
		}

		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				jb[i][j].setNum(numAf[i][j]);
			}
		}
		if(!compare(numBe,numAf)) {
			addNum(gui);
		}

	}
	
	public static void moveLeft(Gui gui) {
		MyButton[][] jb = gui.getJb();
//		System.err.println("向左移动");
		int[][] numBe = new int[4][4];
		int[][] numAf = new int[4][4];
		for (int i = 0; i < 4; i++) {//将jb里的数字取到数组，使用数组进行操作
			for (int j = 0; j < 4; j++) {
				numBe[i][j] = jb[i][j].getNum();
				numAf[i][j] = jb[i][j].getNum();

			}
		}

		//println(numBe);


		//第一次移动，将所有数字往前移
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 0;
			for (int j = 0; j < 4; j++) {
				if(numAf[i][j] != 0){
					temp[k++] = numAf[i][j];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[i][j] = temp[j];
			}
		}
		//println(numAf);

		//相同的数
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if(numAf[i][j] == numAf[i][j + 1]) {
					numAf[i][j] *= 2;
					gui.getScore_jl().setText((Integer.parseInt(gui.getScore_jl().getText()) + numAf[i][j + 1] + ""));
					numAf[i][j + 1] = 0;
				}
			}
		}

		//第二次去0
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 0;
			for (int j = 0; j < 4; j++) {
				if(numAf[i][j] != 0){
					temp[k++] = numAf[i][j];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[i][j] = temp[j];
			}
		}


		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				jb[i][j].setNum(numAf[i][j]);
			}
		}
		if(!compare(numBe,numAf)) {
			addNum(gui);
		}
	}
	
	public static void moveDown(Gui gui) {
		MyButton[][] jb = gui.getJb();
//		System.err.println("向上移动");
		int[][] numBe = new int[4][4];
		int[][] numAf = new int[4][4];
		for (int i = 0; i < 4; i++) {//将jb里的数字取到数组，使用数组进行操作
			for (int j = 0; j < 4; j++) {
				numBe[i][j] = jb[i][j].getNum();
				numAf[i][j] = jb[i][j].getNum();

			}
		}

		//println(numBe);


		//第一次移动，将所有数字往下移
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 3;
			for (int j = 3; j >= 0; j--) {
				if(numAf[j][i] != 0){
					temp[k--] = numAf[j][i];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[j][i] = temp[j];
			}
		}
		//println(numAf);

		//相同的数字结合
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if(numAf[j][i] == numAf[j + 1][i]) {
					numAf[j][i] *= 2;
					gui.getScore_jl().setText((Integer.parseInt(gui.getScore_jl().getText()) + numAf[j + 1][i]) + "");
					numAf[j + 1][i] = 0;
				}
			}
		}
		//第二次去0
		for (int i = 0; i < 4; i++) {
			int[] temp = {0,0,0,0};
			int k = 3;
			for (int j = 3; j >= 0; j--) {
				if(numAf[j][i] != 0){
					temp[k--] = numAf[j][i];
				}
			}
			for (int j = 0; j < 4; j++) {
				numAf[j][i] = temp[j];
			}
		}
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				jb[i][j].setNum(numAf[i][j]);
			}
		}

		if(!compare(numBe,numAf)) {
			addNum(gui);
		}
	}

	public static boolean compare(int[][] arr1,int[][] arr2) {
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				if(arr1[i][j] != arr2[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void addNum(Gui gui) {
		MyButton[][] jb = gui.getJb();
		int[][] num = new int[4][4];

		for (int i = 0; i < 4; i++) {//将jb里的数字取到数组，使用数组进行操作
			for (int j = 0; j < 4; j++) {
				num[i][j] = jb[i][j].getNum();
			}
		}
		int ranNum;
		int ranbut;
		int x;
		int y;
		ranNum = (int)(Math.random() * 2) + 1;
		while(true) {
			ranbut = (int)(Math.random() * 16);
			x = ranbut / 4;
			y = ranbut % 4;
			if(num[x][y] == 0) {
				num[x][y] = ranNum * 2;
				break;
			}
		}
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				jb[i][j].setNum(num[i][j]);
			}
		}

	}

	public static void println(int[][] arr) {
		for(int	i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] num = {{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	}
}
