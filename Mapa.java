import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.io.Serializable;
public class Mapa extends VBox implements Serializable{
	public Casilla[][] casillas;
	public Main main;

	public Mapa(){

	}
	public Mapa(Main main,String titulo,int casillasX,int casillasY){
		this.main=main;

		GridPane grid= new GridPane();
		grid.getStylesheets().add("styles.css");
		grid.setGridLinesVisible(true);
		grid.getStyleClass().add("gripMap");
		Label label= new Label(titulo);
		casillas= new Casilla[casillasX][casillasY];
		for(int i=0;i<casillas.length;i++){
			for(int j=0;j<casillas[i].length;j++){
				System.out.println("Crea casilla "+i+" "+j);
				casillas[i][j]= new Casilla();
				grid.add(casillas[i][j],i,j);
			}
		}
		getChildren().add(label);
		getChildren().add(grid);

		//casillas[9][9].setPersonajePrincipal(main.getPersonajePrincipal());
		/*
		casillas[7][4].setEnemy(new AlexXDevil());
		*/
		pintarMapa();
	}

	public Casilla[][] getCasillas(){
		return casillas;
	}

	public void pintarMapa(){
		for(int i=0;i<casillas.length;i++){
			for(int j=0;j<casillas[i].length;j++){
				casillas[i][j].pintarCasilla();
			}
		}
	}
	

	public Mapa getNextMap(){
		pintarMapa();
		return new Mapa1(main);

	}



}
