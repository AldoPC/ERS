public interface CharacterInterface {

    Abilities[] getAbilities();

    void setAbilities(Abilities[] abilities);

    String printAbilities();

    int chooseEnemy(Enemy[] defender);

    void attack(Enemy defender);

    void attack(Enemy[] defender);

    int useAbilities();

    void attack(Enemy defender, int i);

    void useItem(Player[] you);

    void usePotion(Player[] you, int i);

}
