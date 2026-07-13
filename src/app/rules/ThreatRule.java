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
}
