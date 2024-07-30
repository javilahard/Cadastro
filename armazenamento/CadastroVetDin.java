package armazenamento;
import aluno.*;

/**
 * Classe para realizar a admnistracao dos alunos atraves de um vetor dinamico
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class CadastroVetDin implements CadastroAlunos, java.io.Serializable
{
    // Atributos
    // array para armazenar qquer objeto
    private Aluno array[]; 
    // quantidade de objetos no vetor
    private int qtd;
    
    /**
     * Constructor for objects of class CadastroVetDin
     */
    public CadastroVetDin()
    {
        setArray(null);
        setQtd(0);   
    }
    
    private Aluno[] getArray()
    {
        return array;
    }
    
    private void setArray(Aluno[] array)
    {
        this.array = array;
    }
    
    private void setQtd(int qtd)
    {
        this.qtd = qtd;
    }
    
    public int getQtd()
    {
        return qtd;
    }
    
    public void inserir(Aluno a0)
    {
        if(array == null)
        { // se for o primeiro elemento          
            setArray(new Aluno[1]);
            array[0] = a0; 
            setQtd(getQtd()+1);
        }
        else
        { // outros elementos
            // cria vetor auxiliar com mais um elemento
            Aluno aux[] = new Aluno[array.length+1];

            // copia todos elementos de vet para aux
            copiar(array, aux);

            // insere elemento novo
            aux[aux.length-1] = a0;

            // Transforma vetor auxiliar no atual
            setArray(aux);

            // incrementa contador de elementos    
            setQtd(getQtd()+1);

        }
    }
    
    public int buscar(String ra)
    {
        
    for(int i = 0; i < getQtd(); i++)
    {
        if((array[i]).RA.equals(ra))
        {
            return i;
        }
    }
    return -1;
    }

    
    public void remover(int i) {
        // Libera elemento da sua posicao
        array[i] = null;

        if(getQtd() > 1){
            // cria vetor auxiliar com mes um elemento
            Aluno aux[] = new Aluno[array.length-1];

            // copia todos elementos de vet para aux
            copiar(array, aux);

            // Transforma vetor auxiliar no atual
            setArray(aux);
            // decrementa contador de elementos    
            setQtd(getQtd() - 1);
        } else {
            // acabou os elementos
            setArray(null);
            // decrementa contador de elementos    
            setQtd(0);
        }
    }
    
    public boolean verificarVazia()
    {
        return (getQtd() == 0 && getArray() == null);
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
        obj = array[i].getAluno();
        return obj;
    }
    
    private void copiar(Object origem[], Object destino[])
    {
        // copia todos
        int i, k = 0;
        for(i = 0; i < origem.length; i++)
        {
            if(origem[i] != null)
            {
                destino[k] = origem[i];
                k++;
            }
        }       
    }
}
