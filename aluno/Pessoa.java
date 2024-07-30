package aluno;


/**
 * Classe para armazenar os dados de uma pessoa
 * 
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Pessoa implements java.io.Serializable
{
    NomePessoa nome;
    int idade;
    String id;
    
    Pessoa(String nome, int idade, String rg)
    {
        this.nome = new NomePessoa(nome);
        this.idade = idade;
        id = rg;
    }
    
}
