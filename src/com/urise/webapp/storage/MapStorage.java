package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return (mapStorage.containsKey(uuid)) ? uuid : null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        mapStorage.put((String) searchKey, resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        mapStorage.remove(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return mapStorage.get((String) searchKey);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        String[] keys = new String[mapStorage.size()];
        Resume[] resumes = new Resume[mapStorage.size()];
        int index = 0;
        for (Map.Entry<String, Resume> mapEntry : mapStorage.entrySet()) {
            keys[index] = mapEntry.getKey();
            resumes[index] = mapEntry.getValue();
            index++;
        }
        return resumes;
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
