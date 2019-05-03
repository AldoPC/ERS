import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.Serializable;

public class Main extends Application implements Serializable{ 
	private Scene loadScene = new LoadScene(this);
	private ChooseCaracter choseCharacter;
	private BattleScene battleScene;
	private MainGameScene mainGameScene;
	private Stage primaryStage;
	private Player personajePrincipal;
	private Enemy enemy;


	public static void main(String[] args) {
    	Application.launch(args);
	}

	public void start(Stage stage){
		primaryStage = stage;
		primaryStage.setScene(loadScene);
		//640px X 480px
		primaryStage.setWidth(656);
		primaryStage.setHeight(554);
		primaryStage.show();
	}
	public void setCharacterScene(){
		choseCharacter = new ChooseCaracter(this);
		primaryStage.setScene(choseCharacter);

	}

	public void setBattleScene(){
		battleScene = new BattleScene(this);
		primaryStage.setScene(battleScene);

	}

	public void setPlayer(Player personajePrincipal){
		this.personajePrincipal= personajePrincipal;
		System.out.println(personajePrincipal);
	}

	public Player getPlayer(){
		return personajePrincipal;
	}

	public void setGameScene(){
		mainGameScene = new MainGameScene(this);
		primaryStage.setScene(mainGameScene);
	}
	public void setGameScene(int mapCount){
		mainGameScene = new MainGameScene(this);
		mainGameScene.setMapa(mapCount);
		primaryStage.setScene(mainGameScene);
	}
	public MainGameScene getGameScene(){
		return mainGameScene;
	}
	public void returnToScene(){
		primaryStage.setScene(mainGameScene);
	}
	public void endGame(){
		primaryStage.hide();
	}

	public void setPersonajePrincipal(Player personajePrincipal){
		this.personajePrincipal=personajePrincipal;
	}

	public void setEnemy(Enemy enemy){
		this.enemy=enemy;
	}

	public Player getPersonajePrincipal(){
		return personajePrincipal;
	}


}
