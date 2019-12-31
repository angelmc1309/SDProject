/*

Autors:
* Juan Cano Pradas
* Nil Ballus Riu
* David Rial Fígols

 */

package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class FormUser extends JDialog{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldUsername;
    //private JTextField textFieldClient;
    private JLabel usernameLabel;
    //private JLabel clientLabel;



    public FormUser() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
        setTitle("LOG IN");
        initComponents();
    }

    private void initComponents() {


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        textFieldUsername.requestFocusInWindow();
        //textFieldClient.requestFocusInWindow();
    }

    private void onRegister() {
        //TODO Cal cridar a Controller per fer el registre de l'usuari
        //String client = textFieldClient.getName();
        String client = Controller.getInstance().getLoggedClient();
        String username = textFieldUsername.getText();
        if (Controller.getInstance().addUsuari(client,username)){

            JOptionPane.showMessageDialog(this, "Usuari registrat correctament");
            dispose();
        } else{
            if (Controller.getInstance().tooMuchUsers(client)){
                JOptionPane.showMessageDialog(this,"S'ha arribat al maxim nombre d'usuaris");
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Aquest usuari ja existeix");
                textFieldUsername.setText("");
            }
        }

    }

    private void onCancel() {
        dispose();
    }
}
