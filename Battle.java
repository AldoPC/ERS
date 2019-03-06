import java.util.Scanner;

public class Battle{

  public static void duel(Player you[], Player enemy[]) {
	  int yourSpeed = you[0].getSpeed() + you[1].getSpeed() + you[2].getSpeed();
	  int enemySpeed = enemy[0].getSpeed() + enemy[1].getSpeed() + enemy[2].getSpeed();
	  int index = 0;
	  int fighters = 0;

	  boolean turn = true;

	  if (yourSpeed > enemySpeed) {
		  turn = true;
	  } else {
		  turn = false;
	  }

	  for (int f = 0; f < 3; f++) {
		  if (you[f] != null) {
			  fighters = fighters + 1;
		  }
		  if (enemy[f] != null) {
			  fighters = fighters + 1;
		  }
	  }

	  System.out.println("There are " + fighters + " characters in battle");
	  System.out.println("Battle Start!!!");
	  System.out.println("Choose your character");


	  while (Party.teamIsAlive(you) && Party.teamIsAlive(enemy)) {

		  for (int y = 0; y < 3; y++) {
			  if (you[y].isAlive()) {
          if (turn) {
            System.out.println("1) Attack");
            System.out.println("2) Use Ability");
            System.out.println("3) Use Item");
            Scanner sc = new Scanner(System.in);
            int answer = sc.nextInt();
            switch (answer) {
              case 1:
                System.out.println("-----------------------------------------------------");
                you[y].attack(enemy[y]);
                System.out.println("-----------------------------------------------------");

                break;
              case 2:
                  System.out.println("-----------------------------------------------------");
                  you[y].useAbilities(enemy[y]);
                  System.out.println("-----------------------------------------------------");
                break;
              case 3:
                  System.out.println("-----------------------------------------------------");
                  you[y].useItem(you[y]);
                  System.out.println("-----------------------------------------------------");
                break;
            }
          }
			  }
		  }

		  for (int e = 0; e < 3; e++) {
        if (enemy[e].isAlive()) {
  			  if (!turn) {
  				  enemy[e].attack(you[e]);
          }
			  }
		  }

		  turn = !turn;

	  }

    if (Party.teamIsAlive(you)){
      System.out.println("You win!");
    } else if (Party.teamIsAlive(enemy)){
      System.out.println("You lose!");
    } else {
      System.out.println("Draw!");
    }

  }







}
