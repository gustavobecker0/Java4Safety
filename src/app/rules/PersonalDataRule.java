package app.rules;

public class PersonalDataRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "senha",
            "cpf",
            "cartão",
            "código",
            "token",
            "cvv",
            "confirme seus dados"
    };

    @Override
    protected String[] keywords(){
        return KEYWORDS;
    };

    @Override
    protected String name() {
        return "Personal Data";
    }

    @Override
    protected String description() {
        return "The message asks for data info.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
