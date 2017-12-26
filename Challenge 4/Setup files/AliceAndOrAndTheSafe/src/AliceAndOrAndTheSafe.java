import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;


/**
 * Created by roie on 04/12/2017.
 *
 *Unix: Wireshark tcp.port eq 9999 on Loopback lo0
 * Windows: RawCap.exe -f <your local ip> dumpfile.pcap on cmd
 *
 */
public class AliceAndOrAndTheSafe {
    final static int PORT = 9999;

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread or = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataOutputStream dataOutputStream = null;
                    DataInputStream dataInputStream = null;
                    int i = 0;
                    ServerSocket socket = new ServerSocket();

                    socket.bind(new InetSocketAddress(InetAddress.getLocalHost(), PORT));

                    Socket aliceSocket = socket.accept();
                    //System.out.printf("Connection Established! my IP : %s\n", InetAddress.getLocalHost());

                    String messages[] = new String[]{
                            "Or: Hey Alice",
                            "Or: How Are you Mamuchka?",
                            "Or: Did you left the house?",
                            "Or: Did you make sure that the safe is locked?",
                            "Or: What is the new code?",
                            "Or: Wow, that's scary, but i still need to know the code",
                            "Or: That's a good idea, but how?",
                            "Or: Yes i think i remember.",
                            "Or: You can send it"};

                    dataInputStream = new DataInputStream(aliceSocket.getInputStream());
                    dataOutputStream = new DataOutputStream(aliceSocket.getOutputStream());
                    String message;
                    //System.out.println("Or: Streams Are Open\n");

                    while (true) {
                        message = dataInputStream.readUTF();
                        TimeUnit.SECONDS.sleep(3);
                       // System.out.println("From Alice: " + message);
                        TimeUnit.SECONDS.sleep(3);

                        if (i == messages.length) {
                            TimeUnit.SECONDS.sleep(12);
                            i %= messages.length;
                        }

                        dataOutputStream.writeUTF(messages[i++]);
                        dataOutputStream.flush();
                    }
                }catch (IOException | InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        Thread alice = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                DataOutputStream dataOutputStream = null;
                DataInputStream dataInputStream = null;
                String KEY = "QZHQLMCAHYGM", TEXT = "CIWCQIKAWQEI";// KEY = TEXT, TEXT = KEY
                String[] messages = new String[]{
                        "Alice: Hey Or",
                        "Alice: How you doiinn Kapara?",
                        "Alice: Im great :)",
                        "Alice: Yes Neshama, i went for shopping",
                        "Alice: Of course, and i also changed the code, just in case",
                        "Alice: I would tell you, but i have a weird filling that someone is listening to our conversation",
                        "Alice: I know, but we have to encrypt our messages while sending this, there are some creepy \"hackers\" out there, you know",
                        "Alice: I think we should use an Alice Unique To Or Keys Encryption You remember?",
                        "Alice: the key will be:",
                        "Alice: ".concat(new String(new char[]{0x6d, 0x66, 0x66, 0x7a, 0x67, 0x72, 0x77, 0x76, 0x70, 0x7a,
                                0x69, 0x79, 0x63, 0x67, 0x6d, 0x65, 0x73, 0x76, 0x77, 0x6e, 0x65, 0x77, 0x6b, 0x6a, 0x65, 0x6b, 0x6b, 0x70,
                                0x76, 0x7a, 0x76}))};

                Socket orSocket = null;
                try {
                    orSocket = new Socket(InetAddress.getLocalHost(), PORT);
                    dataInputStream = new DataInputStream(orSocket.getInputStream());
                    dataOutputStream = new DataOutputStream(orSocket.getOutputStream());

                    String message, toSend;

                    while (true) {
                        i %= messages.length;
                        toSend = messages[i++];
                        if(i == 9) {
                            toSend = toSend.concat(Autokey.AutoDecryption(KEY,TEXT));
                        }
                        dataOutputStream.writeUTF(toSend);
                        dataOutputStream.flush();
                        message = dataInputStream.readUTF();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        or.start();
        TimeUnit.SECONDS.sleep(3);
        alice.start();
        TimeUnit.SECONDS.sleep(3);
        new Safe();

    }

}
