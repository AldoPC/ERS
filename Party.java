public class Party {



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
