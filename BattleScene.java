import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.geometry.Pos;

import java.util.Scanner;



public class BattleScene extends Scene {
	private Main main;
	private VBox vboxBattle = new VBox();
	private BorderPane hbox  = new BorderPane();
  	private HBox batlleButtons = new HBox();
  	private VBox terminal = new VBox();
  	private  Label console1;
  	private  Label console2;
  	private  Label console3;
  	private  Label console4;
  	public  Label console5;
  	private MapaBattle m;

  	private int answer;

  	private Battle bs = new Battle();

	public BattleScene(Main main){
		super(new GridPane());
		this.main=main;


    	hbox.setCenter(vboxBattle);
		Button attack = new Button("Attack");
		attack.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				answer= 1;
				terminalPrint("1");
			}
		});
		Button abilities = new Button("Abilities");
		Button item = new Button("item");
		Button move = new Button("Move");
		batlleButtons.getChildren().addAll(attack, abilities, item, move);
		console1 = new Label(" 1");
		console1.setText(" 1");
		console2 = new Label(" 2");
		console2.setText(" 2");
		console3 = new Label(" 3");
		console3.setText(" ");
		console4 = new Label(" 4");
		console4.setText(" 4");
		console5 = new Label();
		console5.setText(" 5");
		terminal.getChildren().addAll(console1, console2, console3, console4, console5);
		hbox.getStylesheets().add("styles.css");

		GridPane battleGrid =(GridPane)super.getRoot();
		battleGrid.setGridLinesVisible(true);
   		m= new MapaBattle(main,"battleGrid",6,3);
		battleGrid.add(m,0,1);
		vboxBattle.setAlignment(Pos.CENTER);
  		vboxBattle.getChildren().addAll(battleGrid, batlleButtons, terminal);

    	//hbox.add(vboxBattle);
		terminal.setAlignment(Pos.CENTER);
		batlleButtons.setAlignment(Pos.CENTER);
		battleGrid.setAlignment(Pos.CENTER);
		terminal.setAlignment(Pos.TOP_LEFT);
		batlleButtons.setAlignment(Pos.CENTER);
		battleGrid.setAlignment(Pos.CENTER);
		hbox.setAlignment(vboxBattle, Pos.CENTER);
    	hbox.setCenter(vboxBattle);



    Enemy raidriar= new Raidriar();
	Enemy alexXDevil= new AlexXDevil();
    Enemy joker= new Joker();

	Player marea= new Marea();
	Player obunga= new Obunga();
	Player cocorean= new Cocorean();

	Player[] yourParty= new Player[3];
	yourParty[0]= marea;
	yourParty[1]= obunga;
	yourParty[2]= cocorean;

	Enemy[] enemyParty= new Enemy[3];
	enemyParty[0]= raidriar;
	enemyParty[1]= alexXDevil;
	enemyParty[2]= joker;

	duel(yourParty, enemyParty);


	super.setRoot(hbox);




	}


	public void terminalPrint(String string){
			console1.setText(console2.getText());
			console2.setText(console3.getText());
			console3.setText(console4.getText());
			console4.setText(console5.getText());
			console5.setText(string);

	}

	  public void duel(Player you[], Enemy enemy[]) {
	  int yourSpeed = you[0].getSpeed() + you[1].getSpeed() + you[2].getSpeed();
	  int enemySpeed = enemy[0].getSpeed() + enemy[1].getSpeed() + enemy[2].getSpeed();
	  int fighters = 0;
      int choosed;

	  boolean turn = yourSpeed > enemySpeed;

	  for (int f = 0; f < 3; f++) {
		  if (you[f] != null) {
			  fighters = fighters + 1;
		  }
		  if (enemy[f] != null) {
			  fighters = fighters + 1;
		  }
	  }

	  terminalPrint("There are " + fighters + " characters in battle");
	  terminalPrint("Battle Start!!!");
	  terminalPrint("Choose your character");


	  while (Party.teamIsAlive(you) && Enemy.teamIsAlive(enemy)) {

		  for (int y = 0; y < 3; y++) {
		      if (you[y].isAlive() && you[y] != null) {
                  if (turn) {

                      	terminalPrint("What will "+you[y].getName()+" do?");

                          switch (answer) {
                              case 1:
                                  choosed = you[y].chooseEnemy(enemy);
                                  if (enemy[choosed].isAlive() && enemy[choosed] != null ){
                                      terminalPrint("-----------------------------------------------------");
                                      you[y].attack(enemy[choosed]);
                                      terminalPrint("-----------------------------------------------------");

                                      } else {
                                          terminalPrint(enemy[choosed].getName()+" is already dead");
                                          y -= 1;
                                      }
                                  break;
                              case 2:
                                  int ab= you[y].useAbilities();
                                  choosed = you[y].chooseEnemy(enemy);
                                  if (enemy[choosed].isAlive() && enemy[choosed] != null ){
                                      terminalPrint("-----------------------------------------------------");
                                      you[y].attack(enemy[choosed], ab);
                                      terminalPrint("-----------------------------------------------------");

                                  } else {
                                      terminalPrint(enemy[choosed].getName()+" is already dead");
                                      y -= 1;
                                  }
                                  break;
                              case 3:
                                  terminalPrint("-----------------------------------------------------");
                                  you[y].useItem(you);
                                  terminalPrint("-----------------------------------------------------");
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

	  }

    if (Party.teamIsAlive(you)){
      terminalPrint("You win!");
    } else if (Enemy.teamIsAlive(enemy)){
      terminalPrint("You lose!");
    } else {
      terminalPrint("Draw!");
    }

  }

	scene2.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				switch (event.getCode()){
					case S:
						vbox2.getChildren().add(new Label(usuario.saludar()));
						break;
				}
			}
		});

}
