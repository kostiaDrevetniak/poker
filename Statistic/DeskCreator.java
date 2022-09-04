package Statistic;

import java.util.ArrayList;
import java.util.List;

public class DeskCreator {
    private static final String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "В", "Д", "К", "Т"};
    private static final String[] suits = new String[]{"Ч", "Д", "П", "Х"};

    public static List<Card> createDesk() {
        ArrayList<Card> desk = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                desk.add(new Card(rank, suit));
            }
        }
        return desk;
    }
}
