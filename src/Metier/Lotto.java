package Metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lotto
{
    private Date dateTirage;





    private List<Integer> listLotto;

    public Lotto()
    {
        listLotto = new ArrayList<>();
    }
    public boolean addNumber(int nb)
    {
        if((nb>0)&&(nb<46))
        {
            if(listLotto.size()<=6)
            {
                return listLotto.add(nb);
            }

        }
        return false;

    }

    public List<Integer> getListLotto() {
        return listLotto;
    }
    public Date getDateTirage() {
        return dateTirage;
    }
    public void setDateTirage(Date dateTirage) {
        this.dateTirage = dateTirage;
    }
}
