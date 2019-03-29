public class DamagePerSecond extends Player {

    public DamagePerSecond(String name, int level, int hp, int attack,int defense,
                   int energy, int speed, int magic){
        super(name,level,hp,attack,defense,energy,speed,magic);
        abilities= new Abilities[3];
        abilities[0]= new Abilities("DamagePerSecond",45);
    }

}
