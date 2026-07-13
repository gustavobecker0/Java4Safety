package app.rules;

public class PrizeRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "você ganhou",
            "parabéns",
            "prêmio",
            "sorteio",
            "recompensa"
    };

    @Override
    protected String[] keywords(){
        return KEYWORDS;
    };
}

