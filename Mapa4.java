import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.Serializable;
public class Mapa4 extends Mapa implements Serializable{
	public Mapa4(Main main){
		super(main,"Mapa 4", 20,15);
		casillas[7][10].setEnemy(new AlexXDevil());
	}

}
