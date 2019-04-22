
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;



public class ChooseCaracter extends Scene {
	private Main main;
	private VBox root = new VBox();

	public ChooseCaracter(Main main){
		super(new GridPane());
		this.main=main;
		GridPane character =(GridPane)super.getRoot();
		character.setGridLinesVisible(true);

		Button marea = new Button();
		marea.setStyle("-fx-background-image:url('img/Mareasprite.png');");
		marea.setMinHeight(300);
		marea.setMinWidth(150);
		marea.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player mar= new Marea();
				main.setPlayer(mar);
				//add game class
			}
		});

		Button dps = new Button();
		dps.setStyle("-fx-background-image:url('img/Mareasprite.png');");
		dps.setMinHeight(300);
		dps.setMinWidth(150);
		dps.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player dp= new Obunga();
				main.setPlayer(dp);
				//add game class
			}
		});

		Button coco= new Button();
		coco.setStyle("-fx-background-image:url('img/Mareasprite.png');");
		coco.setMinHeight(400);
		coco.setMinWidth(200);
		coco.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Player cb= new Cocorean();
				main.setPlayer(cb);
				//add game class
			}
		});

		character.add(marea,0,0);
		character.add(dps,1,0);
		character.add(coco,2,0);

		root.getChildren().addAll(character);
        super.setRoot(root);


	}
}
