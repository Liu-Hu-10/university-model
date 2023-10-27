/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    public String name;
    ArrayList<Department> departments;
    
    public College(String name){
        this.name = name;
        departments = new ArrayList();
    }

    public String getName() {
        return name;
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }

}
