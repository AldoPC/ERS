import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main(String args[]){

	Marea marea= new Marea();
    Raidriar raidriar= new Raidriar();
    duel(marea, raidriar);

	}

	public static void duel(Player you, Player enemy) {
		System.out.println("Battle Start!!!");
		System.out.println("What will you do?");
		do {
			if (you.isAlive()){
				System.out.println("1) Attack");
				System.out.println("2) Use Ability");
				System.out.println("3) Use Item");
				Scanner sc = new Scanner(System.in);
				int answer = sc.nextInt();
				switch (answer){
						case 1:
							System.out.println("-----------------------------------------------------");
							attack(you, enemy);
							System.out.println("-----------------------------------------------------");
							break;
						case 2:
							System.out.println("-----------------------------------------------------");
							useAbilities(you, enemy);
							System.out.println("-----------------------------------------------------");
							break;
						case 3:
							System.out.println("-----------------------------------------------------");
							useItem(you);
							System.out.println("-----------------------------------------------------");
							break;
				}
			}
			if (enemy.isAlive()){
				attack(enemy, you);
				System.out.println("-----------------------------------------------------");
			}
		} while (you.isAlive() && enemy.isAlive());
		if (you.isAlive()){
			System.out.println("You win!");
		} else if (enemy.isAlive()){
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

	public static void attack(Player attacker, int i, Player defender) {
		int damage = Math.max(0, attacker.abilities[i].getPuntosEspeciales() - defender.getDefense());
		int hp = defender.getHp() - damage;
		System.out.println(attacker.getName()+" used "+attacker.abilities[i].getName());
		System.out.println(attacker.getName() + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}

	public static void useAbilities(Player you, Player enemy){
		System.out.println(you.printAbilities());
		System.out.println("Ability 1");
		System.out.println("Ability 2");
		System.out.println("Ability 3");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
			switch (answer){
				case 1:
					attack(you, 0, enemy);
					break;
				case 2:
					attack(you, 1, enemy);
					break;
				case 3:
					attack(you, 2, enemy);
					break;
			}

	}

	public static void useItem(Player you){
		System.out.println(you.printObjects());
		System.out.println("Object 1");
		System.out.println("Object 2");
		System.out.println("Object 3");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
			switch (answer){
				case 1:
					healthPotion(0, you);
					break;
				case 2:
					
					break;
				case 3:
				
					break;
			}
	}

	public static void healthPotion (int index, Player you){
		int hp = you.getHp() + you.inventory[index].getPoints();
		you.setHp(hp);
		System.out.println("Your health has increased to " + hp);


	}




}
