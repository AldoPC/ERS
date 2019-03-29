public class Party {
  /*
  public static Objects[] inventory;

  public Party() {
    Objects[] inventory= new Objects[3];
    inventory [0]= new Objects("Health Potion", 5);
    inventory [1]= new Objects("Strength Potion", 3);
    inventory [2]= new Objects("Health Big Potion", 10);
    addObjects(inventory);
  }

  public Objects[] getObjects(){
    return inventory;
  }

  public static Objects getOneObject(int i){
    return inventory[i];
  }

  public void addObjects(Objects[] inventory){
    this.inventory = inventory;
  }

  public void removeObjects(int index){
    inventory[index]=null;
  }

  public static String printObjects(){
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

*/
  public static boolean teamIsAlive(Player player[]) {
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
