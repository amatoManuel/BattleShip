package BattleShip;

import java.util.InputMismatchException;

public class BattleShip {
	public Player player1;
	public Player player2;
	public boolean playerTurn;

	public BattleShip(String name1,String name2){
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
	}

	public String startGame(){
		if (Math.random()<0.5) {
			this.playerTurn = true;
			return "Inizia il giocatore 1 ";
		}
		this.playerTurn = false;
		return "Inizia il giocatore 2";
	}
	
	public String game(int x, int y){
		System.out.println(player1.enemyGrid[x][y]+"\n"+player2.enemyGrid[x][y]);
		if (this.playerTurn) {
			if(this.player1.enemyGrid[x][y]!=0){
				checkTurn();
				return "Posizione già inserita! Riprova";
			}
			if (attack(x, y)) {
				if (checkWin())
					return player1.name + " hai vinto";
				return "Colpito";
			}
			return "Mancato";
		}
		if(this.player2.enemyGrid[x][y]!=0){
			checkTurn();
			return "Posizione già inserita! Riprova";
		}
		if (attack2(x, y)) {
			if (checkWin())
				return this.player2.name + " hai vinto";
			return "Colpito";
		}
		return "Mancato";
	}

	public boolean attack(int x, int y){
		for(int i = 0; i<2; i++)
			if(player2.ship[i][0]==x && player2.ship[i][1]== y){
				player1.enemyGrid[x][y] = 2;
				return true;
			}
		player1.enemyGrid[x][y] = 1;
		return false;
	}

	public boolean attack2(int x, int y){
		for(int i = 0; i<2; i++)
			if (player1.ship[i][0] == x && player1.ship[i][1] == y) {
				player2.enemyGrid[x][y] = 2;
				return true;
			}
		player2.enemyGrid[x][y] = 1;
		return false;
	}

	public boolean checkWin() {
		int x;
		int y;
		int counter=0;
		for(int i = 0; i<2; i++) {
			x = this.player1.ship[i][0];
			y = this.player1.ship[i][1];
			if (this.player2.enemyGrid[x][y]==2) {
				counter++;
			}
		}
		if(counter==2)
			return true;
		counter=0;
		for(int i = 0; i<2; i++) {
			x = this.player2.ship[i][0];
			y = this.player2.ship[i][1];
			if (this.player1.enemyGrid[x][y]==2) {
				counter++;
			}
		}
		if(counter==2)
			return true;
		return false;
	}

	public void checkTurn(){
		if(this.playerTurn)
			this.playerTurn = false;
		else
			this.playerTurn = true;
	}

	@Override
	public String toString() {
		if(this.playerTurn)
			return this.player1.toString();
		return this.player2.toString();
	}
}
