package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUUIDStorage extends AbstractStorage {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return mapStorage.containsKey(uuid) ? uuid : null;
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
        String sKey = (String) searchKey; // сделал, что бы убрать "suspicious call to mapStorage.remove"
        mapStorage.remove(sKey);
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    protected Resume doGet(Object searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
