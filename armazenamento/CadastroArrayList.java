package armazenamento;
import aluno.*;
import java.util.ArrayList;

/**
 * Classe para realizar a admnistracao dos alunos atraves de um arrayList
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class CadastroArrayList implements CadastroAlunos, java.io.Serializable
{
    private ArrayList <Aluno> lista;
    
    public CadastroArrayList()
    {
        setLista(new <Aluno>ArrayList());
    }
    
    private void setLista(ArrayList <Aluno>lista)
    {
        this.lista = lista;
    }
    
    private ArrayList <Aluno> getLista()
    {
        return lista;
    }
    
    public int getQtd()
    {
        return lista.size();
    }
    
    public void inserir(Aluno a0)
    {
        lista.add(a0);
    }
    
    public int buscar(String ra)
    {
        for(int i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).RA.equals(ra))
            {
                return i;
            }
        }
        return -1;
    }
    
    public void remover(int i)
    {
        lista.remove(i);
    }
    
    public boolean verificarVazia()
    {
        return (lista.isEmpty());
    }
    
    public String toString()
    {
        String s = "[ ";
        for (int i = 0; i < lista.size(); i++)
        {
            s += lista.get(i).toString() + " ";
        }
        s = s + "]";
        return s;
    }
    
    /**
     * Pega os dados de um aluno e manda-os para a tabela de listagem
     *
     * @param i A parameter
     * @return The return value
     */
    public Object[] getDados(int i)
    {
        Object[] obj = new Object[7];
        obj = lista.get(i).getAluno();
        return obj;
    }

}
