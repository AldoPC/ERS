import javafx.scene.layout.*;
import javafx.scene.control.*;
public class Mapa2 extends Mapa{
	public Mapa2(Main main){
		super(main,"Mapa 2", 20,15);
		casillas[8][5].setEnemy(new AlexXDevil());
	}

	public Mapa getNextMap(){
		return new Mapa3(main);
	}

}
