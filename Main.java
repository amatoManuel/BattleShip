package BattleShip;

import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String name1,name2;
        String empty;
        int[][] ship1 = new int[2][2], ship2 = new int[2][2];
        int x,y;
        System.out.println("Inserisci nome del giocatore 1");
        name1 = input.nextLine();
        System.out.println("Inserisci nome del giocatore 2");
        name2 = input.nextLine();
        BattleShip battleShip = new BattleShip(name1,name2);
        System.out.println(name1+" inserisci nave");
        do {
            for (int i = 0; i < 2; i++) {
                try {
                    System.out.println("Inserisci coordinata " + (i + 1) + " di x");
                    ship1[i][0] = input.nextInt();
                    System.out.println("Inserisci coordinata " + (i + 1) + " di y");
                    ship1[i][1] = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Errore! Hai inserito un carattere sbagliato.\nRiprova");
                    i--;
                    empty = input.nextLine();
                }
                catch (Exception e){
                    System.out.println("Errore! "+e);
                }
            }
            if(battleShip.player1.insertShip(ship1))
                break;
            System.out.println("Errore inserimento nave riprova");
        }while(true);
        System.out.println(name2+" inserisci nave");
        do {
            for (int i = 0; i < 2; i++) {
                try {
                    System.out.println("Inserisci coordinata " + (i + 1) + " di x");
                    ship2[i][0] = input.nextInt();
                    System.out.println("Inserisci coordinata " + (i + 1) + " di y");
                    ship2[i][1] = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Errore! Hai inserito un carattere sbagliato.\nRiprova");
                    i--;
                    empty = input.nextLine();
                }
                catch (Exception e){
                    System.out.println("Errore! "+e);
                }
            }
            if(battleShip.player2.insertShip(ship2))
                break;
            System.out.println("Errore inserimento nave. Riprova");
        }while(true);
        System.out.println(battleShip.startGame()+"\n"+battleShip.player1+"\n"+battleShip.player2);
        while(true){
            try {
                if (battleShip.playerTurn) {
                    System.out.println(name1 + " inserisci coordinate x di dove vuoi attaccare");
                    x = input.nextInt();
                    System.out.println(name1 + " inserisci coordinate y di dove vuoi attaccare");
                    y = input.nextInt();
                    System.out.println(battleShip.game(x, y) + "\n" + battleShip);
                    if (battleShip.checkWin())
                        break;
                }
                else {
                    System.out.println(name2 + " inserisci coordinate x di dove vuoi attaccare");
                    x = input.nextInt();
                    System.out.println(name2 + " inserisci coordinate y di dove vuoi attaccare");
                    y = input.nextInt();
                    System.out.println(battleShip.game(x, y));
                    System.out.println(battleShip);
                    if (battleShip.checkWin())
                        break;
                }
                battleShip.checkTurn();
            }
            catch (InputMismatchException e){
                System.out.println("Errore! Hai inserito un carattere sbagliato.\nRiprova");
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Errore: Indice non definito nella griglia\nRiprova");
            }
        }
    }
}
