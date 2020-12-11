package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected ArrayList<Resume> storageList = new ArrayList<>();

    @Override
    public void clear() {
        storageList.removeAll(storageList);
    }

    @Override
    public void update(Resume resume) {
        int index = storageList.indexOf(resume);
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storageList.set(index, resume);
    }

    @Override
    public void save(Resume resume) {
        int index = storageList.indexOf(resume);
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        storageList.add(resume);
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    public Resume[] getAll() {
        return storageList.toArray(new Resume[storageList.size()]);
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
    protected void delResume(int index) {
        storageList.remove(index);
        storageList.trimToSize();
    }

    @Override
    protected void decreaseSize() {
    }
}