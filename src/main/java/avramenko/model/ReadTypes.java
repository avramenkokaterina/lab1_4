package main.java.avramenko.model;

public enum ReadTypes {
    SUBSCRIPTION("READ AT HOME"),
    READING_ROOM("READ IN LIBRARIES ROOM");
    private String type;
    ReadTypes(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}
