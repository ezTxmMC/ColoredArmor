package de.eztxm.coloredarmor.util;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker {
    private final String version;

    public UpdateChecker(String version) {
        this.version = version;
    }

    public boolean latestVersion() {
        try {
            String urlString = "https://cdn.eztxm.de/plugin/coloredarmor/manifest.json";
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            JSONObject jsonObject = new JSONObject(line);
            return jsonObject.getString("Latest-Version").equalsIgnoreCase(version);
        } catch (IOException e) {
            return true;
        }
    }
}
