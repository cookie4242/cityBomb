import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class CiyBomb
{

	public static void main(String[] args) 
	{
		int NumberOfCities = getIntInput("Enter number of cities: ");
		//int[] cityHealth = new int[NumberOfCities];
		ArrayList<Integer> cityHealth = new ArrayList<Integer>();
		int maxBlast = getIntInput("Enter bomb damage: ");
		int maxbombs = getIntInput("Enter number of bomb runs: ");
		cityHealth.add(getIntInput("Enter the cities HP (Int): "));

		for (int i = 1; i < NumberOfCities; i++) 
		{
			cityHealth.add(cityHealth.get(0));
		}
		PrintCityHealth(cityHealth);
		
		for(int i = 1; i < maxbombs; i++)
		{
			for(int i2 = 0; i2 < NumberOfCities; i2++)
			{
				//cityHealth[i2] = cityHealth[i2] - bomb(maxBlast);
				cityHealth.set(i2, cityHealth.get(i2) - bomb(maxBlast));
			}			PrintCityHealth(cityHealth);
		}
	}
	
	
	
	public static void PrintCityHealth(ArrayList cities) 
	{
		for(int i = 0; i  < cities.size(); i++)
			System.out.printf("%9d", cities.get(i));
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

