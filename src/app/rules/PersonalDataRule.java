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
}
