package Model;

import Metier.Lotto;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadLottoFromCSV
{
    private List<Lotto> ll;

    public ReadLottoFromCSV()
    {
        ll= new ArrayList<>();
    }
    public List<Lotto> readFile() {
        if(!ll.isEmpty())
        {
            ll= new ArrayList<>();
        }
        try{
            String ligne="";
            BufferedReader br = new BufferedReader(new FileReader("F:\\Lotto\\lotto-gamedata-04-2023.csv"));
            br.readLine();
            while ((ligne = br.readLine()) != null)
            {
                Lotto lt = new Lotto();
                // Retourner la ligne dans un tableau
                String[] data = ligne.split(",");
                lt.setDateTirage(new SimpleDateFormat("yyyy-MM-dd").parse(data[0]));
                for(int i=1;i<=7;i++)
                {
                    lt.addNumber(Integer.parseInt(data[i]));
                }
                ll.add(lt);
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);

        }


        return ll;
    }
}
