package com.dajungdagam.dg.domain.repository;

import com.dajungdagam.dg.domain.entity.TradePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradePostRepository extends JpaRepository<TradePost, Long> {
}
