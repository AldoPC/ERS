import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;


public class Casilla extends StackPane{
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
				label.setText(enemy.getName());
			}else{
				label.setText(" ");
				imgPer = new Image(getClass().getResourceAsStream("img/Rock.png"));
				label.setGraphic(new ImageView(imgPer));	
			}

		}else{
			imgPer = new Image(getClass().getResourceAsStream("img/Mareasprite.png"));
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
