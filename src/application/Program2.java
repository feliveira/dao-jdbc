package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
		
		System.out.println("\n=== TEST 1: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDAO.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
		System.out.println("\n=== TEST 2: department insert ===");
		Department dep = new Department(null, "Flowers");
		departmentDAO.insert(dep);
		System.out.println("Done! generated ID = " + dep.getId());
		
		System.out.println("\n=== TEST 3: department findById ===");
		dep = departmentDAO.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 4: department update ===");
		dep.setName("Fruits");
		departmentDAO.update(dep);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: department findAll ===");
		List<Department> depList = new ArrayList<>(departmentDAO.findAll());
		for(Department d : depList) {
			System.out.println(d);
		}
		
	}
}
