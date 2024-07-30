package aluno;

/**
 * Armazena os dados especificos de um aluno alem dos de Pessoa
 * 
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Aluno extends Pessoa implements java.io.Serializable
{
    // Atributos do aluno    
    public String RG, RA, curso;
    Disciplina disciplinas[];
    int semestre;
    
    // Construtor
    public Aluno(String nome, int idade, String rg, String ra, String curso, Disciplina disc[], int semestre)
    {
        super(nome, idade, rg); // Aciona o construtor da classe pai (Pessoa)
        RG = rg;
        RA = ra;
        this.curso = curso;
        disciplinas = disc;
        this.semestre = semestre;
    }
    
    public String toString(){
        String s =  "Aluno: " + nome +
                    "\nIdade: " + idade +
                    "\nRg: " + RG +
                    "\nRa: " + RA +
                    "\nCurso: " + curso +
                    "\nSemestre: " + semestre + "º\n";
        if (disciplinas.length != 0)
        {
            s += "\nDisciplinas: ";
            for (int i = 0; i < disciplinas.length; i++)
            {
                s += disciplinas[i].toString();
            }
        }
        return s;
    }
    
    /**
     * Busca um aluno pelo RA para verificar se ele esta na lista
     *
     * @param ra A parameter
     * @param qtdAlunos A parameter
     * @return The return value
     */
    public int procurarAluno(String ra, Aluno qtdAlunos[])
    { // busca RA na lista de alunos
        int pos = -1;
        for (int i = 0; i < qtdAlunos.length; i++)
        {
            if (qtdAlunos[i] != null && qtdAlunos[i].RA.equals(ra))
            {
                pos = i; // aluno na lista
            }
        }
        return pos; // se -1, aluno nao presente na lista
    }
    
    /**
     * Method getAluno
     *
     * @return Dados do aluno para mandar para o armazenador
     */
    public Object[] getAluno()
    {
        Object[] obj = new Object[]{nome, idade, RG, RA, curso, semestre, getDisciplinas()};
        return obj;
    }
    
    /**
     * Method getDisciplinas
     *
     * @return Codigo das disciplinas para mostrar na tabela
     */
    public String getDisciplinas()
    {
        String s = "";
        for(int i = 0; i < getQtdeDisc(); i++)
        {
            s = s + disciplinas[i].getCodigo() + " | ";    
        }
        return s;
    }
    
    /**
     * Method getQtdeDisc
     *
     * @return Quantidade de disciplinas no vetor
     */
    private int getQtdeDisc()
    {
        int i = 0;
        while(disciplinas[i] != null)
        {
            i++;
        }
        return i;    
    }
}
