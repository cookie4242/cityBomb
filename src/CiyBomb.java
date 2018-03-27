import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class CiyBomb
{

	public static void main(String[] args) 
	{
		int NumberOfCities = getIntInput("Enter number of cities: ");
		int[] cityHealth = new int[NumberOfCities];
		int maxBlast = getIntInput("Enter bomb damage: ");
		int maxbombs = getIntInput("Enter number of bomb runs: ");
		cityHealth[0] = getIntInput("Enter the cities HP (Int): ");

		for (int i = 1; i < NumberOfCities; i++) 
		{
			cityHealth[i] = cityHealth[0];
		}
		PrintCityHealth(cityHealth, NumberOfCities);
		
		for(int i = 1; i < maxbombs; i++)
		{
			for(int i2 = 0; i2 < NumberOfCities; i2++)
			{
				cityHealth[i2] = cityHealth[i2] - bomb(maxBlast);
			}
			PrintCityHealth(cityHealth, NumberOfCities);
		}
		
		
	//	int x = (98 + 54 * 63 + 43 * 324 * 21);
		
		//System.out.print(x);
	}
	
	
	
	public static void PrintCityHealth(int[] cities, int numOfCtys) 
	{
		for(int i = 0; i  < numOfCtys; i++)
			System.out.printf("%9d", cities[i]);
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

