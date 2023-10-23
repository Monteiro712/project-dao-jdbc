package application;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("test 1 - findbyid");
		Seller sel = sellerdao.findById(3);
		System.out.println(sel);
		
		
		System.out.println("\ntest 2 - findbydepartment");
		Department dep = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(dep);
		for (Seller finddep : list) {
			System.out.println(finddep);
		}
		
		System.out.println("\ntest 3 - findall");
		list = sellerdao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(9, "jon", "ary", new java.util.Date(), 5000, dep);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println("\n=== TEST 5: seller update =====");
		sel = sellerdao.findById(1);
		sel.setName("Martha Waine");
		sellerdao.update(sel);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed");
	}

}
