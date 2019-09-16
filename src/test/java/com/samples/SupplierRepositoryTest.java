package com.samples;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierRepositoryTest {

	@Autowired
	private SupplierRepository supplierRepository;
	public static final String SUPPLIER_NUMBER = "1234";

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired

	@Before
	public void removeSupplier1234() {
		this.supplierRepository.deleteByNumber(SUPPLIER_NUMBER);
	}

	@Test
	public void shouldSaveAndRetrieveSupplier() {
		Supplier newSupplier = new Supplier(SUPPLIER_NUMBER, "ACME");
		Address address = new Address("Serangoon avenue 2", "556135", "Singapore");
		newSupplier.setAddress(address);

		Invoice invoice = new Invoice("001", 200);
		this.invoiceRepository.save(invoice);

		newSupplier.setInvoice(invoice);
		this.supplierRepository.save(newSupplier);

		Supplier retrievedSupplier = this.supplierRepository.findByNumber(SUPPLIER_NUMBER);
		Assertions.assertThat(retrievedSupplier.getName()).isEqualTo("ACME");
	}

}
