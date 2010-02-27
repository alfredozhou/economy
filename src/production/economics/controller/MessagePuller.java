package economics.controller;

import economics.dependencies.EconomicProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessagePuller {
    private EconomicProperties properties;

    @Autowired
    public MessagePuller(EconomicProperties properties) {
        this.properties = properties;
    }

    public String pullMessageFromFed() throws IOException {
        BufferedReader reader = talkToFed();
        return readFromFed(reader);
    }

    private BufferedReader talkToFed() throws IOException {
        URL url = new URL(properties.getUrlForGdp());
        URLConnection uc = url.openConnection();
        InputStream inputStream = uc.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private String readFromFed(BufferedReader reader) throws IOException {
        StringBuffer buffer = new StringBuffer();
        String line;
        while (( line = reader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
}
