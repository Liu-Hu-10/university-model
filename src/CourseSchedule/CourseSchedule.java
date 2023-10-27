/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public CourseOffer newCourseOffer(String  n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    public void printEachCourseRevenue(){
        System.out.println("Course Revenue:");
        for (CourseOffer c : schedule) {
            System.out.println("-------------------------");
            System.out.println(schedule.indexOf(c) + 1 + ". " + c.getCourseNumber() + " - " + c.getCourseName());
            System.out.println("   The total revenue of the course: " + c.getTotalCourseRevenues() + "$");
        }

    }
    



    public void printEachCourseOffer() {
        System.out.println("---------------------------------");
        System.out.println("Course Information:");
        for (CourseOffer c : schedule) {
            System.out.println("-------------------------");
            System.out.println(schedule.indexOf(c) + 1 + ". " + c.getCourseNumber() + " - " + c.getCourseName());
            System.out.println("   The teacher of the course: " + c.getFacultyProfile().getName());
            System.out.println("   The number of registered students: " + c.getTakenSeats());
            System.out.println("   The number of remaining seats: " + c.getRemainingSeats());
        }
    }
    

}
