package pl.mazurekit.restfulwebservices;

import java.util.Comparator;

public class DateComper implements Comparator<Repository> {

    @Override
    public int compare(Repository o1, Repository o2) {
        if (o1.getPushedAt().isBefore(o2.getPushedAt())) {
            return 1;
        } else if (o1.getPushedAt().equals(o2.getPushedAt())) {
            return 0;
        } else {
            return -1;
        }

    }
}
