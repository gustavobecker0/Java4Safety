package app.rules;

public class PrizeRule extends KeywordRule{

    @Override
    protected String[] keywords(){
        return new String[] {
                "você ganhou",
                "parabéns",
                "prêmio",
                "sorteio",
                "recompensa"
        };
    }

}
