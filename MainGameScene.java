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
		m= new Mapa(main,"Mapa 1",30,30);
		gridPane.add(m,0,1);
		gridPane.add(new Label("Prueba"),0,2);
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
                }
                m.pintarMapa();
            }
        });
	}

    public Mapa getMapa(){
        return m;
    }
    private void checarCasilla(Casilla casilla){
        /*
				if(casilla.getEnemy()!=null){
            main.battle(main.getPersonajePrincipal(),casilla.getEnemy(),this);
        }
				*/
    }

}
