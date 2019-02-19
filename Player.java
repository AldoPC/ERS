public class Player{
	private String name;
	private int level;
	private int hp;
	private int attack;
	private int defense;
	private int energy;
	private int speed;
	private int magic;
	private Abilities[] abilities;

	public Player(String name, int level, int hp, int attack,int defense,
                   int energy, int speed, int magic){
		this.name=name;
    this.level=level;
		this.hp=hp;
		this.attack=attack;
		this.defense=defense;
    this.energy=energy;
    this.speed=speed;
    this.magic=magic;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

  public void setLevel(int level){
		this.level=level;
	}

	public int getLevel(){
		return level;
	}

	public void setHp(int hp){
		this.hp=hp;
	}
	public int getHp(){
		return hp;
	}

  public void setAttack(int attack){
		this.attack=attack;
	}
	public int getAttack(){
		return attack;
	}
	public void setDefense(int defense){
		this.defense=defense;
	}
	public int getDefense(){
		return defense;
	}

	public void setEnergy(int energy){
		this.energy=energy;
	}

	public int getEnergy(){
		return energy;
	}

  public void setMagic(int magic){
    this.magic=magic;
  }

  public int getMagic(){
    return magic;
  }

  public boolean isAlive() {
    return hp > 0;
  }

  //String name, int level, int hp, int attack,int defense,int energy, int speed, int magic
	public String toString(){
		return "Character: "+name+" Lv: "+level+" Hp: "+hp+" Attack: "+attack+" Defense: "+defense+
           " Energy: "+energy+" Speed: "+speed+" Magic: "+magic;
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
