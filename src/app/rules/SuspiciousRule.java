package app.rules;

public class SuspiciousRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "link",
            "acesse",
            "https",
            "http",
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
        return "Suspeito";
    }

    @Override
    protected String description() {
        return "Essa mensagem contêm termos suspeitos.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
