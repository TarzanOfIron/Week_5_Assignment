package Sequencers;

public class PersonalIdSequencer {

    static int currentId;

    public static int nextId() {
        return currentId++;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonalIdSequencer.currentId = currentId;
    }

}
