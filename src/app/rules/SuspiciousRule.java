package app.rules;

public class SuspiciousRule extends KeywordRule{

    @Override
    protected String[] keywords(){
        return new String[] {
                "link",
                "clique",
                "aqui",
                "resgate",
                "resgatar"
        };
    }

}
