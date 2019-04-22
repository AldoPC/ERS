import java.util.Scanner;

public class Player implements CharacterInterface{

	public String name;
	public int level;
	public int hp;
	public int attack;
	public int defense;
	public int energy;
	public int speed;
	public int magic;
	public int x;
	public int y;
	public Abilities[] abilities;
	public static Objects[] inventory;


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

	public Objects[] getObjects(){
		return inventory;
	}

	public Objects getOneObject(int i){
		return inventory[i];
	}

	public void addObjects(Objects[] inventory){
		this.inventory = inventory;
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



	public int chooseEnemy(Enemy[] defender) {
		System.out.println("CHOOSE A CHARACTER ???????");
		System.out.println("1) Attack " + defender[0].getName());
		System.out.println("2) Attack " + defender[1].getName());
		System.out.println("3) Attack " + defender[2].getName());
		Scanner sc = new Scanner(System.in);
		return (sc.nextInt()-1);
	}

	public int chooseAlly(Player[] defender) {
		System.out.println("CHOOSE A CHARACTER ???????");
		System.out.println("1) Attack " + defender[0].getName());
		System.out.println("2) Attack " + defender[1].getName());
		System.out.println("3) Attack " + defender[2].getName());
		Scanner sc = new Scanner(System.in);
		return (sc.nextInt()-1);
	}

	public void attack(Enemy defender) {
		int damage = Math.max(0, attack - defender.getDefense());
		int hp =  Math.max(0, defender.getHp() - damage);
		System.out.println(name + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}

	public void attack(Enemy[] defender) {
		int value= (int)(Math.random() * ((2) + 1));
		int damage = Math.max(0, attack - defender[value].getDefense());
		int hp = defender[value].getHp() - damage;
		System.out.println(name + "'s attack does " + damage + " damage!");
		System.out.println(defender[value].getName() + "'s Health:"+ hp);
		defender[value].setHp(hp);
	}

	public int useAbilities(){
		System.out.println(printAbilities());
		System.out.println("Ability 1");
		System.out.println("Ability 2");
		System.out.println("Ability 3");
		Scanner sc = new Scanner(System.in);
		return (sc.nextInt()-1);
	}

	public void attack(Enemy defender, int i) {
		int damage = Math.max(0, abilities[i].getPuntosEspeciales() - defender.getDefense());
		int hp = Math.max(0, defender.getHp() - damage);
		System.out.println(name+" used "+abilities[i].getName());
		System.out.println(name + "'s attack does " + damage + " damage!");
		System.out.println(defender.getName() + "'s Health:"+ hp);
		defender.setHp(hp);
	}

	public void useItem(Player[] you){
		int choosed;
		System.out.println(printObjects());
		System.out.println("Object 1");
		System.out.println("Object 2");
		System.out.println("Object 3");
		Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()){
				case 1:
					choosed = chooseAlly(you);
					usePotion(you, choosed);
					break;
				case 2:

					break;
				case 3:

					break;
			}
	}

	public void usePotion(Player[] you, int i){
		int hp = you[i].getHp() + you[i].inventory[0].getPoints();
		you[i].setHp(hp);
		System.out.println(name +"s health has increased to " + hp);
	}

	public void setX(int x){
	this.x=x;
}

public int getX(){
	return x;
}
public void setY(int y){
	this.y=y;
}

public int getY(){
	return y;
}
}
