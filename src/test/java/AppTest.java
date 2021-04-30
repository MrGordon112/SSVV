import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import repository.*;
import service.Service;
import validation.*;

public class AppTest {

    private StudentXMLRepository studentXMLRepository;
    private TemaXMLRepository temaXMLRepository;
    private NotaXMLRepository notaXMLRepository;


    @Test
    public void tc_1student(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

    // BIG BANG INTEGRATION

    @Test
    public void tc_addGrade(){
        Validator<Nota> notaValidator = new NotaValidator();

        notaXMLRepository = new NotaXMLRepository(notaValidator,"notetest.xml");

        assertEquals(notaXMLRepository.findOne(new Pair("1","1")),notaXMLRepository.save(new Nota(new Pair("1","1"),7.88,7,"good feedback")));
    }

    @Test
        public void tc_addStudent(){
        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1"," ",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void tc_addAssignment(){
        Validator<Tema> temaValidator = new TemaValidator();

        temaXMLRepository = new TemaXMLRepository(temaValidator,"temetest.xml");

        Tema tema = new Tema(" ","descr",2,7);

        assertEquals(null,temaXMLRepository.save(tema));
    }

    @Test
    public void tc_addAll(){
        tc_addGrade();
        tc_addAssignment();
        tc_addStudent();
    }

    @Test
    public void integrationTest_1(){
        tc_addStudent();
    }

    @Test
    public void integrationTest_2(){
        tc_addStudent();
        tc_addAssignment();
    }

    @Test
    public void integrationTest_3(){
        tc_addGrade();
        tc_addAssignment();
        tc_addStudent();
    }
}
