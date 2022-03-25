import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
/**
 * 
 * @author Ramitha Manathunga
 *
 */
public class Formula1ChampionshipManager implements ChampionshipManager{
	
	/*
	 * maximum number of drivers in a race
	 */
	private final int numberOfDrivers;
	
	/*
	 * creating array lists for hold driver's details and races
	 */
	private final ArrayList <Formula1Driver> season;
	private final ArrayList <Race> races;
	
	/*
	 * scanner for get user inputs
	 */
	private final Scanner scanner;
	
	/*
	 * initiate the instance for the class
	 */
	public Formula1ChampionshipManager (int numberOfDrivers) {
		
		this.numberOfDrivers = numberOfDrivers;
		season = new ArrayList<>();
		races = new ArrayList<>();
		scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Formula 1 Championship Manager");
		dash();
		System.out.println();
		
		displayMenu();
	}

	private void displayMenu() {
		
		/*
		 * display the main menu
		 * get user input for menu options
		 */
		
		while (true) {
			System.out.println("Formula 1 Championship Menu:");
			System.out.println();
			System.out.println("Create a new Driver and add to the Championship     (press 1)");
			System.out.println("Delete a existing Driver                            (press 2)");
			System.out.println("Change the Driver for an existing team              (press 3)");
			System.out.println("Display Statistics for Driver                       (press 4)");
			System.out.println("Display Formula 1 Driver table                      (press 5)");
			System.out.println("Add a completed race                                (press 6)");
			System.out.println("QuickSave                                           (press 7)");
			System.out.println("Exit the program                                    (press 8)");
			System.out.println();
			
			String line = scanner.nextLine();
			int command = 0;
			
			try {
				/*
				 * pass command as line String
				 */
				command = Integer.parseInt(line); 
			} catch (Exception e) {}
			
			switch (command) {
			case 1:
				addDriver();
				break;
			case 2:
				deleteDriver();
				break;
			case 3:
				changeDriver();
				break;
			case 4:
				displayStatistics();
				break;
			case 5:
				displayDriverTable();
				break;
			case 6:
				addCompletedRace();
				break;
			case 7:
				quickSave();
				break;
			case 8:
				exit();
				break;
	
			default:
				/*
				 * if user input wrong command
				 */
				dash();
				System.out.println("Wrong input. Please read the MENU carefully");
				dash();
				System.out.println();
				
			}
			
		}
		
	}

	private void exit() {
		
		/*
		 * exit method will execute system.exit method and will exit the program
		 */
		
		System.out.println();
		System.out.println("-----------THANK YOU----------");
		System.exit(0);
	
	}

	private void addDriver() {
		
		/*
		 * this will add a new driver to the race.
		 * getting the name of the driver
		 * getting the constructor team for that driver
		 * getting the location of the driver
		 * 
		 */
		
		dash();
		
		/*
		 * there are maximum 20 drivers racing in a race
		 * if maximum number of drivers reached, can't add more rivers for the race
		 */
		if (season.size() == numberOfDrivers) {
			System.out.println("Can't add more Drivers to the Race");
			return;
		}
		
		/*
		 * creating the new driver object
		 * if one driver already in the race, can't add that driver again
		 */
		Formula1Driver driver = new Formula1Driver();
		System.out.println("Insert Driver NAME: ");
		String line = scanner.nextLine();
		/*
		 * setting the driver name
		 */
		driver.setName(line);
		
		if (season.contains(driver)) {
			System.out.println("This driver is already in the Race");
			return;
		}
		
		System.out.println("Insert the constructor TEAM: ");
		line = scanner.nextLine();
		/*
		 * setting the constructor team for that player
		 */
		driver.setTeam(line);
		
		System.out.println("Insert the driver LOCATION: ");
		line = scanner.nextLine();
		/*
		 * setting the location of that driver
		 */
		driver.setLocation(line);
		
		/*
		 * add driver details to the season array list
		 */
		season.add(driver);
		
		System.out.println();
		System.out.println("Driver added to the race");
		System.out.println();
		
		dash();
		System.out.println();
		
		
	}
	
	private void deleteDriver() {
		
		/*
		 * this will delete a existing driver from the race
		 * getting existing name of the driver.
		 * if that name exist, remove that driver from the race
		 * if not display something
		 */
		
		dash();
		
		System.out.println("Insert Driver NAME to REMOVE: ");
		String line = scanner.nextLine();
		for (Formula1Driver driver : season) {
			if (driver.getName().equals(line)) {
				season.remove(driver);
				System.out.println("Driver " + driver.getName() + " removed from the Race");
				System.out.println();
				return;
			}
		}
		System.out.println("No such Driver in the Race");
		System.out.println();
	}
	
	private void changeDriver() {
		
		/*
		 * this method will change the driver form the constructor team in the current season
		 * getting the existing team name from the array list.
		 * if that name exist, getting user input of the new driver name for the team  
		 * when the driver changed,
		 * 		points, first positions, second positions, third positions and races participated will reset. 
		 */
		dash();
		System.out.println("insert the TEAM for CHANGE the Driver");
		String line = scanner.nextLine();

		for (Formula1Driver driver : season) {
			if (driver.getTeam().equals(line)) {
				System.out.println("Insert new Driver for team "  + driver.getTeam());
				line = scanner.nextLine();
				driver.setName(line);	
				driver.setPoints(0);
				driver.setFirstPositions(0);
				driver.setSecondPositions(0);
				driver.setThirdPositions(0);
				driver.setRacesParticipated(0);
				
			}
		}
		System.out.println();
		System.out.println("Driver Changed");
		System.out.println();
		
	}
	
	private void displayStatistics() {
		
		/*
		 * this will display  statistics of drivers.
		 * getting the name of the driver.
		 * if that name exist, will display various stats such as,
		 * 		number of positions, points and races participated.
		 * statistics will automatically update
		 */
		
		dash();
		System.out.println("Insert driver NAME: ");
		String line = scanner.nextLine();
		for (Formula1Driver driver : season) {
			if (driver.getName().equals(line)) {
				System.out.println("Driver " + driver.getName() +  " - " + " first positions: " 
			+ driver.getFirstPositions());
				System.out.println("Driver " + driver.getName() +  " - " + " second positions: " 
						+ driver.getSecondPositions());
				System.out.println("Driver " + driver.getName() +  " - " + " third positions: " 
						+ driver.getThirdPositions());
				System.out.println("Driver " + driver.getName() + " - " + " points: " 
						+ driver.getPoints());
				System.out.println("Driver " + driver.getName() + " - " + " races participated: "
						+ driver.getRacesParticipated());
				
				System.out.println();
				return;
				
			}
		}
		System.out.println("No such Driver in the Race");
		System.out.println();
	}
	
	private void displayDriverTable() {
		
		/* this will display the driver table with
		 * all the drivers competing in the championship
		 * the team they belongs to
		 * some of their statistics in the descending order
		 * if two drivers have same points, the one with the most first positions appears first
		 * table should automatically updated
		 */
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", 
        		"NAME", "TEAM", "LOCATION", "FIRST POSITIONS", "SECOND POSITIONS", "THIRD POSITION", "POINTS", "RACES");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Collections.sort(season, new CustomComparator());
		for (Formula1Driver driver : season) {
			System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s%-22s%-22s\n", 
					driver.getName(), driver.getTeam(), driver.getLocation(), driver.getFirstPositions(), 
					driver.getSecondPositions(), driver.getThirdPositions(), driver.getPoints(), driver.getRacesParticipated() );					
		}
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println();
		
	}
	
	private void addCompletedRace() {
		
		/* add a race with
		 * date
		 * positions that all the drivers achieved
		 * statistics and the table will update
		 * point allocated according to the list below
		 * 		position           points
		 *      1                  25
		 *      2                  18
		 *      3                  15
		 *      4                  12
		 *      5                  10
		 *      6                  8
		 *      7                  6
		 *      8                  4
		 *      9                  2
		 *      10                 1
		 * add race to the array list
		 */
		dash();
		
		System.out.println("Enter the date (mm-dd-yyyy)");
		System.out.println();
		String line = scanner.nextLine();
		Date date;
		try {
			date = new SimpleDateFormat("MM-DD-YYYY").parse(line);
		} catch (ParseException ex) {
			System.out.println("Please enter the date in correct format (mm-dd-yyyy)");
			System.out.println();
			return;
		}
		
		Race race = new Race();
		race.setDate(date);
		races.add(race);

		for (Formula1Driver driver : season) {
			
			System.out.println("Enter the FINISH POSITION of driver " + driver.getName() + " : ");
			
				line = scanner.nextLine();
				System.out.println();
				int position;
				try {
					position = Integer.parseInt(line);
					driver.setPosition(position);
					
					if (position == 1) {
						driver.setFirstPositions(driver.getFirstPositions() + 1);
						driver.setPoints(driver.getPoints() + 25);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					} 
					else if (position == 2) {
						driver.setSecondPositions(driver.getSecondPositions() + 1);
						driver.setPoints(driver.getPoints() + 18);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 3) {
						driver.setThirdPositions(driver.getThirdPositions() + 1);
						driver.setPoints(driver.getPoints() + 15);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 4) {
						driver.setPoints(driver.getPoints() + 12);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 5) {
						driver.setPoints(driver.getPoints() + 10);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 6) {
						driver.setPoints(driver.getPoints() + 8);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 7) {
						driver.setPoints(driver.getPoints() + 6);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 8) {
						driver.setPoints(driver.getPoints() + 4);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 9) {
						driver.setPoints(driver.getPoints() + 2);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position == 10) {
						driver.setPoints(driver.getPoints() + 1);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
					else if (position > 10) {
						driver.setPoints(driver.getPoints() + 0);
						driver.setRacesParticipated(driver.getRacesParticipated() + 1);
					}
				} catch (Exception e) {}
				
				
				
			System.out.println();
				
				
			
		}	
		
	}
	
	private void quickSave() {
		
		/*
		 * this will save the information
		 */
		
	}
	
	static void dash() {
		
		/*
		 * dash line for formatting
		 */
		
		for (int i = 0; i <= 80; i++) {
			System.out.print("-");
		}
		System.out.println();

	}
		
	

}
