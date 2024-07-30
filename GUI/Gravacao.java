package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import armazenamento.CadastroAlunos;
import persistencia.*;

/**
 * Janela para inserir o nome do arquivo em que sera gravado o armazenador
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Gravacao extends JFrame implements java.io.Serializable
{
    private JPanel geral; //adcionar painel
    private JPanel botoes;//adcionar painel 
    private JLabel lblTitulo;
    private JButton btnCancelar;
    private JButton btnSalvar;
    private JTextField txtArq;//campo de colocar o ra
    private Menu frameMenu;
    private PopUp framePopUp;
    private CadastroAlunos cad;
    private IPersistencia arq;
    
    public Gravacao(CadastroAlunos c, Menu menu, IPersistencia a)
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
        
        lblTitulo = new JLabel("Digite um nome para salvar");
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
        
        btnSalvar = new JButton("Salvar");
        botoes.add(btnSalvar);
        
        btnSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalvarActionPerformed(evt);
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
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        if(arq.gravarLista(cad, txtArq.getText() + ".bin")) // Verifica se o arquivo pode ser salvo
        {
            frameMenu.setPopUp(txtArq.getText() + " salvo com sucesso!");   // Caso possa mostra o PopUp de confirmacao
        }
        else    // Caso contrario mostra o PopUp de erro
        {
            frameMenu.setPopUp("Falha na gravação!");
        }
        dispose();
    }
    
}
