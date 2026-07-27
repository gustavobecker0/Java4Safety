package app.rules;

public class PersonalDataRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "senha",
            "cpf",
            "cartão",
            "código",
            "token",
            "cvv",
            "senha",
            "confirme seus dados"
    };

    @Override
    protected String[] keywords(){
        return KEYWORDS;
    };

    @Override
    protected String name() {
        return "Dados pessoais";
    }

    @Override
    protected String description() {
        return "Essa mensagem pede por dados pessoais.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
