import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Casilla extends StackPane{
	private Label label;
	private Player setMainCharacter;
	private Enemy enemy;
	public Casilla(){
		label= new Label("");
		getChildren().add(label);
	}

	public void pintarCasilla(){
		if(setMainCharacter==null){
			if(enemy!=null){
				label.setText(enemy.getName());
			}else{
				label.setText("   ");
			}

		}else{
			label.setText(setMainCharacter.getName());
		}
	}

	public void setsetMainCharacter(Player caballeroDeBronce){
		this.setMainCharacter=setMainCharacter;
	}


	public Player getsetMainCharacter(){
		return setMainCharacter;
	}

	public Enemy getEnemy(){
		return enemy;
	}

	public void setEnemy(Enemy enemy){
		this.enemy=enemy;
	}


}
