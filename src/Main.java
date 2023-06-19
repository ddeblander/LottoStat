import Metier.Lotto;
import Metier.Statistiques;
import Model.ReadLottoFromCSV;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        ReadLottoFromCSV re = new ReadLottoFromCSV();
        List<Lotto> ll = re.readFile();




        List<String> loptions = Arrays.asList("Liste tirage","Liste de tirage par num","Proba par nombre","série avec le plus de proba","série avec le plus bas de proba","série avec choix","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: listTirage(ll);
                    break;
                case 2: probaNB(ll);
                    break;
                case 3: probaPercent(ll);
                    break;
                case 4: highestSerie(ll);
                    break;
                case 5: lowestSerie(ll);
                    break;
                case 6: serie(ll);
                    break;

                case 7 : System.exit(0);
            }
        }while(true);
    }
    public static void listTirage(List<Lotto> list)
    {
        for (Lotto l : list)
        {
            //System.out.println(l.getDateTirage());
            System.out.println(l.getListLotto());
        }
    }
    public static void probaNB(List<Lotto> list)
    {
        Statistiques stat = new Statistiques(list);
        Map map= stat.getMapValues();
        for (int i=1;i<=45;i++)
        {
            System.out.print("nombre de sortie par numéro : "+i +" = ");
            System.out.println(map.get(i));
        }
    }
    public static void probaPercent(List<Lotto> list)
    {
        Statistiques stat = new Statistiques(list);
        Map map= stat.getProbability();
        for (int i=1;i<=45;i++)
        {
            System.out.print("proba du numéro : "+i +" = ");
            System.out.println(map.get(i)+" %");
        }
    }
    public static void lowestSerie(List<Lotto> list)
    {
        Statistiques stat = new Statistiques(list);
        Utilitaire.affListe(stat.getlowestRes());
    }
    public static void highestSerie(List<Lotto> list)
    {
        Statistiques stat = new Statistiques(list);
        Utilitaire.affListe(stat.getBestRes());
    }
    public static void serie(List<Lotto> list)
    {
        Scanner sc = new Scanner(System.in);
        Statistiques stat = new Statistiques(list);
        int choix= sc.nextInt();
        Utilitaire.affListe(stat.getNumberRes(choix));
    }
}