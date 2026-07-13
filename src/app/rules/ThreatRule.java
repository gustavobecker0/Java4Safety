package app.rules;

public class ThreatRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "conta bloqueada",
            "será bloqueado",
            "último aviso",
            "ação judicial",
            "cancelado"
    };

    @Override
    protected String[] keywords(){
        return KEYWORDS;
    };

    @Override
    protected String name() {
        return "Threat";
    }

    @Override
    protected String description() {
        return "The message contains threatning terms.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
