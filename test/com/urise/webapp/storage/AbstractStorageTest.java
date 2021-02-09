package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String NAME_1 = "Иванов Иван Иванович";
    private static final String NAME_2 = "Алексеев Алексей Алексеевич";
    private static final String NAME_3 = "Петров Иван Алексеевич";
    private static final String NAME_4 = "Толстой Лев Николаевич";
    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1, NAME_1));
        storage.save(new Resume(UUID_2, NAME_2));
        storage.save(new Resume(UUID_3, NAME_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        int sizeBeforeSave = storage.size();
        Resume newResume = new Resume(UUID_4, NAME_4);
        storage.save(newResume);
        Assert.assertEquals(sizeBeforeSave + 1, storage.size());
        Assert.assertEquals(newResume, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() {
        storage.save(new Resume(UUID_1, NAME_1));
    }


    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, NAME_1);
        storage.update(newResume);
        Assert.assertEquals(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Resume r = storage.get(UUID_1);
        Assert.assertNotEquals(null, r);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() {
        List<Resume> actualResumes = storage.getAllSorted();
        List<Resume> expectedResume = new ArrayList<>();
        expectedResume.add(new Resume(UUID_2, NAME_2));
        expectedResume.add(new Resume(UUID_1, NAME_1));
        expectedResume.add(new Resume(UUID_3, NAME_3));

        Assert.assertEquals(3, actualResumes.size());
        Assert.assertEquals(expectedResume, actualResumes);
    }
}