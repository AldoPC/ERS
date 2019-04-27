import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.geometry.Pos;



public class BattleScene extends Scene {
	private Main main;
	private VBox vboxBattle = new VBox();
	private BorderPane hbox  = new BorderPane();
  	private HBox batlleButtons = new HBox();
  	private VBox terminal = new VBox();
  	private MapaBattle m;

	public BattleScene(Main main){
		super(new GridPane());
		this.main=main;


    	hbox.setCenter(vboxBattle);
		Button attack = new Button("Attack");
		Button abilities = new Button("Abilities");
		Button item = new Button("item");
		Button move = new Button("Move");
		batlleButtons.getChildren().addAll(attack, abilities, item, move);
		Label console1 = new Label(" 1");
		Label console2 = new Label(" 2");
		Label console3 = new Label(" 3");
		Label console4 = new Label(" 4");
		Label console5 = new Label(" 5");
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

    	console1.setText(console2.getText());
    	

    	super.setRoot(hbox);



	}


	public String terminalPrint(String string){
		for(int i=0; i<6;i++){
			console1.setText(console2);
		}
		
	}

}
