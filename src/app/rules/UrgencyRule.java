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
    protected String name() {
        return "Urgency";
    }

    @Override
    protected String description() {
        return "The message contains urgency terms.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
