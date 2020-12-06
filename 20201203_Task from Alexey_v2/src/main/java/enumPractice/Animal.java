package enumPractice;

public enum Animal {
    DOG("собака"), CAT("кошка"), FROG("лягушка");
    // if it was a simple Obj and not enum, we would write new DOG("собака")

    private String translation;

    Animal(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
