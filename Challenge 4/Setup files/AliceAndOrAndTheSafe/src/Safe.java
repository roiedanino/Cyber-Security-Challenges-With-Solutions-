import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;


/**
 * Created by roie on 04/12/2017.
 */
public class Safe extends ThemeWindow{

    private static String input;
    private JPasswordField passwordField = new JPasswordField();
    private JPanel passwordPanel = new JPanel(new BorderLayout());
    private JButton submitButton = new JButton("*");
    private boolean toCleanBorder = false;


    public Safe() throws MalformedURLException {
        super("Alice and Or Safe");
        char[] options = new char[]{'1','2','3','4','5','6','7','8','9','*','0','#'};
        JPanel numPad = new JPanel(new GridLayout(4,3));
        input = "";
        JFrame jFrame =new JFrame(Autokey.AutoDecryption("ESZVIDRN","cemprdyvwxokolrdymsitvshgqwtnur".toUpperCase()));
        jFrame.setLayout(new BorderLayout());
        JTextArea label = new JTextArea("EnCt2da011d79f492609826df4996adf8509774fcfb32da011d79f492609826df4996ebRbHJM+lQJ\n" +
                "WmbvyJVr75GBctcyXq6DSxw4oNPq8i10SvoZETru3wmY9eTqSOCyCsIs=IwEmS\n" +
                "\n" +
                Autokey.AutoDecryption("Fiogpsr dp xh".toUpperCase(),"CEMPRDYVWXOKOLRDYMSITVSHGQWTNUR")+ "https://encipher.it");
        label.setEditable(false);
        jFrame.setSize(200,200);
        jFrame.add(label,BorderLayout.CENTER);
        jFrame.pack();
        jFrame.setAlwaysOnTop(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);


        for(int i = 0 ; i < options.length ; i++)
        {
            Font font = new Font("Helvetica",Font.BOLD,20);
            JLabel numKey = new JLabel();
            numKey.setText(String.format("%10c",options[i]));
            numKey.setFont(font);
            numKey.setOpaque(true);
            numKey.setBackground(Color.black);
            numKey.setForeground(Color.white);
            numKey.setBorder(new LineBorder(Color.white,3));

            numKey.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    numKey.setBackground(Color.white);
                    numKey.setForeground(Color.black);

                    if(toCleanBorder)
                        passwordPanel.setBorder(new LineBorder(Color.white));

                    String key = ((JLabel)e.getSource()).getText().trim();

                    if(!key.equals("*"))
                        input += key;
                    else
                        input = "";

                    passwordField.setText(input);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    numKey.setBackground(Color.black);
                    numKey.setForeground(Color.white);
                }
            });

            numPad.add(numKey);
        }

        submitButton.setBackground(Color.black);
        passwordField.setBorder(new EmptyBorder(10,10,10,10));
        passwordPanel.setBorder(new LineBorder(Color.white));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordField.getPassword()).isEmpty())
                    return;
                String aString = "AENVOQNWFQPOJQWQ", anotherString = "PSMAZLEWQBIASAASDQ";
                String password = Autokey.AutoDecryption(Autokey.AutoDecryption("cemprdyvwxokolrdymsitvshgqwtnur".toUpperCase(), "QZHQLMCAHYGM"),
                        Autokey.AutoDecryption("QZHQLMCAHYGM","CIWCQIKAWQEI"));

                aString = aString.concat(anotherString).replace("QZHQLMCAHYGM","CIWCQIKAWQEI");
                aString.length();

                if (new String(passwordField.getPassword()).toUpperCase().equals(password)) {
                    passwordPanel.setBorder(new LineBorder(Color.GREEN));
                    jFrame.setVisible(true);
                } else {

                    passwordPanel.setBorder(new LineBorder(Color.RED));
                    passwordField.setText("");
                    input = "";
                    toCleanBorder = true;
                }
            }


        });


        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(submitButton, BorderLayout.EAST);
        centerPanel.add(numPad, BorderLayout.CENTER);
        centerPanel.add(passwordPanel, BorderLayout.NORTH);
        Font font = new Font("Monospace",Font.PLAIN,10);
        JTextArea jTextArea = new JTextArea("Unix: Wireshark tcp.port eq 9999 on Loopback lo0\n" +
                "Windows: RawCap.exe -f <your local ip> dumpfile.pcap on cmd");
        jTextArea.setFont(font);
        jTextArea.setBackground(Color.BLACK);
        jTextArea.setForeground(Color.black);
        jTextArea.setSelectedTextColor(Color.RED);
        bottomPanel.add(jTextArea);
        super.setup();
        final String someString = "WOSPRMSFWFWEOINASWQD";
    }
}
