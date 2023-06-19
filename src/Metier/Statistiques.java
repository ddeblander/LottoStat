package Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistiques
{
   private List<Lotto> lInt;
    private Map<Integer, Integer> probas ;
    private int nbMax,lowest=Integer.MAX_VALUE,highest=Integer.MIN_VALUE;
    public Statistiques(List ll)
    {
        lInt=ll;
        probas = new HashMap<>();
    }
    public Map getMapValues()
    {
        initMap();

        for(Lotto l : lInt)
        {
            for(Integer i : l.getListLotto())
            {
                Integer in = probas.get(i);
                Integer value =in.intValue()+1;
                probas.put(i,value);
                nbMax++;
            }
        }

        return probas;
    }
    private void initMap()
    {
        probas = new HashMap<>();
        for(int i = 1 ; i<=45;i++)
        {
            probas.put(i,0);
        }
    }
    public Map getProbability()
    {
        if(probas.isEmpty())
        {
            getMapValues();
        }

        Map<Integer,Integer> proba=probas;
        for (int i=1 ;i<=45;i++)
        {
            int stat=(proba.get(i)).intValue();
            double value =((double)stat/(double)nbMax);
            int valCalc =(int)(value*100.00);
            proba.put(i,valCalc);
            if(lowest>valCalc)
            {
                lowest=valCalc;
            }
            if(highest<valCalc)
            {
                highest=valCalc;
            }

        }
        return proba;
    }
    public List getBestRes()
    {
        Map<Integer,Integer> proba=getProbability();
        System.out.println("proba à : "+highest);
        List<Integer> lBR = new ArrayList<>();
        for (int i=1 ;i<=45;i++)
        {
            int value=proba.get(i);
            if(value==highest)
            {
                lBR.add(i);
            }
        }
        return lBR;

    }
    public List getlowestRes()
    {
        Map<Integer,Integer> proba=getProbability();
        System.out.println("proba à : "+lowest);
        List<Integer> lLR = new ArrayList<>();
        for (int i=1 ;i<=45;i++)
        {
            int value=proba.get(i);
            if(value==lowest)
            {
                lLR.add(i);
            }
        }
        return lLR;
    }
    public List getNumberRes(int nb)
    {
        Map<Integer,Integer> proba=getProbability();
        List<Integer> lLR = new ArrayList<>();
        for (int i=1 ;i<=45;i++)
        {
            int value=proba.get(i);
            if(value==nb)
            {
                lLR.add(i);
            }
        }
        return lLR;
    }
}
