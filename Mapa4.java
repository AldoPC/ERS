import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
public class Mapa4 extends Mapa implements Serializable{
	public Mapa4(Main main){
		super(main,"Mapa 4", 20,15);
		casillas[7][10].setEnemy(new AlexXDevil());
	}

}
