package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.InvoiceDTO;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDTO, Long> {

}
