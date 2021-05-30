package interfaces;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{

    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;

    public MainForm(){
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        //fazendo a minha tela aparecer no meio da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        //fazendo com que o programa pare ao fechar a janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
