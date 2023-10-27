/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Transcript;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;
import College.College;

/**
 *
 * @author kal bugrara & Hu Liu
 */
public class UniversityExample {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Create a college
        College college = new College("College of Engineering");
        
        // Create a department
        Department department = new Department("Information Systems");
        
        
        StudentDirectory sd = department.getStudentDirectory();
        PersonDirectory pd = department.getPersonDirectory();
        FacultyDirectory fd = new FacultyDirectory(department);

        // Student side process

        // Create ten students
        Person HuLiuPerson = pd.newPerson("1010", "HuLiu");
        StudentProfile HuLiu = sd.newStudentProfile(HuLiuPerson);

        Person archilPerson = pd.newPerson("0121", "Archil");
        StudentProfile archil = sd.newStudentProfile(archilPerson);

        Person ChrisPerson = pd.newPerson("0122", "Chris");
        StudentProfile Chris = sd.newStudentProfile(ChrisPerson);

        Person LouisPerson = pd.newPerson("0123", "Louis");
        StudentProfile Louis = sd.newStudentProfile(LouisPerson);     

        Person MaithiliPerson = pd.newPerson("0124", "Maithili");
        StudentProfile Maithili = sd.newStudentProfile(MaithiliPerson);

        Person HYZhouPerson = pd.newPerson("0125", "HYZhou");
        StudentProfile HYZhou = sd.newStudentProfile(HYZhouPerson);   

        Person AvisPerson = pd.newPerson("0126", "Avis");
        StudentProfile Avis = sd.newStudentProfile(AvisPerson);

        Person SNZhangPerson = pd.newPerson("0127", "SNZhang");
        StudentProfile SNZhang = sd.newStudentProfile(SNZhangPerson);

        Person ronaldoPerson = pd.newPerson("0128", "ronaldo");
        StudentProfile ronaldo = sd.newStudentProfile(ronaldoPerson);

        Person messiPerson = pd.newPerson("0129", "messi");
        StudentProfile messi = sd.newStudentProfile(messiPerson);

        
        // Course side
        // Create 5 courses
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course info5001 = courseCatalog.newCourse("info5001", "Application Design & Modeling", 4);
        Course info5100 = courseCatalog.newCourse("info5100", "Application Engineering Development", 4);
        Course info5002 = courseCatalog.newCourse("info5002", "Python Introduction", 4);
        Course info6215 = courseCatalog.newCourse("info6215", "Web Design", 4);
        Course info6200 = courseCatalog.newCourse("info6200", "Database Management", 4);
        
        // Create 5 faculty
        Person faculty1Person = pd.newPerson("FacultyID1", "Tommy Shelby");
        FacultyProfile faculty1 = fd.newFacultyProfile(faculty1Person);
        Person faculty2Person = pd.newPerson("FacultyID2", "Thomas Muller");
        FacultyProfile faculty2 = fd.newFacultyProfile(faculty2Person);
        Person faculty3Person = pd.newPerson("FacultyID3", "Arjen Robben");
        FacultyProfile faculty3 = fd.newFacultyProfile(faculty3Person);
        Person faculty4Person = pd.newPerson("FacultyID4", "Philipp Lahm");
        FacultyProfile faculty4 = fd.newFacultyProfile(faculty4Person);
        Person faculty5Person = pd.newPerson("FacultyID5", "Robert Lewandowski");
        FacultyProfile faculty5 = fd.newFacultyProfile(faculty5Person);

 
        //Create a course schedule for Fall 2023 semester
        CourseSchedule isFall2023 = department.newCourseSchedule("Fall2023");
    
        // Create 5 course offers for each course in Fall 2023 semester

        CourseOffer info5001offerFall2023 = isFall2023.newCourseOffer("info5001");
        CourseOffer info5100offerFall2023 = isFall2023.newCourseOffer("info5100");
        CourseOffer info5002offerFall2023 = isFall2023.newCourseOffer("info5002");
        CourseOffer info6215offerFall2023 = isFall2023.newCourseOffer("info6215");
        CourseOffer info6200offerFall2023 = isFall2023.newCourseOffer("info6200");

        //Assign faculties to each course offer
        info5001offerFall2023.AssignAsTeacher(faculty1);
        info5100offerFall2023.AssignAsTeacher(faculty2);
        info5002offerFall2023.AssignAsTeacher(faculty3);
        info6215offerFall2023.AssignAsTeacher(faculty4);
        info6200offerFall2023.AssignAsTeacher(faculty5);


        // Create 25 seats for each course offering:

        info5001offerFall2023.generateSeats(25);
        info5100offerFall2023.generateSeats(25);
        info5002offerFall2023.generateSeats(25);
        info6215offerFall2023.generateSeats(25);
        info6200offerFall2023.generateSeats(25);
        
       

        // Assign grades to students
        Transcript archilsTranscript = archil.getTranscript();
        Transcript ChrisTranscript = Chris.getTranscript();
        Transcript LouisTranscript = Louis.getTranscript();
        Transcript MaithiliTranscript = Maithili.getTranscript();
        Transcript HYZhouTranscript = HYZhou.getTranscript();
        Transcript AvisTranscript = Avis.getTranscript();
        Transcript SNZhangTranscript = SNZhang.getTranscript();
        Transcript ronaldoTranscript = ronaldo.getTranscript();
        Transcript messiTranscript = messi.getTranscript();
        Transcript HuLiuTranscript = HuLiu.getTranscript();

        // Courseloads
        CourseLoad archilsFall2023 = archilsTranscript.newCourseLoad("Fall2023");
        CourseLoad archilsCurrentCourseLoad = archil.getCurrentCourseLoad();
        CourseLoad ChrisFall2023 = ChrisTranscript.newCourseLoad("Fall2023");
        CourseLoad ChrisCurrentCourseLoad = Chris.getCurrentCourseLoad();
        CourseLoad LouisFall2023 = LouisTranscript.newCourseLoad("Fall2023");
        CourseLoad LouisCurrentCourseLoad = Louis.getCurrentCourseLoad();
        CourseLoad MaithiliFall2023 = MaithiliTranscript.newCourseLoad("Fall2023");
        CourseLoad MaithiliCurrentCourseLoad = Maithili.getCurrentCourseLoad();
        CourseLoad HYZhouFall2023 = HYZhouTranscript.newCourseLoad("Fall2023");
        CourseLoad HYZhouCurrentCourseLoad = HYZhou.getCurrentCourseLoad();
        CourseLoad AvisFall2023 = AvisTranscript.newCourseLoad("Fall2023");
        CourseLoad AvisCurrentCourseLoad = Avis.getCurrentCourseLoad();
        CourseLoad SNZhangFall2023 = SNZhangTranscript.newCourseLoad("Fall2023");
        CourseLoad SNZhangCurrentCourseLoad = SNZhang.getCurrentCourseLoad();
        CourseLoad ronaldoFall2023 = ronaldoTranscript.newCourseLoad("Fall2023");
        CourseLoad ronaldoCurrentCourseLoad = ronaldo.getCurrentCourseLoad();
        CourseLoad messiFall2023 = messiTranscript.newCourseLoad("Fall2023");
        CourseLoad messiCurrentCourseLoad = messi.getCurrentCourseLoad();
        CourseLoad HuLiuFall2023 = HuLiuTranscript.newCourseLoad("Fall2023");
        CourseLoad HuLiuCurrentCourseLoad = HuLiu.getCurrentCourseLoad();

         // Register students for 2 courses each
        
        // Archil
        SeatAssignment archilRegisteredForInfo5001inFall2023 = info5001offerFall2023.assignEmptySeat(archil.getCurrentCourseLoad());
        SeatAssignment archilRegisteredForInfo5100 = info5100offerFall2023.assignEmptySeat(archil.getCurrentCourseLoad());
        // Chris
        SeatAssignment ChrisRegisteredForInfo5001inFall2023 = info5001offerFall2023.assignEmptySeat(Chris.getCurrentCourseLoad());
        SeatAssignment ChrisRegisteredForInfo5100 = info5100offerFall2023.assignEmptySeat(Chris.getCurrentCourseLoad());
        // Louis
        SeatAssignment LouisRegisteredForInfo5002inFall2023 = info5002offerFall2023.assignEmptySeat(Louis.getCurrentCourseLoad());
        SeatAssignment LouisRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(Louis.getCurrentCourseLoad());
        // Maithili
        SeatAssignment MaithiliRegisteredForInfo5002inFall2023 = info5002offerFall2023.assignEmptySeat(Maithili.getCurrentCourseLoad());
        SeatAssignment MaithiliRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(Maithili.getCurrentCourseLoad());
        // HYZhou
        SeatAssignment HYZhouRegisteredForInfo5001inFall2023 = info5001offerFall2023.assignEmptySeat(HYZhou.getCurrentCourseLoad());
        SeatAssignment HYZhouRegisteredForInfo5100 = info5100offerFall2023.assignEmptySeat(HYZhou.getCurrentCourseLoad());
        // Avis
        SeatAssignment AvisRegisteredForInfo5002inFall2023 = info5002offerFall2023.assignEmptySeat(Avis.getCurrentCourseLoad());
        SeatAssignment AvisRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(Avis.getCurrentCourseLoad());
        // SNZhang
        SeatAssignment SNZhangRegisteredForInfo50021inFall2023 = info5002offerFall2023.assignEmptySeat(SNZhang.getCurrentCourseLoad());
        SeatAssignment SNZhangRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(SNZhang.getCurrentCourseLoad());
        // ronaldo
        SeatAssignment ronaldoRegisteredForInfo6200inFall2023 = info6200offerFall2023.assignEmptySeat(ronaldo.getCurrentCourseLoad());
        SeatAssignment ronaldoRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(ronaldo.getCurrentCourseLoad());
        // messi
        SeatAssignment messiRegisteredForInfo6200inFall2023 = info6200offerFall2023.assignEmptySeat(messi.getCurrentCourseLoad());
        SeatAssignment messiRegisteredForInfo6215 = info6215offerFall2023.assignEmptySeat(messi.getCurrentCourseLoad());
        // HuLiu
        SeatAssignment HuLiuRegisteredForInfo5100inFall2023 = info5100offerFall2023.assignEmptySeat(HuLiu.getCurrentCourseLoad());
        SeatAssignment HuLiuRegisteredForInfo6200 = info6200offerFall2023.assignEmptySeat(HuLiu.getCurrentCourseLoad());
        
        // Print college name and department name
        System.out.println("College: " + college.getName());
        System.out.println("Department: " + department.getName());


        // Assign grades to students
        archilRegisteredForInfo5001inFall2023.setGrade(3.7f);
        archilRegisteredForInfo5100.setGrade(3.3f);
        ChrisRegisteredForInfo5001inFall2023.setGrade(3.7f);
        ChrisRegisteredForInfo5100.setGrade(3.3f);
        LouisRegisteredForInfo5002inFall2023.setGrade(3.7f);
        LouisRegisteredForInfo6215.setGrade(3.3f);
        MaithiliRegisteredForInfo5002inFall2023.setGrade(3.7f);
        MaithiliRegisteredForInfo6215.setGrade(3.3f);
        HYZhouRegisteredForInfo5001inFall2023.setGrade(3.7f);
        HYZhouRegisteredForInfo5100.setGrade(3.3f);
        AvisRegisteredForInfo5002inFall2023.setGrade(3.7f);
        AvisRegisteredForInfo6215.setGrade(3.3f);
        SNZhangRegisteredForInfo50021inFall2023.setGrade(3.7f);
        SNZhangRegisteredForInfo6215.setGrade(3.3f);
        ronaldoRegisteredForInfo6200inFall2023.setGrade(3.7f);
        ronaldoRegisteredForInfo6215.setGrade(3.3f);
        messiRegisteredForInfo6200inFall2023.setGrade(3.7f);
        messiRegisteredForInfo6215.setGrade(3.3f);
        HuLiuRegisteredForInfo5100inFall2023.setGrade(4.0f);
        HuLiuRegisteredForInfo6200.setGrade(4.0f);

        // Print transcripts
        archil.printTranscript();
        Chris.printTranscript();
        Louis.printTranscript();
        Maithili.printTranscript();
        HYZhou.printTranscript();
        Avis.printTranscript();
        SNZhang.printTranscript();
        ronaldo.printTranscript();
        messi.printTranscript();
        HuLiu.printTranscript();
        
        // Print course schedule
        isFall2023.printEachCourseOffer();
        
        // Implement a method to calculate Department revenue
        isFall2023.printEachCourseRevenue();
        System.out.println("Department revenue: " + department.calculateRevenuesBySemester("Fall2023") + "$");


    }

}
