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

    @Override
    protected String name() {
        return "Prize";
    }

    @Override
    protected String description() {
        return "The message contains prize offerings.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}

