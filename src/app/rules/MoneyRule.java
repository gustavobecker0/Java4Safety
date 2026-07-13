package app.rules;

public class MoneyRule extends KeywordRule {

    private static final String[] KEYWORDS = {
            "pix",
            "pagamento",
            "depósito",
            "transferência",
            "boleto",
            "dinheiro",
            "taxa",
            "multa",
            "prêmio"
    };

    @Override
    protected String[] keywords() {
        return KEYWORDS;
    }

    @Override
    protected String name() {
        return "Money";
    }

    @Override
    protected String description() {
        return "The message contains financial terms.";
    }

    @Override
    protected int weight() {
        return 2;
    }

}