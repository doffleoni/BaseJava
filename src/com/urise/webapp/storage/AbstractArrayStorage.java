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
    protected Resume getResume(int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void saveResume(int index, Resume resume) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        insertResume(index, resume);
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
    protected void deleteResume(int index) {
        shiftResume(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void shiftResume(int index);

    protected abstract void insertResume(int index, Resume resume);
}