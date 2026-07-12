package app.rules;

public class MoneyRule extends KeywordRule{

    @Override
    protected String[] keywords(){
        return new String[] {
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
    }
}
