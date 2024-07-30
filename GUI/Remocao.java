package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import armazenamento.CadastroAlunos;

/**
 * Janela para remover um novo aluno do armazenamento
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Remocao extends JFrame implements java.io.Serializable
{
    private JPanel geral;
    private JPanel botoes; 
    private JLabel lblTitulo;
    private JButton btnCancelar;
    private JButton btnRemover;
    private JTextField txtRA;
    private Menu frameMenu;
    private PopUp framePopUp;
    private CadastroAlunos cad;
    
    public Remocao(CadastroAlunos c, Menu menu)
    {
        frameMenu = menu;
        cad = c;
        configurarJanela();
    }
    
    private void configurarJanela()
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS)); //adcionar painel vertical
        
        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());//adcionar painel horizontal
        
        lblTitulo = new JLabel("Insira o RA do aluno");
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblTitulo);
        
        txtRA = new JTextField(8);
        geral.add(txtRA);
        
        btnCancelar = new JButton("Cancelar");
        botoes.add(btnCancelar);
        
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });
        
        btnRemover = new JButton("Remover");
        botoes.add(btnRemover);
        
        btnRemover.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoverActionPerformed(evt);
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
    }
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        int busca = cad.buscar(txtRA.getText());    // Busca a posicao do aluno caso ele esteja no array
        if(busca != -1)  // Se achar o ra no armazenador entao remove
        {
            cad.remover(busca);
            frameMenu.setPopUp("Aluno Removido com Sucesso"); 
        }
        else
        {
            frameMenu.setPopUp("Falha na remoção - RA não encontrado");
        }
        dispose();
    }
    
}
