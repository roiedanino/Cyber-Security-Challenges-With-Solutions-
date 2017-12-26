import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Roie Danino on 01/12/2017.
 */
public class ThemeWindow extends JFrame {
    protected JPanel topPanel = new JPanel(new BorderLayout(20,20));
    protected JPanel centerPanel = new JPanel(new BorderLayout(10,10));
    protected JPanel bottomPanel = new JPanel(new BorderLayout(10,10));
    protected Color backgroundColor = Color.black, foregroundColor = Color.RED, midColor = Color.WHITE;
    protected Font font = new Font(Font.MONOSPACED,Font.BOLD, 20);
    private String title;

    public ThemeWindow(String title){
        super(title);
        this.title = title;

        setLayout(new BorderLayout());

        topPanelSettings();
        centerPanelSettings();
        bottomPanelSettings();


    }

    protected void setup(){
        final int WIDTH = 400, HEIGHT = 400;
        add(centerPanel, BorderLayout.CENTER);
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);

        setSize(new Dimension(WIDTH,HEIGHT));
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    protected void topPanelSettings()
    {
        topPanel.setBackground(backgroundColor);
        topPanel.setForeground(foregroundColor);

        JLabel titleLable = new JLabel(title);
        titleLable.setHorizontalAlignment(getWidth() / 2);

        titleLable.setFont(font);

        titleLable.setBackground(backgroundColor);
        titleLable.setForeground(foregroundColor);

        topPanel.setBorder(new EmptyBorder(5,0,0,0));
        topPanel.add(titleLable, BorderLayout.CENTER);
    }

    protected void centerPanelSettings(){
        centerPanel.setBackground(backgroundColor);
        centerPanel.setBorder(new EmptyBorder(10,10,0,10));

    }

    protected void bottomPanelSettings(){
        bottomPanel.setBackground(backgroundColor);
        final String FLAG =  "eNqtjb0KwjAUhXeh73Do4qQP4GadBN0EcYztqQmmuZAfKojvbpri4ODmFM53Tr777K26bdAwjqTDSRNN8oYdtq7DkcBqhla1dzTyeFWLavF7X9r660dd2B6BhLJ2XYKm8p/UJGM7mIjeywAnURt3m4oDJ5ZD1o/5CTmRU7OTgQiSHaOJGkOBZ+JaVIMkF5VxAVHQ+hQ0pKVyYVpdJC09YRw6lc1+virJ5yVVNDLP/id7A0KncfA=";
    }
}

/**
 *
 eNqtjb0KwjAUhXeh73Do4qQP4GadBN0EcYztqQmmuZAfKojvbpri4ODmFM53Tr777K26bdAwjqTDSRNN8oYdtq7DkcBqhla1dzTyeFWLavF7X9r660dd2B6BhLJ2XYKm8p/UJGM7mIjeywAnURt3m4oDJ5ZD1o/5CTmRU7OTgQiSHaOJGkOBZ+JaVIMkF5VxAVHQ+hQ0pKVyYVpdJC09YRw6lc1+virJ5yVVNDLP/id7A0KncfA=
 */