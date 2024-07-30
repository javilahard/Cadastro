package persistencia;
import armazenamento.*;

/**
 * Interface para a persistencia dos dados dos alunos
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public interface IPersistencia
{
    public boolean gravarLista(CadastroAlunos cad, String nomeArq); // Grava a lista de alunos em um arquivo
    public CadastroAlunos lerLista(String nomeArq); // Le a lista de alunos atraves de um arquivo
}
