package Statistic;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<Card> desk = DeskCreator.createDesk();
        int N = 1000000;
        int pairCounter = 0;
        int twoPairCounter = 0;
        int setCounter = 0;
        int straightCounter = 0;
        int flashCounter = 0;
        int fullHouseCounter = 0;
        int quadsCounter = 0;
        int straightFlashCounter = 0;
        int royalFlashCounter = 0;
        for (int i = 1; i <= N; i++) {
            List<Card> cards = Dispenser.dispenseFiveCard(desk);
            cards.sort(Comparator.comparing(Card::getRank));
            if (CombinationFinder.findPair(cards)) pairCounter++;
            else if (CombinationFinder.findTwoPair(cards)) twoPairCounter++;
            else if (CombinationFinder.findSet(cards)) setCounter++;
            else if (CombinationFinder.findStraight(cards)) straightCounter++;
            else if (CombinationFinder.findFlash(cards)) flashCounter++;
            else if (CombinationFinder.findFullHouse(cards)) fullHouseCounter++;
            else if (CombinationFinder.findQuads(cards)) quadsCounter++;
            else if (CombinationFinder.findStraightFlash(cards)) straightFlashCounter++;
            else if (CombinationFinder.findRoyalFlesh(cards)) royalFlashCounter++;

        }
        System.out.println("Pair: " + pairCounter + " " + pairCounter * 100.0 / N);
        System.out.println("Two pair: " + twoPairCounter + " " + twoPairCounter * 100.0 / N);
        System.out.println("Set: " + setCounter + " " + setCounter * 100.0 / N);
        System.out.println("Straight:  " + straightCounter + " " + straightCounter * 100.0 / N);
        System.out.println("Flash :  " + flashCounter + " " + flashCounter * 100.0 / N);
        System.out.println("Full house :  " + fullHouseCounter + " " + fullHouseCounter * 100.0 / N);
        System.out.println("Quads:  " + quadsCounter + " " + quadsCounter * 100.0 / N);
        System.out.println("Straight flash:  " + straightFlashCounter + " " + straightFlashCounter * 100.0 / N);
        System.out.println("Royal flash:  " + royalFlashCounter + " " + royalFlashCounter * 100.0 / N);
        System.out.println(System.currentTimeMillis() - start);
    }
}
