package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.dto.InvoiceDTO;
import com.example.serviceimpl.InvoiceServiceImpl;
//THis is rest controller demo for jenkins again again
@RestController


public class InvoiceController {

	@Autowired
	private InvoiceServiceImpl invService;

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/invoices/{customerId}/{orderId}")
	public ResponseEntity createInvoice(@PathVariable("orderId")Long orderId,@PathVariable("customerId")Long customerId,@RequestBody InvoiceDTO invoiceDTO) throws Exception
	{
		String response = "";
		
		
		final String uri = "http://SalesAPI"+"/users/"+customerId+"/orders/"+orderId;
		System.out.println(uri);
		
			restTemplate.getInterceptors().add(
					  new BasicAuthorizationInterceptor("admin", "admin"));
			ResponseEntity<Object> response1 = restTemplate.getForEntity(uri, Object.class);
			InvoiceDTO invDTO = new InvoiceDTO();
			invDTO.setId(invoiceDTO.getId());
			invDTO.setOrderId(orderId);
			System.out.println(response1.toString());
			InvoiceDTO invoiceDTO1 = invService.insert(invDTO);
			return ResponseEntity.ok(invoiceDTO1);
		
	}
	
	@GetMapping("/invoices/{id}")
	public InvoiceDTO fetchInvoice(@PathVariable("id")Long id) throws Exception
	{
		
		if(id.equals(0l)) 
		{
			throw new RuntimeException();
		}
		return invService.fetch(id);
		
		
	}



}
