package com.suraj.code.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum SuitColor{
	RED ( 0 ),
	BLACK ( 1 );
	private int value;
	
	private SuitColor ( int value ) {
        this.value = value;
    }
	
	public int retrieveValue () {
        return value;
    }
}

enum SuitType {
    HEART ( 0 ),
    DIAMOND ( 1 ),
    CLUB ( 2 ),
    SPADE ( 3 );

    private int value;

    private SuitType ( int value ) {
        this.value = value;
    }

    public int retrieveValue () {
        return value;
    }
}

enum SuitValue{
	ACE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10),
	JACK (11),
	QUEEN (12),
	KING (13);
	
	private int value;

    private SuitValue ( int value ) {
        this.value = value;
    }

    public int retrieveValue () {
        return value;
    }
}

class Card {
	SuitColor cardColor;
	SuitType cardType;
	SuitValue cardValue;
	
	public SuitColor getCardColor() {
		return cardColor;
	}
	public void setCardColor(SuitColor cardColor) {
		this.cardColor = cardColor;
	}
	public SuitType getCardType() {
		return cardType;
	}
	public void setCardType(SuitType cardType) {
		this.cardType = cardType;
	}
	public SuitValue getCardValue() {
		return cardValue;
	}
	public void setCardValue(SuitValue cardValue) {
		this.cardValue = cardValue;
	}
	public Card() {
		
	}
	public Card(SuitColor cardColor, SuitType cardType, SuitValue cardValue) {
		super();
		this.cardColor = cardColor;
		this.cardType = cardType;
		this.cardValue = cardValue;
	}
	
	@Override
	public String toString() {
		return " [" + cardColor + ", " + cardType + ", " + cardValue + "]";
	}
	
	public static final Comparator<Card> ColorComparator = new Comparator<Card>() {
		
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getCardColor().compareTo(o2.getCardColor());
		}
	};
	
	public static final Comparator<Card> TypeComparator = new Comparator<Card>() {
		
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getCardType().compareTo(o2.getCardType());
		}
	};
	
	public static final Comparator<Card> ValueComparator = new Comparator<Card>() {
		
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getCardValue().compareTo(o2.getCardValue());
		}
	};
	
	public static final Comparator<Card> CardComparator = new Comparator<Card>() {
		
		@Override
		public int compare(Card o1, Card o2) {
			
			 int result = o1.getCardColor().compareTo(o2.getCardColor());
			 if(result == 0) {
				 result = o1.getCardType().compareTo(o2.getCardType());
				 if(result == 0) {
					 result =  o1.getCardType().compareTo(o2.getCardType());
				 }
		     }

		 return result;
		}
	};
}

public class SortThePlayingCard {
	
	// Red, Black
	// Diamond, Heart, Club, Spade
	// KQJ987654321A

	public static void main(String[] args) {
		
		List<Card> listOfCards = new ArrayList<Card>();
		listOfCards.add(new Card(SuitColor.RED, SuitType.DIAMOND, SuitValue.ACE));
		listOfCards.add(new Card(SuitColor.BLACK, SuitType.CLUB, SuitValue.FIVE));
		listOfCards.add(new Card(SuitColor.RED, SuitType.HEART, SuitValue.FOUR));
		listOfCards.add(new Card(SuitColor.BLACK, SuitType.SPADE, SuitValue.THREE));
		listOfCards.add(new Card(SuitColor.BLACK, SuitType.CLUB, SuitValue.TWO));
		listOfCards.add(new Card(SuitColor.RED, SuitType.DIAMOND, SuitValue.JACK));
		System.out.println(listOfCards);
		Collections.sort(listOfCards, Card.ColorComparator);
		System.out.println(listOfCards);
		Collections.sort(listOfCards, Card.TypeComparator);
		System.out.println(listOfCards);
		Collections.sort(listOfCards, Card.ValueComparator);
		System.out.println(listOfCards);
		Collections.sort(listOfCards, Card.CardComparator);
		System.out.println(listOfCards);
	}

}
