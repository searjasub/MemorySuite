package edu.neumont.csc150.model.scores;

import java.io.Serializable;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Score>, Serializable {
    @Override
    public int compare(Score score1, Score score2) {
        int sc1 = score1.getScore();
        int sc2 = score2.getScore();
        return Integer.compare(sc2, sc1);
    }
}
