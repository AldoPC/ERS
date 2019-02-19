public class Magician extends Player {

    private Abilities[] abilities;

    public Magician(String name, int level, int hp, int attack,int defense,
                     int energy, int speed, int magic){
      super(name,level,hp,attack,defense,energy,speed,magic);
      abilities= new Abilities[3];
    }

    public Abilities[] getAbilities(){
		return abilities;
  	}

  	public void setAbilities(Abilities[] abilities){
    		this.abilities=abilities;
    	}

      public String printAbilities(){
    		String result="Abilities: [";
    		for(int i=0;i<abilities.length;i++){

      			result= result+" ability: "
      			+abilities[i].getName()
      			+" points: "+ abilities[i].getPuntosEspeciales()+",";

      	}
    		result= result+"]";
    		return result;
      }

}
