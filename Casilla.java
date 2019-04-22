import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Casilla extends StackPane{
	private Label label;
	private Player personajePrincipal;
	private Enemy enemy;
	public Casilla(){
		label= new Label("");
		getChildren().add(label);
	}

	public void pintarCasilla(){
		if(personajePrincipal==null){
			if(enemy!=null){
				label.setText(enemy.getNombre());
			}else{
				label.setText("   ");
			}
			


		}else{
			label.setText(personajePrincipal.getNombre());
		}
	}

	public void setPersonajePrincipal(Player caballeroDeBronce){
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