package aluno;

/**
 * Armazena os dados de uma disciplina especifica e transforma isso em uma string
 * 
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Disciplina implements java.io.Serializable
{
    // Variaveis de instancia
    String codDisc;
    Texto nomeDisc;
    float media;
    
    // Construtor
    /**
     * Disciplina Constructor
     *
     * @param codDisc Codigo da disciplina
     * @param nomeDisc Nome da disciplina
     * @param media Media na disciplina
     */
    public Disciplina(String nomeDisc, String codDisc, float media)
    {
        this.codDisc = codDisc;        
        this.nomeDisc = new Texto(nomeDisc);        
        this.media = media;        
    }
    
    /**
     * Method toString
     * 
     * @return Transforma os dados em uma string
     */
    public String toString()
    {
        String s = "\n\tCod disc: " + this.codDisc +
                   "\n\tNome disc: " + this.nomeDisc +
                   "\n\tMedia disc: " + this.media;
        return s;
    }
    
    public String getCodigo()
    {
        return this.codDisc;
    }
}
