package main.java.avramenko.model;

import main.java.avramenko.library.Reader;

import java.util.Arrays;

public class ReadersStorage implements Storage {
    private Reader[] readers;
    private int length;
    private final int initialLength = 10;
    private int currentLength = 0;

    public ReadersStorage() {
        length = initialLength;
        Reader[] readers = new Reader[length];
    }

    public Reader[] getReaders() {
        return readers;
    }


    public boolean addElement(Reader... readers) {
        if (this.readers != null && readers != null) {
            if (readers.length <= length - currentLength) {
                for (int i = 0; i < readers.length; i++) {
                    this.readers[currentLength] = readers[i];
                    currentLength++;
                }
            } else {
                this.length += readers.length;
                this.readers = Arrays.copyOf(this.readers, length);

                for (int i = 0; i < readers.length; i++) {
                    this.readers[currentLength] = readers[i];
                    currentLength++;
                }
            }return true;
        } else {
            if (this.readers == null && readers != null) {
                this.readers = readers;
                this.length = readers.length;
                this.currentLength = this.length;
            }
            return false;
        }
    }

    @Override
    public boolean deleteElement(int index) {
        if (this.readers != null && index < readers.length) {
            for (int i = index; i < length - 1; i++) {
                readers[i] = readers[i + 1];
                readers[i].setIdReader(i+1);
            }
            readers = Arrays.copyOf(readers, length - 1);
            this.readers = readers;
            this.length = readers.length;
            this.currentLength = this.length;
            return true;
        }
        else if (this.readers != null && index == readers.length){
            readers = Arrays.copyOf(readers, length - 1);
            this.readers = readers;
            this.length = readers.length;
            this.currentLength = this.length;
            return true;
        }
        return false;
    }


    @Override
    public Reader[] createCatalog() {
        Reader[] readers = new Reader[10];
        readers[0] = new Reader(1, "Petro Kovalenko", "Kyiv, Ukraine", false);
        readers[1] = new Reader(2, "Olena Shevchuk", "Kyiv, Ukraine", false);
        readers[2] = new Reader(3, "Mykola Gavrylenko", "Lviv, Ukraine", false);
        readers[3] = new Reader(4, "Maryna Honcharova", "Lviv, Ukraine", false);
        readers[4] = new Reader(5, "Andriy Samoylenko", "Kyiv, Ukraine", false);
        readers[5] = new Reader(6, "Daryna Levchenko", "Kharkiv, Ukraine", false);
        readers[6] = new Reader(7, "Anton Makarov", "Odessa, Ukraine", false);
        readers[7] = new Reader(8, "Oksana Sokunova", "Kharkiv, Ukraine", true);
        readers[8] = new Reader(9, "Serhiy Kravchenko", "Lviv, Ukraine", true);
        readers[9] = new Reader(10, "Iryna Shevchenko", "Lviv, Ukraine", true);

        this.readers = readers;
        this.length = readers.length;
        this.currentLength = readers.length;
        return readers;
    }

    public boolean addToBlackList(int index) {
        boolean checker = this.readers[index-1].isInBlackList();
        if (this.readers != null && index < readers.length) {
            for (int i = 0; i < length; i++) {
                if (i == index-1) {
                    if(checker){
                        return false;
                    }else{
                        readers[index-1].setInBlackList(true);
                        return true;
                    }
                }
            }
            return !checker;
        } else {
            return false;
        }
    }

    public Reader[] createBlackList(){
        Reader[] blackList = new Reader[this.currentLength];
        if (this.readers != null) {
            int counter = 0;
            for (Reader reader: this.readers){
                if (reader.isInBlackList()){
                    blackList[counter] = reader;
                    counter++;
                }
            }
            blackList = Arrays.copyOf(blackList, counter);
            return blackList;
        } else {
            return null;
        }
    }
}
