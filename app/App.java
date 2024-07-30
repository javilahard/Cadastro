package app;
import GUI.*;
import armazenamento.*;
import persistencia.*;

/**
 * Classe do metodo principal para rodar o programa
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class App
{
    public static void main(String args[])
    {
        //CadastroAlunos cad = new CadastroArrayList();  // Opcao de armazenamento com o arraylist
        CadastroAlunos cad = new CadastroVetDin();  // Opcao de armazenamento com o vetor dinamico
        IPersistencia arqBin = new ArquivoBinario();    // Gravacao em um arquivo binario
        Menu frameMenu = new Menu(cad, arqBin); // Chama a janela do menu principal que executa o programa
    }
}
