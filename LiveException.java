import java.lang.Exception;

public class LiveException extends Exception{
	public LiveException(){
		super("you dont have life left");
		if(Player.isAlive() == false){
			System.out.println("esta hacinedo la Exception");
		}
	}
}