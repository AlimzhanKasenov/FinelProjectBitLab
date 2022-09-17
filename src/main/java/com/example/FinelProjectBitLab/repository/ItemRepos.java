package com.example.FinelProjectBitLab.repository;

import com.example.FinelProjectBitLab.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemRepos extends JpaRepository<Items, Long> {
}
