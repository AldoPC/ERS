import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){

		Enemy raidriar= new Raidriar();
		Enemy AlexXDevil= new AlexXDevil();
    	Enemy Joker= new Joker();

		Player marea= new Marea();
		Player Obunga= new Obunga();
		Player cocorean= new Cocorean();

		Player[] yourParty= new Player[3];
		yourParty[0]= marea;
		yourParty[1]= Obunga;
		yourParty[2]= cocorean;

		Enemy[] enemyParty= new Enemy[3];
		enemyParty[0]= raidriar;
		enemyParty[1]= AlexXDevil;
		enemyParty[2]= Joker;

		Battle.duel(yourParty, enemyParty);

	}
}
