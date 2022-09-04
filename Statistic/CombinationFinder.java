package Statistic;

import java.util.Arrays;
import java.util.List;

public class CombinationFinder {
    private static final String[] allStraights = new String[]{
            "2 3 4 5 Т ",
            "2 3 4 5 6 ",
            "3 4 5 6 7 ",
            "4 5 6 7 8 ",
            "5 6 7 8 9 ",
            "10 6 7 8 9 ",
            "10 7 8 9 В ",
            "10 8 9 В Д ",
            "10 9 В Д К ",
            "10 В Д К Т ",
    };

    public static boolean findPair(List<Card> hand) {
        Card[] cards = hand.toArray(new Card[0]);
        int similarRankCounter = 0;
        String staticRank = "";
        for (int i = 0; i < cards.length - 1; ++i) {
            if (cards[i].getRank().equals(cards[i + 1].getRank())) {
                if (similarRankCounter == 0) staticRank = cards[i].getRank();
                if (!staticRank.equals(cards[i].getRank())) return false;
                similarRankCounter++;
            }
        }
        return similarRankCounter == 1;
    }

    public static boolean findTwoPair(List<Card> hand) {
        Card[] cards = hand.toArray(new Card[0]);
        int similarRankCounter = 0;
        int differentRankCounter = 0;
        String staticRank = "";
        for (int i = 0; i < cards.length - 1; ++i) {
            if (cards[i].getRank().equals(cards[i + 1].getRank())) {
                if (similarRankCounter == 0) {
                    staticRank = cards[i].getRank();
                    differentRankCounter++;
                }
                if (!staticRank.equals(cards[i].getRank())) {
                    staticRank = cards[i].getRank();
                    differentRankCounter++;
                }
                similarRankCounter++;
            }
        }
        return similarRankCounter == 2 && differentRankCounter == 2;
    }

    public static boolean findSet(List<Card> hand) {
        Card[] cards = hand.toArray(new Card[0]);
        int similarRankCounter = 0;
        String staticRank = "";
        for (int i = 0; i < cards.length - 1; ++i) {
            if (cards[i].getRank().equals(cards[i + 1].getRank())) {
                if (similarRankCounter == 0) staticRank = cards[i].getRank();
                if (!staticRank.equals(cards[i].getRank())) return false;
                similarRankCounter++;
            }
        }
        return similarRankCounter == 2;
    }

    public static boolean findStraight(List<Card> hand) {
        StringBuilder rankString = new StringBuilder();
        for (Card card : hand) {
            rankString.append(card.getRank()).append(" ");
        }
        boolean similarSuit = hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit());
        return Arrays.asList(Arrays.copyOf(allStraights, 8)).contains(rankString.toString()) && !similarSuit;
    }

    public static boolean findFlash(List<Card> hand) {
        StringBuilder rankString = new StringBuilder();
        for (Card card : hand) {
            rankString.append(card.getRank()).append(" ");
        }
        boolean similarSuit = hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit());
        return !Arrays.asList(allStraights).contains(rankString.toString()) && similarSuit;
    }


    public static boolean findStraightFlash(List<Card> hand) {
        StringBuilder rankString = new StringBuilder();
        for (Card card : hand) {
            rankString.append(card.getRank()).append(" ");
        }
        boolean similarSuit = hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit());
        return Arrays.asList(Arrays.copyOf(allStraights, 8)).contains(rankString.toString()) && similarSuit;
    }

    public static boolean findFullHouse(List<Card> hand) {
        boolean firstCase = hand.get(0).getRank().equals(hand.get(1).getRank()) && hand.get(1).getRank().equals(hand.get(2).getRank()) && hand.get(3).getRank().equals(hand.get(4).getRank());
        boolean secondCase = hand.get(0).getRank().equals(hand.get(1).getRank()) && hand.get(2).getRank().equals(hand.get(3).getRank()) && hand.get(3).getRank().equals(hand.get(4).getRank());
        return firstCase || secondCase;
    }

    public static boolean findQuads(List<Card> hand) {
        Card[] cards = hand.toArray(new Card[0]);
        int similarRankCounter = 0;
        String staticRank = "";
        for (int i = 0; i < cards.length - 1; ++i) {
            if (cards[i].getRank().equals(cards[i + 1].getRank())) {
                if (similarRankCounter == 0) staticRank = cards[i].getRank();
                if (!staticRank.equals(cards[i].getRank())) return false;
                similarRankCounter++;

            }
        }
        return similarRankCounter == 3;
    }

    public static boolean findRoyalFlesh(List<Card> hand) {
        StringBuilder rankString = new StringBuilder();
        for (Card card : hand) {
            rankString.append(card.getRank()).append(" ");
        }
        boolean similarSuit = hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit());
        return allStraights[9].equals(rankString.toString()) && similarSuit;
    }
}
