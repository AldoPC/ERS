public class Abilities{
	private String name;
	private int puntosEspeciales;
	public Abilities(String name,int puntosEspeciales){
		this.name= name;
		this.puntosEspeciales= puntosEspeciales;
	}
	public void setName(String nombre){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	public void setPuntosEspeciales(int puntosEspeciales){
		this.puntosEspeciales= puntosEspeciales;
	}
	public int getPuntosEspeciales(){
		return puntosEspeciales;
	}
}
