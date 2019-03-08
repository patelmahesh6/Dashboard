/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.repository;

import com.panthera.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mahesh
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
