public class Objects{
	private String name;
	private int points;

	public Objects(String name,int points){
		this.name=name;
		this.points=points;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setPoints(int points){
		this.points=points;
	}

	public int getPoints(){
		return points;
	}

}
