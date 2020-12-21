package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> storageList = new ArrayList<>();
    private int index = 0;
    private Resume resume = null;

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
    protected void saveResume(Resume resume) {
        storageList.add(resume);
    }

    @Override
    protected Resume getResume() {
        return storageList.get(index);
    }

    @Override
    protected void updateResume() {
        storageList.set(index, resume);
    }

    @Override
    protected void deleteResume() {
        storageList.remove(index);
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        resume = new Resume(uuid);
        index = storageList.indexOf(resume);
        if (index < 0) {
            return false;
        }
        return true;
    }
}

