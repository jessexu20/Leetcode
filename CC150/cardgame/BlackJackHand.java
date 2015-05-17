package cardgame;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard> {
	public int score() {
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score : scores) {
			if (score > 21 && score < minOver) {
				minOver = score;
			} else if (score < 21 && score > maxUnder) {
				maxUnder = score;
			}
			else if (score==21) {
				return score;
			}
		}
		return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
	}

	private ArrayList<Integer> possibleScores() {
		ArrayList<Integer> scores = new ArrayList<>();
		if (cards.size() == 0) {
			return scores;
		}
		scores.add(0);
		for (BlackJackCard card : cards) {
			if (!card.isAce()) {
				for (int i = 0; i < scores.size(); i++) {
					scores.set(i, scores.get(i) + card.value());
				}
			} 
			else {
				int len = scores.size();
				for (int i = 0; i < len; i++) {
					scores.add(scores.get(i) + card.maxValue());
					scores.set(i, scores.get(i) + card.minValue());
				}
			}
		}
		return scores;
	}

	public boolean busted() {
		return score() > 21;
	}

	public boolean is21() {
		return score() == 21;
	}

	public boolean isBlackJack() {
		if (!is21())
			return false;
		if (cards.size() != 2)
			return false;
		else
			return true;
	}
}
