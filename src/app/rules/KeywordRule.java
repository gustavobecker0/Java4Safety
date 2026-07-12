package app.rules;

public abstract class KeywordRule implements DetectionRule {

    protected abstract String[] keywords();

    @Override
    public boolean detectAny(String message){
        for (String keyword : keywords()) {
            if (message.contains(keyword)) {
                return true;
            }
        }

        return false;
    }

}
