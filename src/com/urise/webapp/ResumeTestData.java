package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume res = new Resume("Dcho Biden");
        res.setContact(ContactType.PHONE, "+7(909)654-54-43");
        res.setContact(ContactType.MAIL, "dch0biden@mail.ru");
        res.setSection(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        res.setSection(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        res.setSection(SectionType.ACHIEVEMENT, "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        res.setSection(SectionType.ACHIEVEMENT, "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        res.setSection(SectionType.ACHIEVEMENT, "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        res.setSection(SectionType.ACHIEVEMENT, "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        res.setSection(SectionType.ACHIEVEMENT, "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        res.setSection(SectionType.ACHIEVEMENT, "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        res.setSection(SectionType.QUALIFICATIONS, "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        res.setSection(SectionType.QUALIFICATIONS, "Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        res.setSection(SectionType.QUALIFICATIONS, "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        res.setSection(SectionType.QUALIFICATIONS, "MySQL, SQLite, MS SQL, HSQLDB");
        res.setSection(SectionType.QUALIFICATIONS, "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        res.setSection(SectionType.QUALIFICATIONS, "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        res.setSection(SectionType.QUALIFICATIONS, "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        res.setSection(SectionType.QUALIFICATIONS, "Python: Django.");
        res.setSection(SectionType.QUALIFICATIONS, "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        res.setSection(SectionType.QUALIFICATIONS, "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        res.setSection(SectionType.QUALIFICATIONS, "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        res.setSection(SectionType.QUALIFICATIONS, "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        res.setSection(SectionType.EXPERIENCE, "Java Online Projects, 2013-10, 2021-03, Автор проекта.\n" +
                "Создание, организация и проведение Java онлайн проектов и стажировок.");
        res.setSection(SectionType.EXPERIENCE, "Wrike,2014-10,2016-01,Старший разработчик (backend)\n" +
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        res.setSection(SectionType.EDUCATION, "Coursera, 2013-03, 2013-05,\"Functional Programming Principles in Scala\" by Martin Odersky");
        res.setSection(SectionType.EDUCATION, "Luxoft, 2011-03, 2011-04, Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        res.setSection(SectionType.EDUCATION, "Siemens AG, 2005-01, 2005-04, 3 месяца обучения мобильным IN сетям (Берлин)");
        System.out.println(res.getFullName());
        res.printAllContacts();
        System.out.println(Stream.generate(() -> "_").limit(50).collect(Collectors.joining()));
        res.printAllSections();

    }
}

