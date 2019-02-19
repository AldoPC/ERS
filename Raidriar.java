public class Raidriar extends Magician{

	public Raidriar(){
    //String name, int level, int hp, int attack,int defense,
    //int energy, int speed, int magic
		super("Raidriar",1,50,5,2,20,5,10);
		Abilities[] abilities= new Abilities[3];
		abilities[0]= new Abilities("Red Tidal Wave",20);
		abilities[1]= new Abilities("Solar Punch",10);
		abilities[2]= new Abilities("Raidiance",25);
		super.setAbilities(abilities);

	}

}
