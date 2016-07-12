package core;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.*;

import br.ufes.inf.hfilho.isbm.ISBM;
import br.ufes.inf.hfilho.isbm.lowlevel.ConclusionListener;

public class CoffeeBLL {
    
    public String getISBM() throws IOException{
    	/*Executar linha de comando que cria o arquivo
        String aplicativo = "java -jar ISBM.jar -i pipe cafe.isbm > caferesult.txt";
        String[] variaveisAmbiente = null;
        File diretorio = new File("C:\\TRABALHOZE\\isbm\\ISBM");
     
        // disparar aplicativo e obter o processo 
        Process processo = Runtime.getRuntime().exec(aplicativo, variaveisAmbiente, diretorio); 

        // A maioria dos aplicativos ao ser executados pelo Java só funcionam se voce ler o InputStream Deles 
        InputStream is = processo.getInputStream(); 
        byte[] buffer = new byte[4096]; // buffer de 4KB 
        int lidos = -1;
        
        while ((lidos = is.read(buffer, 0, buffer.length)) != -1) { 
            // apresentar conteudo do InputStream lido 
            System.out.print(new String(buffer, 0, lidos)); 
        } 
        */
       
        //instancia um novo JSONObject
        JSONObject cotacoes = new JSONObject();
        JSONObject dia;
        JSONArray dias = new JSONArray();
        JSONArray tipos;
        JSONObject nomes_precos;
       
        String[] nomesCafes = {"Arabica Tipo 6", "Arabica Tipo 7", "Arabica Tipo 8", "Conilon Tipo 7", "Conilon Tipo 8"};
       
        //ler o arquivo txt gerado
        //FileInputStream stream = new FileInputStream("C:\\TRABALHOZE\\isbm\\ISBM\\caferesult.txt");
        FileInputStream stream = new FileInputStream(new File("caferesult.txt"));
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        if (linha.contains("Conclusions")) {
            linha = br.readLine();
        }
       
        while(linha != null) {
           
            tipos = new JSONArray();
           
            String[] colunas = linha.split(";");
            String dia_s = colunas[0].substring(colunas[0].indexOf('>') + 1, colunas[0].length());
           
            for (int i = 1; i < 6; i++) {               
                nomes_precos = new JSONObject();               
                nomes_precos.put("nome",nomesCafes[i-1]);               
                if (colunas[i].equals("-")) {
                        nomes_precos.put("valor",0);
                    } else {
                        nomes_precos.put("valor",Float.parseFloat( colunas[i].replaceAll(",",".") ));
                    }                           
                tipos.put(nomes_precos);               
            }
           
            dia = new JSONObject();
            dia.put("dias",Integer.parseInt(dia_s));
            dia.put("tipos", tipos);
            dias.put(dia);
          
            linha = br.readLine();
        }
       
        cotacoes.put("cotacao",dias);
        
        return cotacoes.toString();
    }
    
    private double Sanitize(String rs)
    {
        double d;
        try {
            d = Double.parseDouble(rs.replace(',', '.'));
        }
        catch (NumberFormatException e) {
            // Use whatever default you like
            d = 0.0;
        }
        return  d;
    }
}
