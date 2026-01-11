package playerProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

abstract class Player {
	
	int jerseyNo;
	String name;
	int matches;
	int runs;
	int wickets;
	int catches;
	
	
	public Player() {
		// TODO Auto-generated constructor stub
	}


	public void calculatePerformance() {
		// TODO Auto-generated method stub
		
	}


	public Player(int jerseyNo, String name, int matches, int runs, int wickets, int catches) {
		super();
		this.jerseyNo = jerseyNo;
		this.name = name;
		this.matches = matches;
		this.runs = runs;
		this.wickets = wickets;
		this.catches = catches;
	}


	public int getJerseyNo() {
		return jerseyNo;
	}


	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMatches() {
		return matches;
	}


	public void setMatches(int matches) {
		this.matches = matches;
	}


	public int getRuns() {
		return runs;
	}


	public void setRuns(int runs) {
		this.runs = runs;
	}


	public int getWickets() {
		return wickets;
	}


	public void setWickets(int wickets) {
		this.wickets = wickets;
	}


	public int getCatches() {
		return catches;
	}


	public void setCatches(int catches) {
		this.catches = catches;
	}
	
	public void display()
	{
		System.out.println("===== ============");
		System.out.println("Jersey No : "+jerseyNo);
		System.out.println("Name : "+name);
		System.out.println("Matches : "+matches);
		System.out.println("Runs : "+runs);
		System.out.println("Wickets : "+wickets);
		System.out.println("Catches : "+catches);
	}
}////class Player ends here

class CricketPlayer extends Player {
	
	public CricketPlayer() {
		// TODO Auto-generated constructor stub
	}

	public CricketPlayer(int jerseyNo, String name, int matches, int runs, int wickets, int catches) {
		super(jerseyNo, name, matches, runs, wickets, catches);
	}
	
	
	   @Override
	    public void calculatePerformance() {
	        System.out.println("Performance Index : " +(getRuns() + getWickets() * 20 + getCatches() * 10));
	    }
	
}   ///class Cricket Player ends here

public class PlayerManagementSystem {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Player> p1 = new ArrayList<Player>();
	
	
	//// ========== Add Players =========/////
	static void addPlayer() {
        System.out.print("Jersey No: ");
        int j = sc.nextInt();

        for (Player p : p1) {
            if (p.getJerseyNo() == j) {
                System.out.println("Player already exists!");
                return;
            }
        }

        sc.nextLine();
        System.out.print("Name: ");
        String n = sc.nextLine();

        System.out.print("Matches: ");
        int m = sc.nextInt();
        
        System.out.print("Runs: ");
        int r = sc.nextInt();
        
        System.out.print("Wickets: ");
        int w = sc.nextInt();
        
        System.out.print("Catches: ");
        int c = sc.nextInt();

        p1.add(new CricketPlayer(j, n, m, r, w, c));
        System.out.println("Player Added Successfully");
    
	}
	////   AddPlayer methods ends here
	
	/// ========= Update Players ============////
	 static void updatePlayer() {
	        System.out.print("Jersey No to Update: ");
	        int j = sc.nextInt();

	        for (Player p : p1) 
	        {
	            if (p.getJerseyNo() == j) {
	            	
	                System.out.print("New Matches: ");
	                p.setMatches(sc.nextInt());
	                
	                System.out.print("New Runs: ");
	                p.setRuns(sc.nextInt());
	                
	                System.out.print("New Wickets: ");
	                p.setWickets(sc.nextInt());
	                
	                System.out.print("New Catches: ");
	                p.setCatches(sc.nextInt());
	                
	                System.out.println("Player Updated");
	                return;
	            }
	        }
	        System.out.println("Player Not Found");
	    }
   ///// UpdatePlayer method ends here
	 
	 
	 ////============ Remove Player ===========/////
	 
	  static void removePlayer() {
	        System.out.print("Jersey No to Remove: ");
	        int j = sc.nextInt();

	        Iterator<Player> it = p1.iterator();
	        while (it.hasNext()) {
	            if (it.next().getJerseyNo() == j) {
	                it.remove();
	                System.out.println("Player Removed");
	                return;
	            }
	        }
	        System.out.println("Player Not Found");
	    }
	  //// Remove Player methods ends here
	  
	//// ======= Display All Players ======= /////  
	  static void displayAll() {
		  
	        if (p1.isEmpty()) {
	            System.out.println("No Player Data");
	            return;
	        }
	        for (Player p : p1)
	            p.display();
	    }
///// Display methods ends here
	 
	  
	  //// ==== Display Top 3 Higest Runs Scorrer ======////
	  static void top3Runs() {
	        p1.stream().sorted((a, b) -> b.getRuns() - a.getRuns()).limit(3).forEach(p ->
	                    System.out.println(p.getName() + " - " + p.getRuns()));
	    }
	  
	  /// Top 3 Hisest run Scorrer ends here 
	  
	 
	  
	  //// ==== Display Top 3 Wickect Tackers =====////
	  
	  static void top3Wickets() {
	        p1.stream().sorted((a, b) -> b.getWickets() - a.getWickets()).limit(3).forEach(p -> System.out.println(p.getName() + " - " + p.getWickets()));
	    }
	  //// Top 3 Wickect tackers ends here
	  
	  
	  ////===== Most Catches =======////
	  
	  static void mostCatches() {
	        if (p1.isEmpty()) {
	            System.out.println("No Player Data");
	            return;
	        }
	        Player p = Collections.max(p1,Comparator.comparingInt(Player::getCatches));
	        System.out.println("Most Catches: " +p.getName() + " (" + p.getCatches() + ")");
	    }
	  
	  //// Most Catches ends here
	  
	  

	
	public static void main(String[] args) {
		
		int choice;

        do {
            System.out.println("\n---- PLAYER MANAGEMENT ----");
            System.out.println("1. Add Player");
            System.out.println("2. Remove Player");
            System.out.println("3. Update Player");
            System.out.println("4. Display All Players");
            System.out.println("5. Top 3 Run Scorers");
            System.out.println("6. Top 3 Wicket Takers");
            System.out.println("7. Most Catches");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addPlayer();
                case 2 -> removePlayer();
                case 3 -> updatePlayer();
                case 4 -> displayAll();
                case 5 -> top3Runs();
                case 6 -> top3Wickets();
                case 7 -> mostCatches();
                case 0 -> System.out.println("Exit");
                default -> System.out.println("Invalid Choice");
            }

        } while (choice != 0);
    }
}