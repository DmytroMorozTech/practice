package com.dima.HashMaps;


import java.util.LinkedList;

public class HashMapMyImplementation {
    public class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    final int size;
    LinkedList<Entry>[] entries;

    public HashMapMyImplementation(int size) {
        this.size = size;
        this.entries = new LinkedList[size];
    }

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        LinkedList<Entry> bucket = getOrCreateBucket(key);
        bucket.add(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<Entry>();

        return entries[index];
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry e : bucket) {
                if (e.key == key)
                    return e;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % size;
    }

}
