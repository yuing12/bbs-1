package test4.mvc.controller;

import java.util.Scanner;
import java.util.Vector;

import test4.mvc.dto.Product;
import test4.mvc.service.Service;
import test4.mvc.service.ServiceImpl;

public class ProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service service = new ServiceImpl();
		boolean go = true;
		Product p = null;
		Vector<Product> v = null;
		do {
		
			System.out.println("1. 제품등록 2.제품검색 3.전체검색 4.수정 5.삭제 6.종료");
			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				// 1. insert
				service.addProduct();
				break;

			case 2:
				// 2.select one
				 p =  service.getProduct();
				System.out.println(p);

				break;

			case 3:
				// 3. select all
				v = service.getProducts();
				for (int i = 0; i < v.size(); i++) {
					System.out.println(v.get(i));
				}
				break;

			case 4:
				// 4. Update
				service.editProduct();
				break;

			case 5:
				// 5. delete
				service.delProduct();
				break;

			case 6:
				// 6. finish
				System.out.println("종료되었습니다.");
				go = false;
				break;
			}

		} while (go);
	}

}


// 오류 모음
// 부적합한 열 인덱스 : 오라클에 가는 명령어 체크해보기 ?가 '?'되어있을 수 있음