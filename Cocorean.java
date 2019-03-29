public class Cocorean extends Warrior{

    public Cocorean(){
        //    String name, int level, int hp, int attack,int defense,int energy, int speed, int magic
        super("Cocorean",     1,         10,     5,         2,          20,         5,         13);
        Objects[] inventory= new Objects[3];

        abilities[1]= new Abilities("KokoroKO",45);
        abilities[2]= new Abilities("Penalti",45);
        super.setAbilities(abilities);
        inventory [0]= new Objects("Health Potion", 5);
        inventory [1]= new Objects("Strength Potion", 3);
        inventory [2]= new Objects("Health Big Potion", 10);
        super.addObjects(inventory);

    }

    @Override
    public void attack(Enemy defender) {
        System.out.println("C!!");
        int damage = Math.max(0, attack - defender.getDefense());
        int hp =  Math.max(0, defender.getHp() - damage);
        System.out.println(name + "'s attack does " + damage + " damage!");
        System.out.println(defender.getName() + "'s Health:"+ hp);
        defender.setHp(hp);
    }

}