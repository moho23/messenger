import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String args[]) {
        int port = 9999;
        String hostIP = "127.0.0.1";

        try {
            Socket socket = new Socket(hostIP, port);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream((socket.getInputStream()));

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            if (true) {
                                String msg = (String)in.readObject();
                                System.out.println(msg);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            String msg = new Scanner(System.in).nextLine();
                            System.out.println(msg);
                            out.writeObject(msg);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }).start();

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}