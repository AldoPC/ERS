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

		private int choosed;

  	private int answer;

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



    hbox.setCenter(vboxBattle);



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


	yourParty[0]= main.getPersonajePrincipal();
	yourParty[1]= marea;
	yourParty[2]= marea;

	enemyParty[0]= raidriar;
	enemyParty[1]= raidriar;
	enemyParty[2]= raidriar;


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
		terminalPrint("Battle Start!!!");
	  terminalPrint("Choose your character");
		int y=0;
		choosed= 0;


    terminalPrint("What will "+you[y].getName()+" do?");

		attack.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){

			int currHp= enemy[choosed].getHp();
			you[y].attack(enemy[choosed]);
			int damage= currHp - enemy[choosed].getHp();
			terminalPrint(you[y].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(enemy[choosed].getName() + "'s Health:"+ enemy[choosed].getHp());

			currHp= you[y].getHp();
			enemy[choosed].attack(you);
			damage= currHp - you[y].getHp();
			terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
		abilities.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){

			int currHp= enemy[choosed].getHp();
			you[y].attack(enemy[choosed], 0);
			int damage= currHp - enemy[choosed].getHp();
			terminalPrint(you[y].getName()+" used "+you[y].abilities[0].getName());
			terminalPrint(you[y].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(enemy[choosed].getName() + "'s Health:"+ enemy[choosed].getHp());

			currHp= you[y].getHp();
			enemy[choosed].attack(you);
			damage= currHp - you[y].getHp();
			terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
		item.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){

			int currHp= enemy[choosed].getHp();
			you[y].usePotion(you, 0);
			int damage= currHp - enemy[choosed].getHp();
			terminalPrint(you[y].getName() +"s health has increased to " + you[y].getHp());

			currHp= you[y].getHp();
			enemy[choosed].attack(you);
			damage= currHp - you[y].getHp();
			terminalPrint(enemy[choosed].getName() + "'s attack does " + damage + " damage!");
			terminalPrint(you[y].getName() + "'s Health:"+ you[y].getHp());

			}
		});
	}



}
