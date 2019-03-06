import java.util.Scanner;

public class Player{
	
	private String name;
  private int level;
	private int hp;
  private int attack;
  private int defense;
	private int energy;
	private int speed;
	private int magic;
	public Abilities[] abilities;
	public Objects[] inventory;

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

	public void setSpeed(int speed){
		this.speed=speed;
	}

	public int getSpeed(){
		return speed;
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

	public Abilities[] getAbilities(){
		return abilities;
	}

	public void setAbilities(Abilities[] abilities){
			this.abilities=abilities;
	}

	public String printAbilities(){
		String result="Abilities: [";
		for(int i=0;i<abilities.length;i++){

				result= result+" ability "+(i+1)+": "
				+abilities[i].getName()
				+" points: "+ abilities[i].getPuntosEspeciales()+",";

		}
		result= result+"]";
		return result;
	}

	public Objects[] getObjects(){
		return inventory;
	}

	public void addObjects(Objects[] inventory){
		this.inventory= inventory;
	}

	public void removeObjects(int index){
		inventory[index]=null;
	}

	public String printObjects(){
		String result="inventory: [";
		for(int i=0;i<inventory.length;i++){
			if(inventory[i]!=null){
			result= result+" Object: "
				+inventory[i].getName()
				+" points: "+ inventory[i].getPoints()+",";
			}else{
				result= result+" Vacio ,";
			}
		}
		result= result+"]";
		return result;
	}

	public void attack(Player defender) {
		int damage = Math.max(0, attack - defender.getDefense());
		int hp = defender.getHp() - damage;
		System.out.println(name + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}

	public void useAbilities(Player defender){
		System.out.println(printAbilities());
		System.out.println("Ability 1");
		System.out.println("Ability 2");
		System.out.println("Ability 3");
		Scanner sc = new Scanner(System.in);
		int answer = sc.nextInt();
			switch (answer){
				case 1:
					attack(defender, 0);
					break;
				case 2:
					attack(defender, 1);
					break;
				case 3:
					attack(defender, 2);
					break;
      }
	}

	public void attack(Player defender, int i) {
		int damage = Math.max(0, abilities[i].getPuntosEspeciales() - defender.getDefense());
		int hp = defender.getHp() - damage;
		System.out.println(name+" used "+abilities[i].getName());
		System.out.println(name + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}

	public void useItem(Player you){
		System.out.println(printObjects());
		System.out.println("Object 1");
		System.out.println("Object 2");
		System.out.println("Object 3");
		Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()){
				case 1:
					usePotion(you);
					break;
				case 2:

					break;
				case 3:

					break;
			}
	}

	public void usePotion(Player you){
		int hp = you.getHp() + you.inventory[0].getPoints();
		you.setHp(hp);
		System.out.println(name +"s health has increased to " + hp);
	}




















}
