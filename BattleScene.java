
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;



public class BattleScene extends Scene {
	private Main main;
	private VBox root = new VBox();
  private HBox battleRoot = new HBox();
  private MapaBattle m;

	public BattleScene(Main main){
		super(new GridPane());
		this.main=main;

		GridPane battleGrid =(GridPane)super.getRoot();
		battleGrid.setGridLinesVisible(true);
    m= new MapaBattle(main,"battleGrid",6,3);
		battleGrid.add(m,0,1);

    root.getChildren().addAll(battleGrid);
    super.setRoot(root);


	}
}
