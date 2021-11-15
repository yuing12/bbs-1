package test4.mvc.service;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dao.Dao;
import test4.mvc.dao.OracleDao;
import test4.mvc.dto.Product;

public class ServiceImpl implements Service {
	Scanner sc = new Scanner(System.in);

	Dao dao = new OracleDao();

	@Override
	public void addProduct() {// insert
		System.out.print("제품이름 : ");
		String name = sc.next();
		System.out.print("제품가격 :");
		int price = sc.nextInt();

		dao.insert(new Product(0, name, price));
	}

	@Override
	public Product getProduct() {// select one
		System.out.print("검색할 번호 :  ");
		int num = sc.nextInt();
		Product p = dao.select(num);
		return p;
	}

	@Override
	public Vector<Product> getProducts() {// select all
		Vector<Product> v = dao.selectAll();// 주소값
		return v;
	}

	@Override
	public void delProduct() {// delete
		System.out.print("삭제할 제품 번호 : ");
		int num = sc.nextInt();
		dao.delete(num);

	}

	@Override
	public void editProduct() {// update
		System.out.println("수정할 제품번호:");
		int num = sc.nextInt();
		
		Product p = dao.select(num);
		System.out.println(p);
		
		System.out.println("새 제품이름:");
		String name = sc.next();
		
		System.out.println("새 제품가격:");
		int price = sc.nextInt();
		
		p.setName(name);
		p.setPrice(price);

		dao.update(p.getNum(), p);

	}

}
