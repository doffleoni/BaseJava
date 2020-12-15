package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;

public class MapStorage extends AbstractStorage {
    private final HashMap<String, Resume> storageMap = new HashMap<>();
    private Resume resume = null;

    @Override
    protected int getIndex(String uuid) {
        resume = storageMap.get(uuid);
        if (resume == null) {
            return -1;
        }
        return 1;
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(int index) {
        return resume;
    }

    @Override
    protected void deleteResume(int index) {
        storageMap.remove(resume.getUuid());
    }

    @Override
    protected void saveResume(int index, Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
