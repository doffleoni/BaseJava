package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, resume);
    }

    @Override
    protected void instResume(int index, Resume resume) {
        index = -index - 1;
        for (int i = size; i > index; i--) {
            storage[i] = storage[i - 1];
        }
        storage[index] = resume;
        size++;
    }

    @Override
    protected void delResume(int index) {
        for (int i = index; i < size; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
    }
}
