package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected void saveResume(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        return storageMap.get(uuid);
    }

    @Override
    protected void deleteResume(String uuid) {
        storageMap.remove(uuid);
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

    @Override
    protected boolean getSearchKey(String uuid) {
        if (storageMap.get(uuid) == null) {
            return false;
        }
        return true;
    }
}

