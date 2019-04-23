import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;


public class LoadScene extends Scene {
	private Main main;
	private GridPane root = new GridPane();


	public LoadScene(Main main){
		super(new GridPane());
		this.main = main;


		root = (GridPane)super.getRoot();
		root.getStylesheets().add("styles.css");
		

		Label title = new Label("Obunga Marea Game");
		title.getStyleClass().add("titleLabel");


		Button newGame = new Button("Nueva Partida");
		newGame.getStyleClass().add("newGameButton");
		newGame.setMinHeight(50);
		newGame.setMinWidth(100);
		newGame.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				//go to character menu
				main.setCharacterScene();
			}

		});	

		Button loadGame = new Button("Cargar Partida");
		loadGame.getStyleClass().add("loadGameButton");
		loadGame.setMinHeight(50);
		loadGame.setMinWidth(100);
		loadGame.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				//go to saved menu
			}

		});	




		root.add(title,0,0);
		root.add(newGame,0,1);
		root.add(loadGame,0,2);

		super.setRoot(root);
	}
}

