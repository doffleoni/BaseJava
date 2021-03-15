package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {
    // Unique identifier
    private final String uuid;
    private final String fullName;
    private EnumMap<ContactType, String> contacts = new EnumMap<ContactType, String>(ContactType.class);
    private EnumMap<SectionType, Section> sections = new EnumMap<SectionType, Section>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);

    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
        for (SectionType ct : SectionType.values()) {
            if (ct.equals(SectionType.EXPERIENCE) || ct.equals(SectionType.EDUCATION)) {
                sections.put(ct, new ListExpirience());
            } else {
                sections.put(ct, new ListPersonalQualities());
            }
        }
    }


    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }

    public String getContact(ContactType contactType) {
        return contacts.get(contactType);
    }

    public void setContact(ContactType contactType, String value) {
        contacts.put(contactType, value);
    }

    public void printAllContacts() {
        for (ContactType ct : contacts.keySet()) {
            System.out.println(ct.getTitle().toString() + " " + contacts.get(ct));
        }
    }

    public Section getSection(SectionType sectionType) {
        return sections.get(sectionType);
    }

    public void setSection(SectionType sectionType, String value) {
        Section sec = getSection(sectionType);
        sec.setSectionItem(value);
        sections.put(sectionType, sec);
    }

    public void printAllSections() {
        for (SectionType st : sections.keySet()) {
            System.out.println(st.getTitle().toString() + "\n " + sections.get(st).toString());
        }
    }
}