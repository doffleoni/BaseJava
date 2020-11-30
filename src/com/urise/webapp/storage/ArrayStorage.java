package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private final Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (resume != null) {
            int index = getIndex(resume.getUuid());
            if (index != -1) {
                storage[index] = resume;
            }
        }
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        if (size != storage.length) {
            if (getIndex(uuid) == -1) {
                storage[size] = resume;
                size++;
                return;
            }
            System.out.println("ERROR: Резуме " + uuid + " уже существует");
            return;
        }
        System.out.println("Хранилище переполнено");
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резуме " + uuid + " не существует");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("Не возможно удалить.Резуме " + uuid + " не существует");
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid))
                return i;
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}