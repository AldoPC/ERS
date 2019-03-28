import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){

		Enemy raidriar= new Raidriar();
		Enemy raidriar2= new Raidriar();
    	Enemy raidriar3= new Raidriar();

		Player marea= new Marea();
		Player marea2= new Marea();
		Player marea3= new Marea();

		Player[] yourParty= new Player[3];
		yourParty[0]= marea;
		yourParty[1]= marea2;
		marea2.setName("Marea2");
		yourParty[2]= marea3;
		marea3.setName("Marea3");

		Enemy[] enemyParty= new Enemy[3];
		enemyParty[0]= raidriar;
		enemyParty[1]= raidriar2;
		raidriar2.setName("raidriar2");
		enemyParty[2]= raidriar3;
		raidriar3.setName("raidriar3");


		Battle.duel(yourParty, enemyParty);

	}
}
