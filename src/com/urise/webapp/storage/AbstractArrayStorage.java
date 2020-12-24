package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected Resume getResume(String uuid) {
        return storage[getIndex(uuid)];
    }

    @Override
    protected void updateResume(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    @Override
    protected void saveResume(Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertResume(getIndex(resume.getUuid()), resume);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected void deleteResume(String uuid) {
        shiftResume(getIndex(uuid));
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        if (getIndex(uuid) < 0) {
            return false;
        }
        return true;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void shiftResume(int index);

    protected abstract void insertResume(int index, Resume resume);
}