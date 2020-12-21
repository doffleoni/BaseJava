package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storageMap = new HashMap<>();
    private Resume resume = null;

    @Override
    protected void saveResume(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume() {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume() {
        return resume;
    }

    @Override
    protected void deleteResume() {
        storageMap.remove(resume.getUuid());
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
        resume = storageMap.get(uuid);
        if (resume == null) {
            return false;
        }
        return true;
    }
}

