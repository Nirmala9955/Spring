package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	interface View {
		
	}
	
	interface ResultView1 extends View{
		Integer getCno();
		String getCname();
	}

	//SELECT CNO, CNAME FROM CUSTOMER WHERE CADD =?;
	List<ResultView1> findByCadd(String address);

	interface ResultView2 extends View {
		String getCname();
		Double getBillAmount();
	}

	//SELECT CNO, CNAME FROM CUSTOMER WHERE CNO BETWEEN (?, ?);
	List<ResultView2> findByCnoBetween(int start, int end);
	
	//--------- Dynamic Projections -------------------
	//SELECT CNO, CNAME FROM CUSTOMER WHERE CADD =?;
	//<T> List<T>  findByCadd(String address, Class<T> clazz);
	<T extends View> List<T>  findByCadd(String address, Class<T> clazz);

}	
