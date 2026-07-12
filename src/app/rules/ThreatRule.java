package app.rules;

public class ThreatRule extends KeywordRule{

    @Override
    protected String[] keywords(){
        return new String[] {
                "conta bloqueada",
                "será bloqueado",
                "último aviso",
                "ação judicial",
                "cancelado"
        };
    }
}
