package com.dbs.pay.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.pay.model.*;

public interface  currencyRespository extends JpaRepository< currency, String> {
}
