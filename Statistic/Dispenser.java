package Statistic;

import java.util.LinkedList;
import java.util.List;

public class Dispenser {
    public static List<Card> dispenseFiveCard(List<Card> desk) {
        List<Card> hand = new LinkedList<>();
        for (int i = 0; i < 5; i++){
            hand.add(desk.remove((int)(Math.random() * desk.size() - 1)));
        }
        desk.addAll(hand);
        return hand;
    }
}
