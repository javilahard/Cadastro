package GUI;

/**
 * Classe para configurar os numeros digitados pelo usuario
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class Utils implements java.io.Serializable
{
    public static int isNumeric(String str)
    {
        if (str == null || str.length() == 0)
        { //string vazia
            return 0;
        }
        
        boolean foundDecimal = false; //variavel booleana que verifica se e decimal
        for (char c : str.toCharArray())
        { // percorre a string
            if (!Character.isDigit(c))
            { // verifica se e digito
                if (c == '.' && !foundDecimal)
                { // verifica se existe um unico ponto
                    foundDecimal = true;
                }
                else
                { //nao e um numero
                    return 0;
                }
            }
        }   
        
        if(foundDecimal)
        {
            return 2;
        }//numero decimal positivo, retorna 2
        else
        {
            return 1;
        }//numero inteiro positivo, retorna 1
    }
}
