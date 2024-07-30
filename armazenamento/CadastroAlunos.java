package armazenamento;
import aluno.*;
import java.util.ArrayList;

/**
 * Interface para a admnistracao do cadastro dos alunos
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public interface CadastroAlunos
{
    public int getQtd();    // Pega a quantidade de alunos armazenados
    public void inserir(Aluno a0);  // Insere um aluno no armazenador
    public int buscar(String ra);   // Busca um aluno pelo ra no armazenador
    public void remover(int i); // Remove um eemento da lista pelo indice
    public boolean verificarVazia();    // verifica se a lista de alunos esta vazia
    public Object[] getDados(int i);    // Obtem os dados de um aluno especifico da lista
}
