package com.example.root.usbservice;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by root on 4/17/17.
 */

public class Udp  {

    private String modifiedSentence = "";
    byte[] send_data = new byte[11];
    byte[] receiveData = new byte[11];
    private DatagramSocket client_socket2,client_socket;

    public Udp()  {
        try {
            this.client_socket2 = new DatagramSocket(2363);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    public void sendData(String str) throws IOException {
        //  byte[] send_data = new byte[str.length()-2];
        client_socket = new DatagramSocket();
        client_socket.setBroadcast(true);
        InetAddress IPAddress =  InetAddress.getByName("192.168.0.149");
        /// InetAddress IPAddress = InetAddress.getLocalHost();
        send_data = str.getBytes();
        DatagramPacket send_packet = new DatagramPacket(send_data,send_data.length,IPAddress,50013);
        client_socket.send(send_packet);
        //chandra
        // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // client_socket.receive(receivePacket);
        // modifiedSentence = new String(receivePacket.getData());
        // //System.out.println("FROM SERVER:" + modifiedSentence);
        // Log.d("FROM SERVER",modifiedSentence);
        // Log.d("er er","weeg");
        client_socket.close();

    }
    public String recieveData() throws IOException {
        // byte[] receiveData = new byte[];
        //  DatagramSocket client_socket = new DatagramSocket(2363);
        //InetAddress IPAddress =  InetAddress.getLocalHost();
        // while (!client_socket2.isClosed()) {
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        client_socket2.receive(receivePacket);
        modifiedSentence = new String(receivePacket.getData());

        ///////////////////ПРОВЕРКА ПРИНИМАЕМЫХ ДАННЫХ  ///////////////////////
        // Log.d("r",modifiedSentence);
        //if ((modifiedSentence.contains("I"))&&(!modifiedSentence.contains("c"))) {
        //   String beforeI = modifiedSentence.split("I")[0];
        //  String afterI = modifiedSentence.split("I")[1];
        //  try {
        //   Log.d("2", String.valueOf((Double.parseDouble(beforeI) - Double.parseDouble(afterI)) * 0.1 + 30));
        //   Log.d("123123", modifiedSentence);
        //  } catch (NumberFormatException e) {

        //   }
        //  }

        ///////////////////////////////////////////////////////

        // client_socket2.close();
        return modifiedSentence;
    }



}
