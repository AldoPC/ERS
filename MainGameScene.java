import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.event.*;

public class MainGameScene extends Scene{

	private Main main;
	private Mapa m;
	public MainGameScene(Main main){
		super(new GridPane());	
		this.main=main;	
		GridPane gridPane=(GridPane)super.getRoot();
		gridPane.add(new Label(main.getPlayer().getName()),0,0);
		m= new Mapa(main,"Mapa 1",10,10);
		gridPane.add(m,0,1);
		gridPane.add(new Label("Prueba"),0,2);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

        
                Player cb= main.getPlayer();
                m.getCasillas()[cb.getX()][cb.getY()].setMainPlayer1(null);
                try{
                    switch (event.getCode()) {
                        case UP:  
                            m.getCasillas()[cb.getX()][cb.getY()-1].getMainPlayer1();
                            cb.setY(cb.getY()-1);  
                            break;
                        case DOWN: 
                            m.getCasillas()[cb.getX()][cb.getY()+1].getMainPlayer1();
                            cb.setY(cb.getY()+1);
                            break;
                        case LEFT:
                            m.getCasillas()[cb.getX()-1][cb.getY()].getMainPlayer1(); 
                            cb.setX(cb.getX()-1); 
                            break;
                        case RIGHT:
                            m.getCasillas()[cb.getX()+1][cb.getY()].getMainPlayer1();
                            cb.setX(cb.getX()+1); 
                            break;  
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Hay una pared");
                }
                

                checarCasilla(m.getCasillas()[cb.getX()][cb.getY()]);
                m.getCasillas()[cb.getX()][cb.getY()].setMainPlayer1(cb);

                if(cb.getX()==m.getCasillas().length-1&&cb.getY()==m.getCasillas()[0].length-1){
                	gridPane.getChildren().remove(m);
                	cb.setX(0);
                	cb.setY(0);
                	m= m.getNextMap();
                	gridPane.add(m,0,1);
                }
                // m.pintarMapa();
            }
        });		
	}

    public Mapa getMapa(){
        return m;
    }
    
}