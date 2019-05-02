import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.Serializable;
public class Mapa1 extends Mapa implements Serializable{
	public Mapa1(Main main){
		super(main,"Mapa 1", 20,15);
		casillas[0][0].setPersonajePrincipal(main.getPersonajePrincipal());
		casillas[7][4].setEnemy(new AlexXDevil());
	}

	public Mapa getNextMap(){
		return new Mapa2(main);
	}

}
