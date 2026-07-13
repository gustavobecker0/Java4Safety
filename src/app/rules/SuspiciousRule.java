package app.rules;

public class SuspiciousRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "link",
            "clique",
            "aqui",
            "resgate",
            "resgatar"
    };

    @Override
    protected String[] keywords(){
        return KEYWORDS;
    };

    @Override
    protected int weight(){
        return 10;
    };
}
