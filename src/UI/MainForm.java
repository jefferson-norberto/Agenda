package UI;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame{

    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";

    public MainForm(){
        mContactBusiness = new ContactBusiness();

        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        //fazendo a minha tela aparecer no meio da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        //fazendo com que o programa pare ao fechar a janela
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadContacts();
        setListener();
    }



    private void setListener(){
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                //fecha minha janela anterior
                dispose();
            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()){
                    //estava dando erro pois estava 1 e não 1- no if abaixo
                    if(tableContacts.getSelectedRow() != -1){
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }

                }
            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        mContactBusiness.remove(mName, mPhone);
                        mName = "";
                        mPhone = "";
                        loadContacts();
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(new JFrame(), exp.getMessage());
                    }
            }
        });
    }

    private void loadContacts(){
        List<ContactEntity> list = mContactBusiness.getList();

        String[] columnNames = {"Nome", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for(ContactEntity i: list){
            Object[] o = new Object[2];

            o[0] = i.getName();
            o[1] = i.getPhone();

            model.addRow(o);
        }

        tableContacts.clearSelection();
        labelContactCount.setText(mContactBusiness.getContactCountDescription());
        tableContacts.setModel(model);

    }

}

