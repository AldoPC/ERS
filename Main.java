import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application{
	private Scene loadScene = new LoadScene(this);
	private ChooseCaracter choseCharacter; 
	private Scene mainGameScene;
	private Stage primaryStage;
	private Player personajePrincipal;

	public static void main(String[] args) {
    	Application.launch(args);

/*
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

		//Battle.duel(yourParty, enemyParty);
 */
	}

	public void start(Stage stage){
		primaryStage = stage;
		//this.primaryStage = primaryStage;
		primaryStage.setScene(loadScene);
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
	}
	public void setCharacterScene(){
		choseCharacter = new ChooseCaracter(this);
		primaryStage.setScene(choseCharacter);

	}

	public void setPlayer(Player personajePrincipal){
		this.personajePrincipal= personajePrincipal;
		System.out.println(personajePrincipal);
	}

	public void setGameScene(){
		mainGameScene = new MainGameScene(this);
		primaryStage.setScene(mainGameScene);
		//primaryStage.setScene(new MainGameScene(this));
	}

	public Player getPlayer(){
		return personajePrincipal;
	}

	public void setPersonajePrincipal(Player personajePrincipal){
		this.personajePrincipal=personajePrincipal;
	}

	public Player getPersonajePrincipal(){
		return personajePrincipal;
	}


}
