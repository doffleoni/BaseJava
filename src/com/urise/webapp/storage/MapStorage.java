package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storageMap = new HashMap<>();

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storageMap.put((String) searchKey, resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storageMap.remove((String) searchKey);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storageMap.get((String) searchKey);
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[size()]);
    }

    @Override
    public int size() {
        return storageMap.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        if (storageMap.get(uuid) != null) {
            return uuid;
        }
        return null;
    }
}
