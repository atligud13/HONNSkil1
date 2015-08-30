import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class League {
    public String name;
    public String season;
    public ArrayList<Team> teams = new ArrayList<Team>();


    /**
     * Prints out the league table, having some trouble with the tabs.
     */
    public void printLeagueTable() {
        System.out.println("League: " + this.name);
        System.out.println("Season: " + this.season);
        System.out.println("Team name" + "\t\t\t\t" + "Abb Venue" + "\t\t\t\t" + "City");
        System.out.println("------------------------------------------------------------------------");
        for(Team team: this.teams) {
            System.out.println(team.name + "\t\t\t\t" + team.abb + " " + team.venue + "\t\t\t\t" + team.city);
        }
    }
}
