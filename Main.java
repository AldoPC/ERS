import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){

		Marea marea= new Marea();
    Raidriar raidriar= new Raidriar();
		System.out.println(marea.printAbilities());
    duel(marea, raidriar);

	}

	public static void duel(Player you, Player enemy) {


		System.out.println("Battle Start!!!");
		do {
			System.out.println("What will you do?");
			System.out.println("1) Attack");
			System.out.println("2) Use Ability"); //Hacer que se pueda usar una habilidad
			System.out.println("3) Inventory");
			Scanner sc = new Scanner(System.in);
			int answer = sc.nextInt();
			switch (answer){
				case 1:
					System.out.println("-----------------------------------------------------");
					attack(you, enemy);
					attack(enemy, you);
					System.out.println("-----------------------------------------------------");
					break;
				case 2:
					System.out.println(you.printAbilities());
					break;
				case 3:
					System.out.println();
				break;
			}
		} while (you.isAlive() && enemy.isAlive());

		if (you.isAlive()) {
			System.out.println("You win!");
		} else if (enemy.isAlive()) {
			System.out.println("You lose!");
		} else {
			System.out.println("Draw!");
		}

	}

	private static void attack(Player attacker, Player defender) {
		int damage = Math.max(0, attacker.getAttack() - defender.getDefense());
		int hp = defender.getHp() - damage;
		System.out.println(attacker.getName() + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}



}
