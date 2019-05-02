import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.geometry.*;
import java.util.Scanner;
import java.lang.Exception;

import java.io.Serializable;

public class BattleScene extends Scene implements Serializable{
	private Main main;
	private MainGameScene scene;
	private VBox all = new VBox();
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
  	private Player personajePrincipal;

	private int choosed;

  	private int answer;

  	private Enemy personaje2;
	private Player personaje1;
	


  	private Battle bs = new Battle();

		private Button attack = new Button("Attack");
		private Button abilities = new Button("Abilities");
		private Button item = new Button("item");
		private Button move = new Button("Move");

		private Player[] yourParty= new Player[3];
		private Enemy[] enemyParty= new Enemy[3];

	public BattleScene(Main main){
		super(new GridPane());
		this.main=main;

		batlleButtons.getChildren().addAll(attack, abilities, item, move);
		console1 = new Label(" 1");
		console1.setText(" 1");
		console2 = new Label(" 2");
		console2.setText(" 2");
		console3 = new Label(" 3");
		console3.setText(" ");
		console4 = new Label(" 4");
		console4.setText(" ");
		console5 = new Label();
		console5.setText(" ");
		terminal.getChildren().addAll(console1, console2, console3, console4, console5);
		//vboxBattle.getStylesheets().add("styles.css");

		GridPane battleGrid =(GridPane)super.getRoot();
		battleGrid.setGridLinesVisible(true);
   		m= new MapaBattle(main,"battleGrid",6,3);
		battleGrid.add(m,0,1);
		vboxBattle.setAlignment(Pos.CENTER);

    	//hbox.add(vboxBattle);
		terminal.setAlignment(Pos.CENTER);
		batlleButtons.setAlignment(Pos.CENTER);
		battleGrid.setAlignment(Pos.CENTER);
		terminal.setAlignment(Pos.TOP_LEFT);
		batlleButtons.setAlignment(Pos.CENTER);
		battleGrid.setAlignment(Pos.CENTER);
  		vboxBattle.getChildren().addAll(battleGrid, batlleButtons, terminal);
  		battleGrid.setStyle("-fx-background-color: #7ca3e2;");
		//hbox.setAlignment(vboxBattle, Pos.CENTER);
		all.setStyle("-fx-background-image: url('img/SEA.gif'); -fx-background-size: cover; -fx-background-position: top ;");
	    //hbox.setCenter(vboxBattle);



	  	Enemy raidriar= new Raidriar();
		Enemy alexXDevil= new AlexXDevil();
	  	Enemy joker= new Joker();

		Player marea= new Marea();
		Player obunga= new Obunga();
		Player cocorean= new Cocorean();


		yourParty[0]= main.getPersonajePrincipal();
		yourParty[1]= marea;
		yourParty[2]= marea;

		enemyParty[0]= raidriar;
		enemyParty[1]= raidriar;
		enemyParty[2]= raidriar;


		duel(yourParty, enemyParty);

		all.getChildren().addAll(battleGrid, batlleButtons, terminal);
		all.setPadding(new Insets(50));
		super.setRoot(all);




	}


	public void terminalPrint(String string){
			console1.setText(console2.getText());
			console2.setText(console3.getText());
			console3.setText(console4.getText());
			console4.setText(console5.getText());
			console5.setText(string);

	}

	public void duel(Player you[], Enemy enemy[]) {
		terminalPrint("Battle Start!!!");
	  terminalPrint("Choose your character");
		int y=0;
		choosed= 0;


    terminalPrint("What will "+you[y].getName()+" do?");

		attack.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player personajePrincipal= main.getPersonajePrincipal();
				int currHpEnemy= enemy[choosed].getHp();
				you[y].attack(enemy[choosed]);
				int damage= currHpEnemy - enemy[choosed].getHp();
				if(currHpEnemy == 0){
					//scene.getMapa().getCasillas()[personaje1.getX()][personaje1.getY()].setEnemy(null);
					main.returnToScene();

				}	
				terminalPrint(you[y].getName() + "'s attack does " + damage + " damage!");
				terminalPrint(enemy[choosed].getName() + "'s Health:"+ enemy[choosed].getHp());

				int currHpYou= you[y].getHp();
				enemy[choosed].attack(you);
				damage= currHpYou - you[y].getHp();
				if(currHpYou == 0){
					main.endGame();
					//casillas[7][4].setEnemy(null);
				}	
				terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
				terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
		abilities.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){

			int currHpEnemy= enemy[choosed].getHp();
			you[y].attack(enemy[choosed], 0);
			int damage= currHpEnemy - enemy[choosed].getHp();
			if(currHpEnemy == 0){
					//scene.getMapa().getCasillas()[personaje1.getX()][personaje1.getY()].setEnemy(null);
					main.returnToScene();

				}	


			terminalPrint(you[y].getName()+" used "+you[y].abilities[0].getName());
			terminalPrint(you[y].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(enemy[choosed].getName() + "'s Health:"+ enemy[choosed].getHp());

			int currHpYou= you[y].getHp();
			enemy[choosed].attack(you);
			damage= currHpYou - you[y].getHp();
			if(currHpYou == 0){
					main.endGame();
					//casillas[7][4].setEnemy(null);
				}	
			terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
		item.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){

			int currHpEnemy= enemy[choosed].getHp();
			you[y].usePotion(you, 0);
			int damage= currHpEnemy - enemy[choosed].getHp();
			if(currHpEnemy == 0){
					main.returnToScene();
					//scene.getMapa().getCasillas()[personaje1.getX()][personaje1.getY()].setEnemy(null);

				}	
			terminalPrint(you[y].getName() +"s health has increased to " + you[y].getHp());

			int currHpYou= you[y].getHp();
			enemy[choosed].attack(you);
			damage= currHpYou - you[y].getHp();
			if(currHpYou == 0){
					main.endGame();
					//casillas[7][4].setEnemy(null);
				}	
			terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
	}



}
