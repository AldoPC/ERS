import java.util.Scanner;
import java.io.Serializable;

public class Enemy implements Serializable {

    public String name;
    public int level;
    public int hp;
    public int attack;
    public int defense;
    public int energy;
    public int speed;
    public int magic;
    public Abilities[] abilities;
    public String sprite;

    public Enemy(String name, int level, int hp, int attack,int defense,
                  int energy, int speed, int magic, String sprite){

        this.name=name;
        this.level=level;
        this.hp=hp;
        this.attack=attack;
        this.defense=defense;
        this.energy=energy;
        this.speed=speed;
        this.magic=magic;
        this.sprite=sprite;
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

    public void setSprite(String sprite){
      this.sprite=sprite;
    }

    public String getSprite(){
      return sprite;
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

    public int chooseEnemy(Player[] defender) {
        System.out.println("CHOOSE A CHARACTER ???????");
        System.out.println("1) Attack " + defender[0].getName());
        System.out.println("2) Attack " + defender[1].getName());
        System.out.println("3) Attack " + defender[2].getName());
        Scanner sc = new Scanner(System.in);
        return (sc.nextInt()-1);
    }

    public void attack(Player[] defender) {
        int value= (int)(Math.random() * ((2) + 1));
        if(defender[value].isAlive()){
            int damage = Math.max(0, attack - defender[value].getDefense());
            int hp = Math.max(0,defender[value].getHp() - damage);
            System.out.println(name + "'s attack does " + damage + " damage!");
            System.out.println(defender[value].getName() + "'s Health:"+ hp);
            defender[value].setHp(hp);
        }else{
            attack(defender);
        }
    }

    public int useAbilities(){
        System.out.println(printAbilities());
        System.out.println("Ability 1");
        System.out.println("Ability 2");
        System.out.println("Ability 3");
        Scanner sc = new Scanner(System.in);
        return (sc.nextInt()-1);
    }

    public void attack(Player defender, int i) {
        int damage = Math.max(0, abilities[i].getPuntosEspeciales() - defender.getDefense());
        int hp = Math.max(0, defender.getHp() - damage);
        System.out.println(name+" used "+abilities[i].getName());
        System.out.println(name + "'s attack does " + damage + " damage!");
        System.out.println(defender.getName() + "'s Health:"+ hp);
        defender.setHp(hp);
    }

    public static boolean teamIsAlive(Enemy player[]) {
        int alive = 0;
        for(int a=0; a<3; a++){
            if (player[a] != null) {
                if (player[a].isAlive()){
                    alive += 1;
                }
            }
        }
        return alive > 0;
    }


}
