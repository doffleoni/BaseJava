package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        if (getSearchKey(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(resume);
    }

    @Override
    public void update(Resume resume) {
        checkSearchKey(resume.getUuid());
        updateResume();
    }

    @Override
    public Resume get(String uuid) {
        checkSearchKey(uuid);
        return getResume();
    }

    @Override
    public void delete(String uuid) {
        checkSearchKey(uuid);
        deleteResume();
    }

    private void checkSearchKey(String uuid) {
        if (!getSearchKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract boolean getSearchKey(String uuid);

    protected abstract void updateResume();

    protected abstract Resume getResume();

    protected abstract void deleteResume();

    protected abstract void saveResume(Resume resume);
}