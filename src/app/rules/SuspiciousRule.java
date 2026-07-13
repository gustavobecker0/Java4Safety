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
    protected String name() {
        return "Suspicious";
    }

    @Override
    protected String description() {
        return "The message contains Suspicious terms.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
