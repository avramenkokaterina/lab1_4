package main.java.avramenko.library;

public class Reader {

    private int idReader;
    private String name;
    private String address;
    private boolean isInBlackList;


    public Reader(int idReader, String name, String address, boolean isInBlackList) {
        this.idReader = idReader;
        this.name = name;
        this.address = address;
        this.isInBlackList = isInBlackList;
    }

    public int getIdReader() {
        return idReader;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInBlackList(boolean inBlackList) {
        isInBlackList = inBlackList;
    }

    @Override
    public String toString(){
        String str1 = String.format("%6s", idReader);
        String str2 = String.format("%25s", name);
        String str3 = String.format("%18s", address);
        return str1 + str2 + str3;
    }
}
