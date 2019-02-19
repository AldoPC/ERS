public class Marea extends Magician{

	public Marea(){
    //String name, int level, int hp, int attack,int defense,
    //int energy, int speed, int magic
		super("Marea",1,10,5,2,20,5,10);
		Abilities[] abilities= new Abilities[3];
		abilities[0]= new Abilities("Very Strong punch",20);
		abilities[1]= new Abilities("Voice local",10);
		abilities[2]= new Abilities("Tidal Wave",25);
		super.setAbilities(abilities);

	}

}
