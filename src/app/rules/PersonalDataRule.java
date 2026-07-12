package app.rules;

public class PersonalDataRule extends KeywordRule{

    @Override
    protected String[] keywords(){
        return new String[] {
                "senha",
                "cpf",
                "cartão",
                "código",
                "token",
                "cvv",
                "confirme seus dados"
        };
    }


}
