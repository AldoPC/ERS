
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.geometry.*;

import java.io.Serializable;

public class ChooseCaracter extends Scene implements Serializable {
	private Main main;
	private VBox loadSc = new VBox();

	public ChooseCaracter(Main main){
		super(new GridPane());
		this.main=main;
		GridPane character =(GridPane)super.getRoot();
		character.setGridLinesVisible(true);
		character.setStyle("-fx-background-image:url('img/redSea.gif'); -fx-background-size: cover; -fx-background-position: top ;");
		loadSc.setStyle("-fx-background-image:url('img/redSea.gif'); -fx-background-size: cover; -fx-background-position: top ;");
		character.getStylesheets().add("styles.css");

		Button marea = new Button();
		marea.setStyle("-fx-background-image:url('img/Marea1.png');");
		marea.getStyleClass().add("mareaBut");
		marea.setMinHeight(350);
		marea.setMinWidth(170);
		marea.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player mar= new Marea();
				main.setPlayer(mar);
				main.setGameScene();
			}
		});

		Button dps = new Button();
		dps.setStyle("-fx-background-image:url('img/Marea2.png');");
		dps.getStyleClass().add("mareaBut");
		dps.setMinHeight(350);
		dps.setMinWidth(170);
		dps.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player dp= new Obunga();
				main.setPlayer(dp);
				main.setGameScene();
			}
		});

		Button coco= new Button();
		coco.setStyle("-fx-background-image:url('img/Marea3.png');");
		coco.getStyleClass().add("mareaBut");
		coco.setMinHeight(350);
		coco.setMinWidth(170);
		coco.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player cb= new Cocorean();
				main.setPlayer(cb);
				main.setGameScene();
			}
		});

		character.add(marea,0,0);
		character.add(dps,1,0);
		character.add(coco,2,0);

		character.setPadding(new Insets(50));
        character.setHgap(16);
        character.setVgap(8);


		loadSc.getChildren().addAll(character);
        super.setRoot(loadSc);


	}
}
