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
		int maxBlast = 55;//getIntInput("Enter bomb damage: ");
		int maxbombs = 5;//getIntInput("Enter number of bomb runs: ");
		int startCityHealth = 233; //(getIntInput("Enter the cities HP (Int): "));
		
		
		 
		City city1 = new City("Blacksburg", startCityHealth, true);
		City city2 = new City("Christiansburg" ,startCityHealth, true);
		City city3 = new City("Radford" ,startCityHealth, true);
		City city4 = new City("Roanoke" ,startCityHealth, true);
		
		
		cityStats.add(city1);
		cityStats.add(city2);
		cityStats.add(city3);
		cityStats.add(city4);
		
		//cityStats.add("radford", 233, true);
		//city.
	/*	for (int i = 1; i < NumberOfCities; i++) 
		{
			cityStats.add(cityStats.get(0));
		}
		*/
		PrintCityHealth(cityStats);
		
		for(int i = 1; i < maxbombs; i++)
		{
//			for(int i2 = 0; i2 < NumberOfCities; i2++)
			for (City city : cityStats)
			{
				//cityHealth[i2] = cityHealth[i2] - bomb(maxBlast);
				//cityHealths.set(i2, cityHealths.get(i2) - bomb(maxBlast));
				city.health = city.health - bomb(maxBlast);
	//			health = health - 1;//bomb(maxBlast);
			}			
			PrintCityHealth(cityStats);
		}
	}
	

	
	public static void PrintCityHealth(ArrayList<City> cities) 
	{
		//for(int i = 0; i  < cities.size(); i++)
		for(City city : cities)
		{
			System.out.printf("%9d", city.health);
			System.out.printf("%9s", city.name);
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
	
}

