import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
public class Mapa3 extends Mapa implements Serializable{
	public Mapa3(Main main){
		super(main,"Mapa 3", 20,15);
		casillas[9][9].setEnemy(new AlexXDevil());
		casillas[4][2].setEnemy(new Joker());
	}

	public Mapa getNextMap(){  
		pintarMapa();     
		return new Mapa4(main);
	}

}
