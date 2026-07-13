package app.rules;

public abstract class KeywordRule implements DetectionRule {

    protected abstract String[] keywords();

    protected abstract int weight();

    @Override
    public int scoreMessage(String message){
        for (String keyword : keywords()) {
            if (message.contains(keyword)) {
                return weight();
            }
        }

        return 0;
    }

}
