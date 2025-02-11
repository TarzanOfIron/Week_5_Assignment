package Sequencers;

public class TodoItemSequencer {

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
