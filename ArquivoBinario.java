package persistencia;
import java.io.*;
import armazenamento.*;

/**
 * Administracao da persistencia dos dados em um arquivo .bin
 *
 * @author Joao Avila, Larissa Hipolito, Priscilla de Souza e Igor Costa
 * @version 22/05/2024
 */
public class ArquivoBinario implements IPersistencia
{
    ObjectOutputStream output = null;
    
    public boolean gravarLista(CadastroAlunos cad, String nomeArq)
    {
        boolean ok = true;
        try
        {
            File file = new File(nomeArq);
            output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(cad);  // escreve o Object no arquivo
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            ok = false;
        }
        finally
        {
            try
            {
                output.close();
            }
            catch(Exception ex)
            {
                // Nao faz nada!
            }
        }
        return ok;
    }
    
    public CadastroAlunos lerLista(String nomeArq)
    {
        CadastroAlunos cad = null;
        ObjectInputStream input = null;
        try
        {
            File file = new File(nomeArq);
            input = new ObjectInputStream(new FileInputStream(file));
            cad = (CadastroAlunos)input.readObject();  // le o cad do arquivo
        }
        catch(Exception e)
        {
            //System.out.println(e.toString());
        }
        finally
        {
            try
            {
                input.close();
            }
            catch(Exception ex)
            {
                // Nao faz nada!
            }
        }
        return cad;
    }

}
