package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    ArrayList<Tables> sort=new ArrayList<>();
    public ArrayList<Tables> sorting(ArrayList<Tables> tables) {
        sort=tables;
        Collections.sort(sort, new Comparator<Tables>() {
            @Override
            public int compare(Tables tables, Tables t1) {
                int x= Integer.compare(tables.getNumberOfSeats(),t1.getNumberOfSeats());
                if(x==0)
                    return Float.compare(tables.getNumberOfSeats(),t1.getNumberOfSeats());
                else
                    return x;
            }

        });
        return sort;
    }
}
