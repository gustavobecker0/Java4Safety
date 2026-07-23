package app.rules;

public class UrgencyRule extends KeywordRule{

    private static final String[] KEYWORDS = {
            "urgente",
            "minutos",
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
        return "Urgência";
    }

    @Override
    protected String description() {
        return "Essa mensagem contêm termos urgentes.";
    }

    @Override
    protected int weight() {
        return 2;
    }
}
