package com.torpedo;

// A Java program for a Client
import java.net.*;
import java.io.*;

public class Client extends Communication implements Runnable
{
    // initialize socket and input output streams

    private String address = "127.0.0.1";
    // constructor to put ip address and port
    public void run()
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            in = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (true)
        {
            try
            {
                line = in.readLine();
                System.out.println(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        // close the connection
//        try
//        {
//            input.close();
//            out.close();
//            socket.close();
//        }
//        catch(IOException i)
//        {
//            System.out.println(i);
//        }
    }

    public static void main(String args[])
    {
        Client client = new Client();
    }
}