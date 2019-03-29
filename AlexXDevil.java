public class AlexXDevil extends Enemy{

    public AlexXDevil(){
        //  String name, int level, int hp, int attack, int defense, int energy, int speed, int magic
        super("AlexXDevil",  1,         50,     5,          2,           20,         100,       10);
        Abilities[] abilities= new Abilities[3];
        abilities[0]= new Abilities("Sand_Wave",20);
        abilities[1]= new Abilities("Runnung in the 90s",10);
        abilities[2]= new Abilities("Lo-Fi",25);
        super.setAbilities(abilities);

    }

    @Override
    public void attack(Player[] defender) {
        System.out.println("XD!!");
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

}