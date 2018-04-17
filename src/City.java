
public class City 
{
	
	int health;
	boolean isAlive;
	String name;
	
	public City(String cityName , int startHealth, boolean stillAlive)
	{
		this.health = startHealth;
		this.name = cityName;
		this.isAlive = stillAlive;
	}

}
