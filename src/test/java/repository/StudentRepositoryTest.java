package repository;

import com.example.CollegeSystem.entity.Student;
import com.example.CollegeSystem.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest
class StudentRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest(){
        Student s = Student.builder().name("Aziz hamed").email("azizhamed54654@gmail.com").phone("5464564").build();
        studentRepository.save(s);
    }

}