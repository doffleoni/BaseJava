package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (resume != null) {
            if (getIndex(resume) != -1) {
                storage[getIndex(resume)] = resume;
                return;
            }
        }
    }

    public void save(Resume resume) {
        if (size != storage.length) {
            if (getIndex(resume) == -1) {
                storage[size] = resume;
                size++;
                return;
            }
            System.out.println("ERROR: Резуме " + resume.getUuid() + " уже существует");
            return;
        }
        System.out.println("Хранилище переполнено");
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            return storage[getIndex(uuid)];
        }
        System.out.println("Резуме не существует");
        return null;
    }

    public void delete(String uuid) {
        if (getIndex(uuid) != -1) {
            storage[getIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("Не возможно удалить. Резуме не существует");
    }

    private int getIndex(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid()))
                return i;
        }
        return -1;
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