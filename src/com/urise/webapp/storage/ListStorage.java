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
    protected void saveResume(Object searchKey, Resume resume) {
        storageList.add(resume);
    }


    @Override
    protected Resume getResume(Object searchKey) {
        return storageList.get((int)searchKey);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storageList.set((int)searchKey, resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storageList.remove((int)searchKey);
    }

    @Override
    protected Object getSearchKey (String uuid) {
        Resume resume = new Resume(uuid);
        return storageList.indexOf(resume);
    }

}

