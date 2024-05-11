package auroraapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class StatusParser {

    final String APIURL = "http://aurorawatch-api.lancs.ac.uk/0.2/";

    public String getCurrentStatusColor() {

        try {

            // Create the URL to get the current status color from the API and open the connection
            StringBuilder statusUrlBuilder = new StringBuilder();
            statusUrlBuilder.append(APIURL + "status/current-status.xml");
            URL statusUrl = new URI(statusUrlBuilder.toString()).toURL();
            HttpURLConnection connection = (HttpURLConnection) statusUrl.openConnection();
            connection.setRequestMethod("GET");

            // Retrieve the API response and add to a String
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ( (line = reader.readLine()) != null ) {
                response.append(line);
            }

            // Tidy up the connection and reader
            reader.close();
            connection.disconnect();

            // Parse the status color from the response
            int statusTagIndex = response.indexOf("status_id=");
            int statusValueStartIndex = response.indexOf("\"", statusTagIndex) + 1;
            int statusValueEndIndex = response.indexOf("\"", statusValueStartIndex);
            String statusValue = response.substring(statusValueStartIndex, statusValueEndIndex);

            StatusColor statusColor = StatusColor.valueOf(statusValue.toUpperCase());

            return statusColor.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        } 
    }


}
