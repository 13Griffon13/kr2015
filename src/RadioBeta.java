import javax.sound.sampled.*;
import java.net.InetAddress;
import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Griffon on 23.12.2015.
 */
public class RadioBeta extends Thread{
//    private InetAddress ipAddr;
//    private Socket s;
//    private InputStream is;
//    private String host;
//    public RadioBeta() throws IOException, LineUnavailableException {
//       ipAddr = InetAddress.getByName(host);
//
//        s = new Socket(ipAddr, 7373);
//        is = s.getInputStream();
//        AudioFormat format = new AudioFormat();
//        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,format );
//        SourceDataLine speakers = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
//        speakers.open(format);
//        speakers.start();
//
//        Scanner sc = new Scanner(System.in);
//
//        int numBytesRead;
//
//        byte[] data = new byte[204800];
//
//        while (true) {
//            numBytesRead = is.read(data);
//            speakers.write(data, 0, numBytesRead);
//        }
//    }
//
//    @Override
//    public void run() {
//
//    }
}
