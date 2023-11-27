package com.example.CollegeSystem.serializer;


import com.example.CollegeSystem.document.Student;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class WaitingCourseQueue {

    private int i = 0;

    private Set<String> waitingQueue = new HashSet<>();

    public void offer(String studentId){
        if(!waitingQueue.contains(studentId))
         waitingQueue.add(studentId);
    }

    public String poll(){
        String studentId = waitingQueue.stream().findFirst().get();
        waitingQueue.remove(studentId);
        return studentId;
    }

    public void delete(String studentId){
        waitingQueue.remove(studentId);
    }

    public boolean contains(String studentId){
        return waitingQueue.contains(studentId);
    }

    public int size(){
        return waitingQueue.size();
    }
}
