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
    public void tc_2students(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));
        studentXMLRepository.save(new Student("2","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());
        assertEquals("2",studentXMLRepository.findOne("2").getID());

    }

    @Test
    public void tc_1student(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

    @Test
    public void tc_1(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","Wayne",937));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

    @Test
    public void tc_2(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("100","Wayne",937));
        studentXMLRepository.save(new Student("100","Bruce",937));

        assertEquals("Wayne",studentXMLRepository.findOne("100").getNume());
    }

    @Test
    public void tc_3(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("","Wayne",937)));
    }

    @Test
    public void tc_4(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",937)));
    }

    @Test
    public void tc_5(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",-1)));
    }

    @Test
    public void tc_6(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",-1)));
    }


    @Test
    public void bva_2(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student(" ","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_3(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("a","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_4(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("111","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_5(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("a1b2c3","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_6(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("z","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_7(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","",937);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_8(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1"," ",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_9(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_10(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","1",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_11(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a1b2c3",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_12(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","z",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_13(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",-1);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_14(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",0);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_15(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a1b2c3",1);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_16(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne", Integer.MAX_VALUE);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_17(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",Integer.MIN_VALUE);

        assertEquals(null,studentXMLRepository.save(student));
    }


    // WHITE BOX TESTING

    @Test
    public void wb_1(){

        Validator<Tema> temaValidator = new TemaValidator();

        temaXMLRepository = new TemaXMLRepository(temaValidator,"temetest.xml");

        Tema tema = new Tema("1","descr",8,7);

        assertEquals(tema,temaXMLRepository.save(tema));
    }

    @Test
    public void wb_2(){

        Validator<Tema> temaValidator = new TemaValidator();

        temaXMLRepository = new TemaXMLRepository(temaValidator,"temetest.xml");

        Tema tema = new Tema("1","descr",2,7);

        assertEquals(null,temaXMLRepository.save(tema));
    }

    @Test
    public void wb_3(){

        Validator<Tema> temaValidator = new TemaValidator();

        temaXMLRepository = new TemaXMLRepository(temaValidator,"temetest.xml");

        Tema tema = new Tema(null,"descr",2,7);

        assertEquals(null,temaXMLRepository.save(tema));
    }

    @Test
    public void wb_4(){

        Validator<Tema> temaValidator = new TemaValidator();

        temaXMLRepository = new TemaXMLRepository(temaValidator,"temetest.xml");

        Tema tema = new Tema(" ","descr",2,7);

        assertEquals(null,temaXMLRepository.save(tema));
    }

    @Test(expected = ValidationException.class)
    public void wb_5(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",2,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_6(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",-7,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_7(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",15,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_8(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",2,-2);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_9(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",2,17);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_10(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","descr",2,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_11(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1","",2,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_12(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("1",null,2,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_13(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema("","descr",2,7);

        temaValidator.validate(tema);
    }

    @Test(expected = ValidationException.class)
    public void wb_14(){

        Validator<Tema> temaValidator = new TemaValidator();

        Tema tema = new Tema(null,"descr",2,7);

        temaValidator.validate(tema);
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
