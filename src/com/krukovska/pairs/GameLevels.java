package com.krukovska.pairs;

public class GameLevels {

    private static Card[] cardsLevel1 = new Card[]{new Card("cake1.jpg"), new Card("cake2.jpg"),
            new Card("cake1.jpg"), new Card("cake2.jpg")};
    private static Card[] cardsLevel2 = new Card[]{new Card("espresso.jpg"), new Card("kakao.jpg"),
            new Card("latte1.jpg"), new Card("kakao.jpg"), new Card("latte1.jpg"),
            new Card("espresso.jpg")
    };

    private static Card[] cardsLevel3 = new Card[]{new Card("doll1.jpg"), new Card("doll2.jpg"),
            new Card("doll3.jpg"), new Card("doll4.jpg"), new Card("doll1.jpg"),
            new Card("doll2.jpg"), new Card("doll3.jpg"), new Card("doll4.jpg")
    };

    private static Card[] cardsLevel4 = new Card[]{new Card("bieber.jpg"), new Card("vynnyk.jpg"),
            new Card("zibrov.jpg"), new Card("poplavskyi.jpg"), new Card("kirkorov.jpg"),
            new Card("bieber.jpg"), new Card("vynnyk.jpg"),
            new Card("zibrov.jpg"), new Card("poplavskyi.jpg"), new Card("kirkorov.jpg")
    };

    private static Card[] cardsLevel5 = new Card[]{new Card("teteriv.jpg"), new Card("rogan.jpg"),
            new Card("lvivske.jpg"), new Card("zhyguli.jpg"), new Card("chernigivske.jpg"),
            new Card("teteriv.jpg"), new Card("rogan.jpg"), new Card("lvivske.jpg"),
            new Card("zhyguli.jpg"), new Card("chernigivske.jpg"), new Card("opilla.jpg"),
            new Card("opilla.jpg")
    };


    public static Card[][] getLevels() {
        Card[][] levels = new Card[5][];
        levels[0] = cardsLevel1;
        levels[1] = cardsLevel2;
        levels[2] = cardsLevel3;
        levels[3] = cardsLevel4;
        levels[4] = cardsLevel5;
        return levels;
    }
}
