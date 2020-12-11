package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    private final ArrayList<Resume> storageList = new ArrayList<>();

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    public Resume[] getAll() {
        return storageList.toArray(new Resume[0]);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return storageList.indexOf(resume);
    }

    @Override
    protected Resume getResume(int index) {
        return storageList.get(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storageList.set(index, resume);
    }

    @Override
    protected boolean checkOverFlow() {
        return false;
    }

    @Override
    protected void deleteResume(int index) {
        storageList.remove(index);
        storageList.trimToSize();
    }

    @Override
    protected void insertResume(int index, Resume resume) {
        storageList.add(resume);
    }
}