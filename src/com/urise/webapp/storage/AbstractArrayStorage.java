package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        if (size == STORAGE_LIMIT) {
            System.out.println("Хранилище переполнено");
            return;
        }
        if (size == 0) {
            storage[size] = resume;
            size++;
            return;
        }
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        if (index > 0) {
            System.out.println("ERROR: Резуме " + uuid + " уже существует");
            return;
        }
        instResume(index, resume);

    }

    @Override
    public void update(Resume resume) {
        if (resume != null) {
            int index = getIndex(resume.getUuid());
            storage[index] = resume;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Не возможно удалить.Резуме " + uuid + " не существует");
            return;
        }
        delResume(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резуме " + uuid + " не существует");
        return null;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void instResume(int index, Resume resume);//template for save

    protected abstract void delResume(int index);//template for delete
}
