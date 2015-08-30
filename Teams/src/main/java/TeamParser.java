import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class TeamParser {

    public void parseAndPrint(String s) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        JSONArray apiResults = (JSONArray) jsonObject.get("apiResults");

        /**
         * Formatting dates to the way we want to present them
         */
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd kk:mm:ss z y");
        Date startDateObj = parseDate((String) jsonObject.get("startTimestamp"));
        Date endDateObj = parseDate((String) jsonObject.get("endTimestamp"));
        String startDate = format.format(startDateObj);
        String endDate = format.format(endDateObj);
        System.out.println(startDate);

        /**
         * Printing out first segment of data, sample format:
         * OK
         * 20
         * startTimestamp: Fri Aug 21 16:19:30 GMT 2015
         * endTimestamp: Fri Aug 21 16:19:30 GMT 2015
         * 0.359375
         *
         */

        System.out.println(jsonObject.get("status"));
        System.out.println(jsonObject.get("recordCount"));
        System.out.println("startTimestamp: " + startDate);
        System.out.println("endTimestamp: " + endDate);
        System.out.println(jsonObject.get("timeTaken"));

        /**
         * Data is arranged into a set of arrays within arrays so we'll
         * have to loop through each of them.
         * Each api result includes a league.
         * Leagues include a Season, Seasons include an array of conferences.
         * Each conference includes an array of divisions, each division includes an array of teams.
         */
        for(Object apiObj: apiResults) {
            JSONObject apiResult = (JSONObject) apiObj;
            JSONObject league = (JSONObject) apiResult.get("league");
            JSONObject season = (JSONObject) league.get("season");

            /**
             * Printing out next segment  of data, sample format:
             * Soccer
             * English Premier League
             * 2015 EPL Season
             */
            System.out.println(apiResult.get("name"));
            System.out.println(league.get("displayName"));
            System.out.println(season.get("name"));

            JSONArray conferences = (JSONArray) season.get("conferences");

            for(Object conferenceObj: conferences) {
                JSONObject conference = (JSONObject) conferenceObj;
                JSONArray divisions = (JSONArray) conference.get("divisions");

                for(Object divisionObj: divisions) {
                    JSONObject division = (JSONObject) divisionObj;
                    JSONArray teams = (JSONArray) division.get("teams");

                    for(Object teamObj: teams) {
                        JSONObject team = (JSONObject) teamObj;
                        JSONObject venue = (JSONObject) team.get("venue");

                        /**
                         * Printing out final segment of data, sample format:
                         * Liverpool, Anfield
                         * West Ham United, Upton Park
                         * Aston Villa, Villa Park
                         */
                        System.out.println(team.get("displayName") + ", " + venue.get("name"));
                    }
                }
            }
        }




    }

    public Date parseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss", Locale.ENGLISH);
        try  { return format.parse(date); }
        catch(ParseException e) { e.printStackTrace(); }
        return null;
    }
}
