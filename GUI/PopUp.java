package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela para apresentar mensagens de erro ou confirmacao de acao
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class PopUp extends JFrame implements java.io.Serializable
{
    private JLabel lblMensagem;
    private JButton btnOk;
    private JPanel geral;
    
    public PopUp(String mensagem)
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS));
        
        lblMensagem = new JLabel(mensagem);
        lblMensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblMensagem);
        
        btnOk = new JButton("OK");
        btnOk.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(btnOk);
        
        btnOk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOkActionPerformed(evt);
            }
        });
        
        add(geral);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //setMinimumSize(new Dimension(200, 150));
        //setLocation(505, 360); // Coloca a janela ao lado do menu
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(false);
    }

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        // TODO add your handling code here:
        dispose();
    }
    
    public void setMensagem(String msg)
    {
        lblMensagem.setText(msg);
    }
}
