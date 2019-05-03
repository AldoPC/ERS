import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import java.io.Serializable;

public class Casilla extends StackPane implements Serializable{
	private Label label;
	private Player personajePrincipal;
	private Enemy enemy;
	private Image imgPer;
	public Casilla(){
		label= new Label("");
		getChildren().add(label);
	}

	public void pintarCasilla(){
		if(personajePrincipal==null){
			if(enemy!=null){
				//label.setText(enemy.getName());
				imgPer = new Image(getClass().getResourceAsStream("img/AlexXDevilD.gif"));
				label.setGraphic(new ImageView(imgPer));
			}else{
				label.setMinWidth(32);
				label.setMinHeight(32);
				label.setGraphic(null);
			}

		}else{
			imgPer = new Image(getClass().getResourceAsStream("img/JokerD.gif"));
			label.setGraphic(new ImageView(imgPer));
		}
	}

	public void setPersonajePrincipal(Player personajePrincipal){
		this.personajePrincipal=personajePrincipal;
	}


	public Player getPersonajePrincipal(){
		return personajePrincipal;
	}

	public Enemy getEnemy(){
		return enemy;
	}

	public void setEnemy(Enemy enemy){
		this.enemy=enemy;
	}


}
