import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
public class Mapa1 extends Mapa implements Serializable{
	public Mapa1(Main main){
		super(main,"Mapa 1", 20,15);
		casillas[0][0].setPersonajePrincipal(main.getPersonajePrincipal());
		casillas[7][4].setEnemy(new AlexXDevil());
		casillas[3][2].setEnemy(new Raidriar());
	}

	public Mapa getNextMap(){
		pintarMapa();
		return new Mapa2(main);

	}

}
