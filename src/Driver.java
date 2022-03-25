/**
 * 
 * @author Ramitha Manathunga
 *
 */
public abstract class Driver {
	
	/*
	 * this will hold member variables, getters and setters for drivers
	 */
	
	private String name;
	private String team;
	private String location;
	private String statistics;
	
	@Override
	public boolean equals(Object o) {
		return this.name.equals(((Driver) o).name);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatistics() {
		return statistics;
	}
	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}
	
	

}
