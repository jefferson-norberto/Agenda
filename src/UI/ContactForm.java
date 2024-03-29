package UI;

import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JTextField textName;
    private JTextField textPhone;
    private JButton buttonSave;
    private JButton buttonCancel;
    private ContactBusiness mContactBusiness;

    public ContactForm(){
        mContactBusiness = new ContactBusiness();

        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        //fazendo a minha tela aparecer no meio da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        //fazendo com que o programa pare ao fechar a janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListener();
    }

    private void setListener(){
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textName.getText();
                    String phone = textPhone.getText();

                    mContactBusiness.save(name, phone);
                    new MainForm();
                    dispose();
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(new JFrame(), exception.getMessage());
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainForm();
                dispose();
            }
        });
    }
}
