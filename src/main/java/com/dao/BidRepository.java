package com.dao;

import com.entity.Bids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Panos on 26/8/16.
 */
@Repository
public interface BidRepository extends JpaRepository<Bids, Long> {
    List<Bids> findAll();
}

