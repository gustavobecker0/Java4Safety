package app.rules;

public class UrgencyRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "urgente",
            "imediato",
            "última chance",
            "não perca",
            "responda agora",
            "tempo limitado"
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
