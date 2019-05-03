import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
public class Mapa2 extends Mapa implements Serializable{

	private int valorDadoA = (int)Math.floor(Math.random()*18);	
	private int valorDadoB = (int)Math.floor(Math.random()*12);;
	private int valorDadoC = (int)Math.floor(Math.random()*18);	
	private int valorDadoD = (int)Math.floor(Math.random()*12);;
	private int valorDadoE = (int)Math.floor(Math.random()*18);	
	private int valorDadoF = (int)Math.floor(Math.random()*12);;
	private int valorDadoG = (int)Math.floor(Math.random()*18);	
	private int valorDadoH = (int)Math.floor(Math.random()*12);;

	public Mapa2(Main main){
		super(main,"Mapa 2", 20,15);
		casillas[valorDadoA][valorDadoB].setEnemy(new AlexXDevil());
		casillas[valorDadoC][valorDadoD].setEnemy(new AlexXDevil());
		casillas[valorDadoE][valorDadoF].setEnemy(new Joker());
		casillas[valorDadoG][valorDadoH].setEnemy(new Raidriar());
	}

	public Mapa getNextMap(){
		pintarMapa();
		return new Mapa3(main);
	}

}
