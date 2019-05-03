import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.io.Serializable;

public class MainGameScene extends Scene implements Serializable{

	private Main main;
	private Mapa m;
    private GridPane gridPane;
	public MainGameScene(Main main){
		super(new GridPane());
		this.main=main;
		gridPane=(GridPane)super.getRoot();
        gridPane.setStyle("-fx-background-image:url('img/blueImg.jpg'); -fx-background-size: cover; -fx-background-position: top ;");
		//gridPane.add(new Label(main.getPlayer().getName()),0,0);
		//640px X 480px
		m= new Mapa(main,"Mapa 0", 20,15);
		gridPane.add(m,0,1);
		//gridPane.add(new Label("Prueba"),0,2);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {


                Player personajePrincipal= main.getPlayer();
                m.getCasillas()[personajePrincipal.getX()][personajePrincipal.getY()].setPersonajePrincipal(null);
                try{
                    switch (event.getCode()) {
                        case UP:
                            m.getCasillas()[personajePrincipal.getX()][personajePrincipal.getY()-1].getPersonajePrincipal();
                            personajePrincipal.setY(personajePrincipal.getY()-1);
                            break;
                        case DOWN:
                            m.getCasillas()[personajePrincipal.getX()][personajePrincipal.getY()+1].getPersonajePrincipal();
                            personajePrincipal.setY(personajePrincipal.getY()+1);
                            break;
                        case LEFT:
                            m.getCasillas()[personajePrincipal.getX()-1][personajePrincipal.getY()].getPersonajePrincipal();
                            personajePrincipal.setX(personajePrincipal.getX()-1);
                            break;
                        case RIGHT:
                            m.getCasillas()[personajePrincipal.getX()+1][personajePrincipal.getY()].getPersonajePrincipal();
                            personajePrincipal.setX(personajePrincipal.getX()+1);
                            break;
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Hay una pared");
                }


                checarCasilla(m.getCasillas()[personajePrincipal.getX()][personajePrincipal.getY()]);
                m.getCasillas()[personajePrincipal.getX()][personajePrincipal.getY()].setPersonajePrincipal(personajePrincipal);

                if(personajePrincipal.getX()==m.getCasillas().length-1&&personajePrincipal.getY()==m.getCasillas()[0].length-1){
                	gridPane.getChildren().remove(m);
                	personajePrincipal.setX(0);
                	personajePrincipal.setY(0);
                	m= m.getNextMap();
                	gridPane.add(m,0,1);
                    try{
                        FileOutputStream fout = new FileOutputStream("Mapa.atm");
                        ObjectOutputStream oos = new ObjectOutputStream(fout);
                        oos.writeObject(personajePrincipal);
                        oos.close();
                        System.out.println("Player Saved");
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                    personajePrincipal.nextMap();
                }
                m.pintarMapa();
            }
        });
	}

    public Mapa getMapa(){
        return m;
    }
    public void setMapa(int mapCount){
        gridPane.getChildren().remove(m);
        switch(mapCount){
            case 1: m = new Mapa1(main);
                break;
            case 2: m = new Mapa2(main);
                break;         
            case 3: m = new Mapa3(main);
                break;     
        }
         gridPane.add(m, 0, 1);
    }
    private void checarCasilla(Casilla casilla){

				if(casilla.getEnemy()!=null){
            main.setBattleScene();
        }


    }
    public GridPane getGridPane(){
        return gridPane;
    }
    public void setNewMap(Mapa newm){
        try{    
        m.pintarMapa();
        System.out.println("setNew in MainGameScene");
        }catch(Exception e){}
    }

}
