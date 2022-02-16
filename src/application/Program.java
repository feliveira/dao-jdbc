package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDAO.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(1, null);
		List<Seller> sellerList = new ArrayList<Seller>(sellerDAO.findByDepartment(dep));
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		sellerList = sellerDAO.findAll();
		for(Seller obj1 : sellerList) {
			System.out.println(obj1);
		}
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDAO.insert(newSeller);
		System.out.println("Inserted! new Id = "+ newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDAO.findById(9);
		seller.setName("Martha Wayne");
		sellerDAO.update(seller);
		System.out.println("Update Completed");
		
	}

}
