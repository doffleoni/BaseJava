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
    protected void saveResume(Resume resume) {
        storageList.add(resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        return storageList.get(getIndex(uuid));
    }

    @Override
    protected void updateResume(Resume resume) {
        storageList.set(getIndex(resume.getUuid()), resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        storageList.remove(getIndex(uuid));
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        if (getIndex(uuid)< 0) {
            return false;
        }
        return true;
    }
    private int getIndex(String uuid){
        return storageList.indexOf(new Resume(uuid));
    }
}

