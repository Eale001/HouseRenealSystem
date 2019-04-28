package com.eale.hrsm.dao;

import com.eale.hrsm.bean.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:29
 */
public interface ContractDao extends JpaRepository<Contract,Long> {
}
