package BattleShip;

import java.util.Arrays;

public class Player {
	public String name;
	public int[][] myGrid = new int[3][3];
	public int[][] enemyGrid = new int[3][3];
	public int[][] ship;
	
	public Player(String name){
		this.name = name;
	}
	
	public boolean insertShip(int[][] ship){
		this.ship = new int[2][2];
		if((ship[1][0]==ship[0][0] && ship[1][1]==ship[0][1]) || (ship[0][1]+2<=ship[1][1] ||
				ship[0][1]-2>=ship[1][1]) || ship[1][1]+2<=ship[1][1] || ship[0][1]-2>=ship[1][1] ||
				ship[0][0]+2<=ship[1][0] || ship[0][0]-2>=ship[1][0] || ship[1][0]+2<=ship[1][0] ||
				ship[0][0]-2>=ship[1][0]) return false;
		int x=0,y = 0;
		reset();
		try {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					this.ship[i][j] = ship[i][j];
					x = this.ship[i][0];
					y = this.ship[i][1];
				}
				this.myGrid[x][y] = 2;
			}
			return true;
		}catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public void reset(){
		for(int i = 0; i<3; i++)
			for(int j = 0; j<3; j++){
				this.enemyGrid[i][j]=0;
				this.myGrid[i][j]=0;
			}
	}

	@Override
	public String toString() {
		String s = "Mia griglia\t\t\t\t\tGriglia nemica\n";
		for(int i = 2; i>=0; i--) {
			for (int j = 0; j < 3; j++) {
				if (j < 2 && this.myGrid[j][i] != 0) s += " " + this.myGrid[j][i] + " |";
				else if (this.myGrid[j][i] != 0) s += " " + this.myGrid[j][i];
				else if (j < 2) s += "   |";
			}
			s+= "\t\t\t\t\t";
			for (int j = 0; j < 3; j++) {
				if (j < 2 && this.enemyGrid[j][i] != 0) s += " " + this.enemyGrid[j][i] + " |";
				else if (this.enemyGrid[j][i] != 0) s += " " + this.enemyGrid[j][i];
				else if (j < 2) s += "   |";
			}
			s += "\n";
		}
		return s;
	}
}
