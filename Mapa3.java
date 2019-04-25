import javafx.scene.layout.*;
import javafx.scene.control.*;
public class Mapa3 extends Mapa{
	public Mapa3(Main main){
		super(main,"Mapa 3", 20,15);
		casillas[9][9].setEnemy(new AlexXDevil());
	}

	public Mapa getNextMap(){
		return new Mapa4(main);
	}

}
