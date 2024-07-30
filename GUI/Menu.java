package GUI;
import armazenamento.*;
import persistencia.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Janela do Menu Principal     
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Menu extends JFrame implements java.io.Serializable
{
    private JPanel menu;
    private JPanel botoes1;
    private JPanel botoes2;
    private JPanel botoes3;
    private JLabel lblTitulo;
    private JButton btnInserir;
    private JButton btnRemover;
    private JButton btnListar;
    private JButton btnSair;
    private JButton btnSalvar;
    private JButton btnRecuperar;
    private Insercao frameInsercao;
    private Remocao frameRemocao;
    private Listagem frameListagem;
    private Gravacao frameGravacao;
    private Recuperacao frameRecuperacao;
    private PopUp framePopUp;
    private CadastroAlunos cad;
    private IPersistencia arq;
    
    public Menu(CadastroAlunos c, IPersistencia a)
    {
        cad = c;  // Cria a lista para armazenar os alunos
        arq = a;
        iniciarComponentes();    // Configura a janela do Menu
        framePopUp = new PopUp(""); // PopUp para ser usado em mensagens no retorno ao menu
    }
    
    private void iniciarComponentes()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menu = new JPanel();
        
        lblTitulo = new JLabel("Cadastro de Alunos", SwingConstants.CENTER);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(lblTitulo);
        
        botoes1 = new JPanel();
        botoes1.setLayout(new FlowLayout());
        
        botoes2 = new JPanel();
        botoes2.setLayout(new FlowLayout());
        
        botoes3 = new JPanel();
        botoes3.setLayout(new FlowLayout());
        
        btnInserir = new JButton("Inserir");
        botoes1.add(btnInserir);
        
        btnInserir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInserirActionPerformed(evt);
            }
        });
        
        btnRemover = new JButton("Remover");
        botoes1.add(btnRemover);
        
        btnRemover.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoverActionPerformed(evt);
            }
        });
        
        btnListar = new JButton("Listar");
        botoes1.add(btnListar);
        
        btnListar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnListarActionPerformed(evt);
            }
        });
        
        btnSalvar = new JButton("Salvar");
        botoes2.add(btnSalvar);
        
        btnSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalvarActionPerformed(evt);
            }
        });
        
        btnRecuperar = new JButton("Recuperar");
        botoes2.add(btnRecuperar);
        
        btnRecuperar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRecuperarActionPerformed(evt);
            }
        });
        
        btnSair = new JButton("Sair");
        botoes3.add(btnSair);
        
        btnSair.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSairActionPerformed(evt);
            }
        });
        
        menu.add(botoes1);
        menu.add(botoes2);
        menu.add(botoes3);
        btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        add(menu);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
        setResizable(false);
        setVisible(true);
    }
    
    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameInsercao = new Insercao(cad, Menu.this);
        framePopUp.setVisible(false);
        setVisible(false);
    }
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameRemocao = new Remocao(cad, Menu.this);
        framePopUp.setVisible(false);
        setVisible(false);
    }
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameListagem = new Listagem(cad, Menu.this);
        framePopUp.setVisible(false);
        setVisible(false);
    }
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        framePopUp.dispose();
        dispose();
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameGravacao = new Gravacao(cad, Menu.this, arq);
        framePopUp.setVisible(false);
        setVisible(false);
    }
    
    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameRecuperacao = new Recuperacao(cad, Menu.this, arq);
        framePopUp.setVisible(false);
        setVisible(false);  
    }
    
    /**
     * Metodo para configurar a mensagem a ser mostrada no retorno ao menu
     *
     * @param mensagem A parameter
     */
    public void setPopUp(String mensagem)
    {
        framePopUp.setMensagem(mensagem);
        framePopUp.pack();
        framePopUp.setVisible(true);
    }
    
    /**
     * Modifica o cadastro apos a recuperacao de um arquivo salvo
     *
     * @param c A parameter
     */
    public void setCad(CadastroAlunos c)
    {
        cad = c;
    }
}
