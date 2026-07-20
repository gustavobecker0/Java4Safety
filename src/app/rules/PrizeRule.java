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
        return "Prêmio";
    }

    @Override
    protected String description() {
        return "Essa mensagem está oferencendo prêmios.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}

