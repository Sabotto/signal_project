package com.cardio_generator.outputs;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.server.WebSocketServer;

import com.datamanagement.DataReader;
import com.datamanagement.DataStorage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

public class WebSocketOutputStrategy implements DataReader {

    private final String serverURI;
    private WebSocketClient client;

    public WebSocketOutputStrategy(String serverURI)
    {
        this.serverURI = serverURI;
    }

    @Override
    public void readData(DataStorage dataStorage) throws IOException
    {
        client = new WebSocketClient(URI.create(serverURI)) {
            
            @Override
            public void onOpen(ServerHandshake handshake)
            {
                System.out.println("New connection: " + serverURI);
            }

            @Override
            public void onClose(int code, String reason, boolean remote)
            {
                System.out.println("Closed connection: " + serverURI);
            }

            @Override
            public void onMessage(String message)
            {
                try{
                    String[] split = message.split(",");
                    if(split.length == 4)
                    {
                        int patientId = Integer.parseInt(split[0]);
                        double value = Double.parseDouble(split[1]);
                        String label = split[2];
                        long timestamp = Long.parseLong(split[1]);                

                        dataStorage.addPatientData(patientId, value, label, timestamp);
                    } else {
                        System.err.println("Wrong message format");
                    }
                } catch (Exception e) {
                    System.err.println("Unexpected error during parsing the message");
                    e.getStackTrace();
                }
            }

            public void onError(Exception e)
            {
                e.printStackTrace();
            }
        };

        client.connect();
    }
}
