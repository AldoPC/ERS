import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){

	 	Player marea= new Marea();
		Player marea2= new Marea();
    Player raidriar= new Raidriar();
		Player raidriar2= new Raidriar();
		Player mareaEVIL= new Marea();
    Player raidriarGOOD= new Raidriar();

		Player[] yourParty= new Player[3];
		yourParty[0]= marea;
		yourParty[1]= marea2;
		marea2.setName("Marea2");
		yourParty[2]= raidriarGOOD;
		raidriarGOOD.setName("raidriarGOOD");

		Player[] enemyParty= new Player[3];
		enemyParty[0]= raidriar;
		enemyParty[1]= raidriar2;
		raidriar2.setName("raidriar2");
		enemyParty[2]= mareaEVIL;
		mareaEVIL.setName("mareaEVIL");



		Battle.duel(yourParty, enemyParty);




	}
}
