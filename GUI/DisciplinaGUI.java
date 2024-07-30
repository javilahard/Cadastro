package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import aluno.Disciplina;

/**
 * Janela para adicionar aas disciplinas de um aluno
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class DisciplinaGUI extends JFrame implements java.io.Serializable
{
    private JPanel geral;
    private JPanel dados;
    private JPanel botoes;
    private JLabel lblTitulo;
    private JLabel lblNome;
    private JLabel lblCodigo;
    private JLabel lblMedia;
    private JTextField txtNome;
    private JTextField txtCodigo;
    private JTextField txtMedia;
    private JButton btnAdicionar;
    private JButton btnCancelar;
    private Insercao frameInsercao;
    private PopUp framePopUp;
    
    public DisciplinaGUI(Insercao insercao)
    {
        configurarJanela();    // Configura a janela de Insercao
        framePopUp = new PopUp(""); // Cria uma janela de PopUp caso precise ser usada
        frameInsercao = insercao;
    }
    
    private void configurarJanela()
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS));
        
        lblTitulo = new JLabel("Disciplina", SwingConstants.CENTER);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblTitulo);
        
        dados = new JPanel();
        dados.setLayout(new GridLayout(3,2));
        
        lblNome = new JLabel("Nome");
        dados.add(lblNome);
        
        txtNome = new JTextField();
        //txtNome.setText("");
        dados.add(txtNome);
        
        lblCodigo = new JLabel("Codigo");
        dados.add(lblCodigo);
        
        txtCodigo = new JTextField();
        //txtCodigo.setSize(20, 20);
        dados.add(txtCodigo);
        
        lblMedia = new JLabel("Media");
        dados.add(lblMedia);
        
        txtMedia = new JTextField();
        txtMedia.setSize(20, 20);
        dados.add(txtMedia);
        
        geral.add(dados);
        
        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        
        btnCancelar = new JButton("Cancelar");
        botoes.add(btnCancelar);
        
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });
        
        btnAdicionar = new JButton("Adicionar");
        botoes.add(btnAdicionar);
        
        btnAdicionar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAdicionarActionPerformed(evt);
            }
        });
        
        geral.add(botoes);
        add(geral);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(400, 150));
        setLocationRelativeTo(null); // Centraliza a janela
        pack();
        setResizable(false);
        setVisible(true);
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameInsercao.resetarDisc();
        framePopUp.dispose();   // Fecha a janela de PopUp
        dispose();
    }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt)
    {                      
        framePopUp.dispose();
        if(txtNome.getText().trim().equals(""))
        {
            framePopUp = new PopUp("Nome Invalido");
            framePopUp.setVisible(true);
        }
        else if(txtCodigo.getText().trim().equals(""))
        {
            framePopUp = new PopUp("Codigo Invalido");
            framePopUp.setVisible(true);
        }
        else if(Utils.isNumeric(txtMedia.getText()) == 0 || Float.parseFloat(txtMedia.getText()) > 10 || Float.parseFloat(txtMedia.getText()) < 0)
        {   // Verifica se a media estra dentro do intervalo valido
            framePopUp = new PopUp("Media Invalida"); 
            framePopUp.setVisible(true);
        }
        else
        {   // Caso os dados sejam aceitos, adiciona a disciplina na janela de insercao
            frameInsercao.adicionarDisciplina(txtNome.getText(), txtCodigo.getText(), Float.parseFloat(txtMedia.getText()));
            frameInsercao.resetarDisc();
            dispose();
        }    
    }
    
    /**
     * Fecha o PopUp
     *
     */
    public void fecharPopUp()
    {
        framePopUp.dispose();        
    }
}
