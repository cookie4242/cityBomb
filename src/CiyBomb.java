import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class CiyBomb
{

	public static void main(String[] args) 
	{
		//int NumberOfCities = getIntInput("Enter number of cities: ");
		ArrayList<City> cityStats = new ArrayList<City>();
		ArrayList<City> deadCities = new ArrayList<City>(); 
		int maxBlast = 55;//getIntInput("Enter bomb damage: ");
		int maxbombs = 9;//getIntInput("Enter number of bomb runs: ");
		int startCityHealth = 233; //(getIntInput("Enter the cities HP (Int): "));
		
		
		 
		City city1 = new City("Blacksburg", startCityHealth, true);
		City city2 = new City("Christiansburg" ,startCityHealth, true);
		City city3 = new City("Radford" ,startCityHealth, true);
		City city4 = new City("Roanoke" ,startCityHealth, true);
		
		
		cityStats.add(city1);
		cityStats.add(city2);
		cityStats.add(city3);
		cityStats.add(city4);
	//	cityStats.remove("Radford");
		printCityName(cityStats);
		System.out.println("");
		printCityHealth(cityStats);
		
		
		for(int i = 1; i < maxbombs; i++)
		{
			for (City city : cityStats)
			{
				city.health = city.health - bomb(maxBlast);
				if (city.health <= 0)
				{
					city.isAlive = false;
					deadCities.add(city);
				}
			}
			
			if (deadCities.isEmpty() == false)
			{
				
				for(City city : deadCities)
				{
					System.out.println(city.name + city.health);
					cityStats.remove(city.name);
					printCityName(cityStats);
                    // empty deadCities
				}
			}
			printCityHealth(cityStats);
			
		}
		
	}
	

	
	public static void printCityHealth(ArrayList<City> cities) 
	{
		//for(int i = 0; i  < cities.size(); i++)
		for(City city : cities)
		{
			System.out.printf("%20d", city.health);
		}
		System.out.println(" ");

	}
	
	public static int bomb(int x)
	{
		Random randomGenerator = new Random();
		return  randomGenerator.nextInt(x);				
	}	
	
	public static String getStringInput(String consolePrompt)
	{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
	    try {
			System.out.print("Enter a String Value: ");
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return "";
	}
	
	public static int getIntInput(String consolePrompt)
	{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		try {
			System.out.print(consolePrompt);
			return Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public static void printCityName(ArrayList<City> cities)
	{
		for(City city : cities)
		{
			System.out.printf("%20s", city.name);
		}
		
	}
  
	
}

