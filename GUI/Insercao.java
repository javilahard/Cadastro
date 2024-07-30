package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import aluno.*;
import armazenamento.CadastroAlunos;

/**
 * Janela para adicionar os dados e inserir um novo aluno
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Insercao extends JFrame implements java.io.Serializable
{
    private JPanel geral;
    private JPanel dados;
    private JPanel disciplinas;
    private JPanel botoes;
    private JLabel lblTitulo;
    private JLabel lblNome;
    private JLabel lblIdade;
    private JLabel lblRG;
    private JLabel lblRA;
    private JLabel lblCurso;
    private JLabel lblSemestre;
    private JLabel lblDisc;
    private JTextField txtNome;
    private JTextField txtRG;
    private JTextField txtRA;
    private JComboBox boxIdade;
    private JComboBox boxCurso;
    private JComboBox boxSemestre;
    private JButton btnAdicionarDisciplina;
    private JButton btnCancelar;
    private JButton btnConfirmar;
    private DisciplinaGUI frameDisc;
    private Menu frameMenu;
    private PopUp framePopUpErro;
    private CadastroAlunos cad;
    private Aluno aluno;
    private Disciplina[] disc;
    private int indiceDisc;
    
    public Insercao(CadastroAlunos c, Menu menu)
    {
        indiceDisc = 0;
        disc = new Disciplina[100];
        frameMenu = menu; // Objeto de Menu apenas para mostrar o Menu principal anterior
        cad = c;    // Objeto para cadastrar o aluno no array geral
        configurarJanela();    // Configura a janela de Insercao
    }
    
    private void configurarJanela()
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS));
        
        lblTitulo = new JLabel("Inserir", SwingConstants.CENTER);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblTitulo);
        
        dados = new JPanel();
        dados.setLayout(new GridLayout(6,2));
        
        lblNome = new JLabel("Nome");
        dados.add(lblNome);
        
        txtNome = new JTextField();
        dados.add(txtNome);
        
        lblIdade = new JLabel("Idade");
        dados.add(lblIdade);
        
        boxIdade = new JComboBox();
        boxIdade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));
        dados.add(boxIdade);
        
        lblRG = new JLabel("RG");
        dados.add(lblRG);
        
        txtRG = new JTextField(10);
        dados.add(txtRG);
        
        txtRG.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> formatarRG());
            }
        });
        
        lblRA = new JLabel("RA");
        dados.add(lblRA);
        
        txtRA = new JTextField(8);
        dados.add(txtRA);
        
        txtRA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                SwingUtilities.invokeLater(() -> formatarRA());
            }
        });
        
        lblCurso = new JLabel("Curso");
        dados.add(lblCurso);
        
        boxCurso = new JComboBox();
        boxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ciência da Computação", "Engenharia Civil", "Engenharia Biomédica", "Engenharia de Sist. Ciberfísicos", "Design", "Jogos Digitais" }));
        dados.add(boxCurso);
        
        lblSemestre = new JLabel("Semestre");
        dados.add(lblSemestre);
        
        boxSemestre = new JComboBox();
        boxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        dados.add(boxSemestre);
        
        geral.add(dados);
        
        disciplinas = new JPanel();
        disciplinas.setLayout(new BoxLayout(disciplinas, BoxLayout.Y_AXIS));
        geral.add(disciplinas);
        disciplinas.setVisible(false);
        
        lblDisc = new JLabel("Disciplinas");
        lblDisc.setAlignmentX(Component.CENTER_ALIGNMENT);
        disciplinas.add(lblDisc);
        
        btnAdicionarDisciplina = new JButton("Adicionar Disciplina");
        btnAdicionarDisciplina.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(btnAdicionarDisciplina);
        
        btnAdicionarDisciplina.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAdicionarDisciplinaActionPerformed(evt);
            }
        });
        
        botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setAlignmentX(Component.LEFT_ALIGNMENT);
        botoes.add(btnCancelar);
        
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelarActionPerformed(evt);
            }
        });
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        botoes.add(btnConfirmar);
        
        btnConfirmar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnConfirmarActionPerformed(evt);
            }
        });
        
        framePopUpErro = new PopUp("");
        
        geral.add(botoes);
        add(geral);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(500, 270));
        pack();
        setLocationRelativeTo(null); // Centraliza a janela     
        setResizable(false);
        setVisible(true);
    }
    
    private void btnAdicionarDisciplinaActionPerformed(java.awt.event.ActionEvent evt)
    {                   
        if(frameDisc == null)
        {
            frameDisc = new DisciplinaGUI(Insercao.this);
        }
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        if(frameDisc != null)   // Fecha todas as janelas que foram abertas pela janela de insercao (disciplinas e PopUp)
        {
            frameDisc.fecharPopUp();
            frameDisc.dispose();
        }
        framePopUpErro.dispose();
        dispose();
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        if(verificarInsercao()) // Caso os dados recebidos sejam validos, altera o armazenador original adicionando o aluno
        {
            aluno = new Aluno(txtNome.getText(), Integer.parseInt(boxIdade.getSelectedItem().toString()), txtRG.getText(), txtRA.getText(), boxCurso.getSelectedItem().toString(), disc, Integer.parseInt(boxSemestre.getSelectedItem().toString()));
            cad.inserir(aluno);
            framePopUpErro.dispose();
            frameMenu.setVisible(true);
            frameMenu.setPopUp("Aluno Cadastrado com Sucesso");
            dispose();
            if(frameDisc != null)
            {
                frameDisc.fecharPopUp();
                frameDisc.dispose();
            }
        }
    }
    
    /**
     * Adiciona uma disciplina aos dados do aluno
     *
     * @param n A parameter
     * @param c A parameter
     * @param m A parameter
     */
    public void adicionarDisciplina(String n, String c,float m)
    {
        disc[indiceDisc] = new Disciplina(n, c, m);
        indiceDisc++;   // Atualiza o indice em que será colocada a proxima disciplina
        lblDisc = new JLabel(n);
        disciplinas.add(lblDisc);
        lblDisc.setAlignmentX(Component.CENTER_ALIGNMENT);
        disciplinas.setVisible(true);
        pack();
    }
    
    /**
     * Reinicia a janela de Disciplinas para possibilitar a adicao de apenas uma por vez
     *
     */
    public void resetarDisc()
    {
        frameDisc = null;
    }
    
    /**
     * Verifica se os campos de dados do aluno sao validos
     *
     * @return aprovacao para o cadastro
     */
    public boolean verificarInsercao()
    {
        boolean ok = true;
        
        if(txtNome.getText().trim().equals(""))
        {
            framePopUpErro = new PopUp("Nome Inválido");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        else if(boxIdade.getSelectedItem().equals(""))
        {
            framePopUpErro = new PopUp("Selecione uma idade");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        else if(!formatarRG())
        {
            framePopUpErro = new PopUp("RG Inválido");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        else if(!formatarRA())
        {
            framePopUpErro = new PopUp("RA Inválido");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        else if(boxCurso.getSelectedItem().equals(""))
        {
            framePopUpErro = new PopUp("Selecione um Curso");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        else if(boxSemestre.getSelectedItem().equals(""))
        {
            framePopUpErro = new PopUp("Selecione um Semestre");
            framePopUpErro.setVisible(true);
            ok = false;
        }
        
        return ok;
    }
    
    /**
     * Formata o campo de RA para nao permitir que o usuario digite qualquer coisa
     *
     * @return validacao do RA
     */
    private boolean formatarRA()
    {   
        boolean ok = false;
        try
        {
            String text = txtRA.getText().replaceAll("[^\\d]", ""); // Faz o campo somente aceitar numeros
            
            if (text.length() >= 8)
            { // Verifica se o texto tem mais de 8 caracteres.
            text = text.substring(0, 8); // Se verdadeiro, corta o texto para manter apenas os primeiros 8 caracteres.
            ok = true;
            }
            txtRA.setText(text.toUpperCase());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao formatar RA: " + e.getMessage());
        }
        return ok;
    }
    
    /**
     * Formata o campo de RG para nao permitir que o usuario digite qualquer coisa
     *
     * @return validacao do RG
     */
    private boolean formatarRG()
    {
        boolean ok = false;
        try
        {
            String text = txtRG.getText().replaceAll("[^\\dxX]", "");   //Faz o campo aceitar numeros ou as letras x, X para o ultimo digito
            String formatted = text;
            
            if (text.length() >= 9)
            { // Verifica se o texto tem mais de 9 caracteres.
            text = text.substring(0, 9); // Se verdadeiro, corta o texto para manter apenas os primeiros 9 caracteres.
            ok = true;
            }
            if (text.length() > 2) {
                formatted = text.substring(0, 2) + '.' + text.substring(2);
            }
            if (text.length() > 5) {
                formatted = formatted.substring(0, 6) + '.' + formatted.substring(6);
            }
            if (text.length() > 8) {
                formatted = formatted.substring(0, 10) + '-' + text.substring(8);
            }

            txtRG.setText(formatted.toUpperCase());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao formatar RG: " + e.getMessage());
        }
        return ok;
    }
}
