package app.rules;

public class MoneyRule extends KeywordRule {

    private static final String[] KEYWORDS = {
            "pix",
            "conta",
            "bancária",
            "pagamento",
            "depósito",
            "transferência",
            "boleto",
            "dinheiro",
            "taxa",
            "multa",
            "prêmio",
            "R$",
            "emprestar"
    };

    @Override
    protected String[] keywords() {
        return KEYWORDS;
    }

    @Override
    protected String name() {
        return "Financeiro";
    }

    @Override
    protected String description() {
        return "Essa semana contêm termos financeiros.";
    }

    @Override
    protected int weight() {
        return 2;
    }

}