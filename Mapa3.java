import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.Serializable;
public class Mapa3 extends Mapa implements Serializable{
	public Mapa3(Main main){
		super(main,"Mapa 3", 20,15);
		casillas[9][9].setEnemy(new AlexXDevil());
	}

	public Mapa getNextMap(){
		return new Mapa4(main);
	}

}
