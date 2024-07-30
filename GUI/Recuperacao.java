package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import armazenamento.CadastroAlunos;
import persistencia.*;

/**
 * Janela para inserir o nome do arquivo e recuperar uma gravacao do armazenador
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Recuperacao extends JFrame implements java.io.Serializable
{
    private JPanel geral; //adcionar painel
    private JPanel botoes;//adcionar painel 
    private JLabel lblTitulo;
    private JButton btnCancelar;
    private JButton btnAbrir;
    private JTextField txtArq;//campo de colocar o ra
    private Menu frameMenu;
    private PopUp framePopUp;
    private CadastroAlunos cad;
    private IPersistencia arq;
    
    public Recuperacao(CadastroAlunos c, Menu menu, IPersistencia a)
    {
        frameMenu = menu;
        cad = c;
        arq = a;
        configurarJanela();
    }
    
    private void configurarJanela()
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS)); //adcionar painel vertical
        
        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());//adcionar painel horizontal
        
        lblTitulo = new JLabel("Digite o nome do arquivo");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblTitulo);
        
        txtArq = new JTextField(8);
        geral.add(txtArq);
        
        btnCancelar = new JButton("Cancelar");
        botoes.add(btnCancelar);
        
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });
        
        btnAbrir = new JButton("Abrir");
        botoes.add(btnAbrir);
        
        btnAbrir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAbrirActionPerformed(evt);
            }
        }); 
        
        geral.add(botoes);
        add(geral);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
        setResizable(false);
        setVisible(true);
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }
    
    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        cad = arq.lerLista(txtArq.getText() + ".bin");
        
        if(cad == null)// Verifica qual mensagem aparecerá quando o menu for resetado
        {
            frameMenu.setPopUp("Arquivo não encontrado");
        }
        else    // Caso o arquivo seja enctrado, altera o armazenador
        {
            frameMenu.setPopUp(txtArq.getText() + " recuperado com sucesso!");
        }
        frameMenu.setCad(cad); 
        dispose();
    }
    
}