package com.jdbank;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jdbank.entity.Invoice;
import com.jdbank.repository.InvoiceRepository;
import com.jdbank.service.OnboardingServiceSingleUser;


@SpringBootTest
class OnboardingApplicationTests {
	@MockBean
	private InvoiceRepository accessRepository;
	@Autowired
	OnboardingServiceSingleUser accessService;

	@Test
	void contextLoads() {
	}
	@Test
	public void addInvoiceTest() {
	Invoice resource = new Invoice("name","null", 25,"test@gmail.com","9573631086","blr","CWMPR3887C","5617 3515 3592","1020");
	
	when(accessRepository.save(resource)).thenReturn(resource);

	assertEquals(resource,accessService.addInvoice(resource));

	}
	@Test
	public void getAllSellersTest() {
		
		when(accessRepository.findAll())
			.thenReturn(Stream.of(new Invoice("name","null", 25,"test@gmail.com","9573631086","blr","CWMPR3887C","5617 3515 3592","1020")).collect(Collectors.toList()));
		
				
		assertEquals(1,accessService.getAllSellers().size());
	}

}
