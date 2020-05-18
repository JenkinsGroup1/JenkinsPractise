package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.InvoiceDTO;
import com.example.exception.DuplicateResourceException;
import com.example.exception.NoResourceFoundException;
import com.example.repository.InvoiceRepository;
import com.example.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	public InvoiceDTO insert(InvoiceDTO invoice) throws Exception {
		
		if(invoiceRepository.findById(invoice.getId()).isEmpty()) 
		{
			return  invoiceRepository.saveAndFlush(invoice);
			
		}
		else 
		{
			throw new DuplicateResourceException("Invoice with id " + invoice.getId() + " already exists");
		}
		
	}

	@Override
	public InvoiceDTO fetch(Long id) throws Exception {
		
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new NoResourceFoundException("Invoice with id: " + id + " is not found"));
		
	}

}
