package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storageList = new ArrayList<>();

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
    protected void saveResume(int index, Resume resume) {
        storageList.add(resume);
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
    protected void deleteResume(int index) {
        storageList.remove(index);
    }
}

