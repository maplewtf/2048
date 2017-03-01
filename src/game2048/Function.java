package game2048;

import java.util.ArrayList;

public class Function {
	static int[][] data=new int[4][4];
	public void clear() {    //清除数据，不过不用
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				data[i][j] = 0;
			}
		}
	}
	/*
	 * 初始化游戏
	 */
	public void initGame() {  //初始游戏
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				data[i][j] = 0;
			}
		}
		int m = (int)(Math.random() * 16);
		int n = (int)(Math.random() * 16);
		data[m/4][m%4] = 2;
		data[n/4][n%4] = 2;
	}
	/*
	 * 随机生成数字
	 */
	public boolean rand(){
		ArrayList<Integer> rest = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(data[i][j] == 0) {
					rest.add(i*4+j);
				}
			}
		}
		if(rest.size() == 0 && checkLost() == false) return false;
		if(rest.size() == 0 && checkLost() == true) return true;
		int mm = (int)(Math.random()*rest.size());//随机位置
		int index = rest.get(mm);
		int nn = (int)(Math.random() * 8);//随机大小
		data[index/4][index%4] = (nn==1?4:2);
		if(rest.size()==1 && checkLost()==false) {
			return false;
		} 
		return true;
	}
	
	/*
	 * 检查游戏是否结束!
	 */
	public boolean checkLost() { 
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if((data[i][j]==data[i][j+1])||(data[i][j]==data[i+1][j])) {
					return true;
				}
			}
		}
		for(int i = 0; i < 3; i++) {
			if((data[i][3]==data[i+1][3])||(data[3][i]==data[3][i+1])){
				return true;
			}
		}
		return false;
	}
	/*
	 * 移动
	 */
	public boolean moveLeft() {//先把数都推到左面，再计算
		boolean flag = false;//判断能否移动
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(data[i][j] == 0) {
					for(int k = j; k < 4; k++) {
						if(data[i][k] != 0) {
							data[i][j] = data[i][k];
							data[i][k] = 0;
							flag = true;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(data[i][j]!= 0 && data[i][j] == data[i][j+1]) {
					data[i][j] += data[i][j+1];
					flag = true;
					for(int k = j + 1; k < 3; k++) {
						data[i][k] = data[i][k+1];
					}
				}
			}
		}
		return flag;
	}
	
	public boolean moveRight() { //向右移动
		boolean flag = false;//判断能否移动
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j >= 0; j--) {
				if(data[i][j] == 0) {
					for(int k = j; k >= 0; k--) {
						if(data[i][k] != 0) {
							data[i][j] = data[i][k];
							data[i][k] = 0;
							flag = true;
							break;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 3; j > 0; j--) {
				if(data[i][j]!= 0 && data[i][j] == data[i][j-1]) {
					data[i][j] += data[i][j-1];
					flag = true;
					for(int k = j-1; k > 0; k--) {
						data[i][k] = data[i][k - 1];
					}
				}
			}
		}
		return flag;
	}
	
	public boolean moveUp() { //向上移动
		boolean flag = false;
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 4; i++) {
				if(data[i][j] == 0) {
					for(int k = i; k < 4; k++) {
						if(data[k][j] != 0) {
							data[i][j] = data[k][j];
							data[k][j] = 0;
							flag = true;
							break;
						}
					}
				}
			}
		}
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 3; i++) {
				if(data[i][j]!= 0 && data[i][j] == data[i+1][j]){
					data[i][j] += data[i+1][j];
					flag = true;
					for(int k = i+1; k < 3; k++) {
						data[k][j] = data[k+1][j];
					}
				}
			}
		}
		return flag;
	}
	
	public boolean moveDown() {  //向下移动
		boolean flag = false;
		for(int j = 0; j < 4; j++) {
			for(int i = 3; i >= 0; i--) {
				if(data[i][j] == 0) {
					for(int k = i; k >= 0; k--) {
						if(data[k][j] != 0) {
							data[i][j] = data[k][j];
							data[k][j] = 0;
							flag = true;
							break;
						}
					}
				}
			}
		}
		for(int j = 0; j < 4; j++) {
			for(int i = 3; i > 0; i--) {
				if(data[i][j]!= 0 && data[i][j] == data[i-1][j]) {
					data[i][j] += data[i-1][j];
					flag = true;
					for(int k = i-1; k > 0; k--) {
						data[k][j] = data[k-1][j];
					}
				}
			}
		}
		return flag;
	}
	
	/*
	 * 
	 */
	
}
