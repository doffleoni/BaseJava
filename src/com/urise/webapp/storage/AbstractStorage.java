package com.urise.webapp.storage;


import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        try {
            String s = (String) searchKey;
            if (s != null) {
                throw new ExistStorageException(resume.getUuid());
            } else {
                saveResume(resume.getUuid(), resume);
            }
        } catch (ClassCastException e) {
            if (((int) searchKey) >= 0) {
                throw new ExistStorageException(resume.getUuid());
            }
        }
        saveResume(searchKey, resume);
    }

    @Override
    public void update(Resume resume) {
        updateResume(checkSearchKey(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return getResume(checkSearchKey(uuid));
    }

    @Override
    public void delete(String uuid) {
        deleteResume(checkSearchKey(uuid));
    }

    private Object checkSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        try {
            String s = (String) searchKey;
            if (s == null) {
                throw new NotExistStorageException(uuid);
            }
        } catch (ClassCastException e) {
            if (((int) searchKey) < 0) {
                throw new NotExistStorageException(uuid);
            }
        }
        return searchKey;
    }


    protected abstract Object getSearchKey(String uuid);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract void saveResume(Object searchKey, Resume resume);

}
