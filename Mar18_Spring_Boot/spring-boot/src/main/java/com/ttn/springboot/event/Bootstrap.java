package com.ttn.springboot.event;

import com.ttn.springboot.entity.Student;
import com.ttn.springboot.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class Bootstrap {

    Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        logger.info("Bootstrapping students.");
        Iterator<Student> studentIterator = studentRepository.findAll().iterator();
        if (!studentIterator.hasNext()) {
            for (int i = 1; i <= 10; i++) {
                Student student = new Student(i, "Student " + i, i + 20);
                studentRepository.save(student);
                logger.info("Student " + i + " added.");
            }
        }
    }
}
