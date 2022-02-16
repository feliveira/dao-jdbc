package application;

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
		
		System.out.println("\n=== TEST 2: department findById ===");
		Department dep = departmentDAO.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 3: department update ===");
		dep.setName("Fruits");
		departmentDAO.update(dep);
		System.out.println("Update completed");

		
		
	}
}
