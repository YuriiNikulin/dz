package artcode.week3.testSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yurii on 11.02.17.
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {

     /*   String messege = "hell0)\n";

        Socket client = new Socket("192.168.1.65", 8887);

        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();

        os.write(messege.getBytes());
        os.flush();


        StringBuilder response = new StringBuilder();
        while (true) {

            int read = -1;
            while ((read = is.read()) != -1) {
                response.append((char) read);
            }


            System.out.println(response.toString());
        }*/


        Socket socket = new Socket("192.168.0.106", 8887);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("!!!!!");
        pw.flush();

        readStream(socket.getInputStream());
    }

    private static void readStream(InputStream inputStream) throws IOException {
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

