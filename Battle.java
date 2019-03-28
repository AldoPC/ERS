import java.util.Scanner;

public class Battle{

  public static void duel(Player you[], Enemy enemy[]) {
	  int yourSpeed = you[0].getSpeed() + you[1].getSpeed() + you[2].getSpeed();
	  int enemySpeed = enemy[0].getSpeed() + enemy[1].getSpeed() + enemy[2].getSpeed();
	  int fighters = 0;
      int choosed;

	  boolean turn;

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


	  while (Party.teamIsAlive(you) && Enemy.teamIsAlive(enemy)) {

		  for (int y = 0; y < 3; y++) {
		      if (you[y].isAlive() && you[y] != null) {
                  if (turn) {

                      System.out.println("What will "+you[y].getName()+" do?");

                      System.out.println("1) Attack");
                      System.out.println("2) Use Ability");
                      System.out.println("3) Use Item");
                      Scanner sc = new Scanner(System.in);
                      int answer= sc.nextInt();
                          switch (answer) {
                              case 1:
                                  choosed = you[y].chooseEnemy(enemy);
                                  if (enemy[choosed].isAlive() && enemy[choosed] != null ){
                                      System.out.println("-----------------------------------------------------");
                                      you[y].attack(enemy[choosed]);
                                      System.out.println("-----------------------------------------------------");

                                      } else {
                                          System.out.println(enemy[choosed].getName()+" is already dead");
                                          y -= 1;
                                      }
                                  break;
                              case 2:
                                  int ab= you[y].useAbilities();
                                  choosed = you[y].chooseEnemy(enemy);
                                  if (enemy[choosed].isAlive() && enemy[choosed] != null ){
                                      System.out.println("-----------------------------------------------------");
                                      you[y].attack(enemy[choosed], ab);
                                      System.out.println("-----------------------------------------------------");

                                  } else {
                                      System.out.println(enemy[choosed].getName()+" is already dead");
                                      y -= 1;
                                  }
                                  break;
                              case 3:
                                  System.out.println("-----------------------------------------------------");
                                  you[y].useItem(you);
                                  System.out.println("-----------------------------------------------------");
                                  break;
                          }
                  }
		      }
		  }

		  for (int e = 0; e < 3; e++) {
            if (enemy[e].isAlive() && enemy[e] != null) {
                if (!turn) {
                    enemy[e].attack(you);
                }
            }
		  }
		  turn = !turn;
		  System.out.println(Enemy.teamIsAlive(enemy));

	  }

    if (Party.teamIsAlive(you)){
      System.out.println("You win!");
    } else if (Enemy.teamIsAlive(enemy)){
      System.out.println("You lose!");
    } else {
      System.out.println("Draw!");
    }

  }







}
