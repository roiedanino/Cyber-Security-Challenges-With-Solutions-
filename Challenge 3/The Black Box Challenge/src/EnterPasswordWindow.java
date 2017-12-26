import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;


/**
 * Created by roie on 01/12/2017.
 */
public class EnterPasswordWindow extends ThemeWindow{
        private JPasswordField passwordField = new JPasswordField();
        private JPanel passwordPanel = new JPanel(new GridLayout(3,1));
        private JLabel passwordTextLable = new JLabel("PLE453 3N73R P455W0RD:");

        private JButton openButton = new JButton("Open The Box");

        private JTextArea secretTextArea = new JTextArea();

        private static final String PASSWORD = "Y0{]r'3 1N 7H3 R16H7 P14C3";

        private URL gifUrl;

        private String[] gifs;

        private Icon gifIcon;
        private JLabel gifLabel;

        private JFrame wrongPasswordWindow = new JFrame("WRONG");

    public EnterPasswordWindow() throws MalformedURLException {
            super("The Black Box");

            passwordPanelSetup();

            centerPanel.add(passwordPanel, BorderLayout.CENTER);


            secretAreaSetup();


            bottomPanel.add(secretTextArea, BorderLayout.CENTER);

            initGifs();


            wrongWindow();

             openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String input = new String(passwordField.getPassword());
                    if(input.isEmpty())
                        return;
                    try {
                    if(input.equals(PASSWORD)){
                        gifLabel.setIcon(new ImageIcon(new URL("https://i.imgur.com/Fh8eXnl.gif")));
                        wrongPasswordWindow.setTitle("CORRECT!");
                        wrongPasswordWindow.repaint();
                        wrongPasswordWindow.setVisible(true);
                    } else{

                            Random random = new Random();
                            wrongPasswordWindow.setTitle("WRONG!");
                            gifLabel.setIcon(new ImageIcon(new URL(gifs[(random.nextInt(gifs.length))])));
                            wrongPasswordWindow.repaint();


                        wrongPasswordWindow.setVisible(true);
                    }
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                }
            });

        super.setup();


        wrongPasswordWindow.pack();
        wrongPasswordWindow.setAlwaysOnTop(true);
        wrongPasswordWindow.setResizable(false);
        wrongPasswordWindow.setLocationRelativeTo(null);
    }

        private void passwordPanelSetup() {
            final int  SPACES = 50;
            passwordPanel.setBorder(new EmptyBorder(SPACES ,SPACES,SPACES ,SPACES));
            passwordPanel.setBackground(backgroundColor);

            passwordTextLable.setFont(font);
            passwordTextLable.setForeground(Color.white);

            JPanel paddingPasswordPanel = new JPanel(new BorderLayout(10,10));
            paddingPasswordPanel.setBackground(backgroundColor);
            paddingPasswordPanel.setBorder(new EmptyBorder(20,0,20,0));
            paddingPasswordPanel.add(passwordField,BorderLayout.CENTER);

            openButton.setFont(font);

            passwordPanel.add(passwordTextLable);
            passwordPanel.add(paddingPasswordPanel);
            passwordPanel.add(openButton);
        }

        private void secretAreaSetup() {
            Font secretFont = new Font(Font.MONOSPACED,Font.PLAIN, 10);
            secretTextArea.setFont(secretFont);

            secretTextArea.setEditable(false);
            secretTextArea.setForeground(backgroundColor);
            secretTextArea.setBackground(backgroundColor);
            secretTextArea.setText("watch?v=mpaPBCBjSVc    unit-conversion.info/texttools/compress/\nBTBAM TBB        watch?v=rQmIPK7DQh8");
            secretTextArea.setSelectedTextColor(foregroundColor);
            secretTextArea.setOpaque(true);

        }

    private void initGifs() {
        gifs = new String[]{
                "https://ii.yuki.la/a/e5/d1d33578b22fa7b8972f134ada91b54e83846f962da5ac5e742f431784e01e5a.gif",
                "https://m.popkey.co/7149f1/1VYDj.gif",
                "http://gifimage.net/wp-content/uploads/2017/06/trump-wrong-gif-11.gif",
                "http://images4.fanpop.com/image/photos/17400000/-Thats-a-Lie-how-i-met-your-mother-17452973-462-208.gif",
                "http://68.media.tumblr.com/d2e0392d14b1547871f63d0d499817ea/tumblr_ohbhv0IBFW1uvazy3o1_250.gif",
                "https://i.imgur.com/q7nqBUb.gif",
                "https://thumbs.gfycat.com/WeeMassiveAfricanaugurbuzzard-small.gif",
                "https://i.imgur.com/6MBHZ6G.gif",
                "https://i.imgur.com/f6GRLxH.gif",
                "http://cdn1.clevver.com/wp-content/uploads/2014/03/divergent-bad-movie-reviews-4.gif"
        };
    }


    private void wrongWindow() throws MalformedURLException {
        gifUrl = new URL(gifs[new Random(gifs.length).nextInt() % gifs.length]);
        gifIcon = new ImageIcon(gifUrl);
        gifLabel = new JLabel(gifIcon);

        wrongPasswordWindow.getContentPane().add(gifLabel);
    }

}
