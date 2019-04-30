import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.geometry.*;

public class LoadScene extends Scene {
	private Main main;
	private GridPane root = new GridPane();
	private VBox butt = new VBox();

	public LoadScene(Main main){
		super(new GridPane());
		this.main = main;


		root = (GridPane)super.getRoot();
		root.getStylesheets().add("styles.css");
		butt.getStyleClass().add("butt");


		Label title = new Label(" ECHOES OF THE RED SEA");
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


		root.setPadding(new Insets(150));
        root.setHgap(16);
        root.setVgap(8);

        root.add(title,0,0);
		butt.getChildren().addAll(newGame, loadGame);
		root.add(butt,0,1);
		butt.setAlignment(Pos.CENTER);

		super.setRoot(root);
	}
}

