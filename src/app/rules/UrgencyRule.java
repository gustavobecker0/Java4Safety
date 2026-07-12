package app.rules;

public class UrgencyRule extends KeywordRule{

    @Override
    protected String[] keywords() {
        return new String[] {
                "urgente",
                "imediato",
                "última chance",
                "não perca",
                "responda agora",
                "tempo limitado"
        };
    }
}
