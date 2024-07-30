package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import armazenamento.CadastroAlunos;
import javax.swing.table.DefaultTableModel;

/**
 * Janela para mostrar os dados dos aluno no armazenamento
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Listagem extends JFrame implements java.io.Serializable
{
    private JPanel geral;
    private JScrollPane scroll;
    private JLabel lblTitulo;
    private JButton btnOk;
    private DefaultTableModel model;
    private JTable tabAlunos;
    private Menu frameMenu;
    private CadastroAlunos cad;
    
    public Listagem(CadastroAlunos c, Menu menu)
    {
        cad = c;
        frameMenu = menu;
        configurarJanela();
    }
    
    private void configurarJanela()
    {
        geral = new JPanel();
        geral.setLayout(new BoxLayout(geral, BoxLayout.Y_AXIS));

        lblTitulo = new JLabel("Lista de Alunos", SwingConstants.CENTER);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        geral.add(lblTitulo);

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Idade");
        model.addColumn("RG");
        model.addColumn("RA");
        model.addColumn("Curso");
        model.addColumn("Semestre");
        model.addColumn("Disciplinas");
        adicionarDados();
        tabAlunos = new JTable(model);
        scroll = new JScrollPane(tabAlunos);    // Painel para adicionar a tabela
        geral.add(scroll);
        
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
        pack();
        setSize(800, 500);
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt)
    {                                           
        frameMenu.setVisible(true);
        dispose();
    }
    
    /**
     * Preenche os campos da tabela com os dados de cada aluno
     *
     */
    private void adicionarDados()
    {
        Object[] dados = new Object[7];
        
        for(int i = 0; i < cad.getQtd(); i++)
        {
            dados = cad.getDados(i);
            model.addRow(dados);
        }
    }

}
