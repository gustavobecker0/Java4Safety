package app.rules;

public class MoneyRule extends KeywordRule{

    private static final String [] KEYWORDS = {
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
    protected String[] keywords(){
        return KEYWORDS;
    };
}
