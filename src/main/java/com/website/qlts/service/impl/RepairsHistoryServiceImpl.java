package com.website.qlts.service.impl;

import com.website.qlts.entity.RepairsHistory;
import com.website.qlts.repository.RepairsHistoryRepository;
import com.website.qlts.service.RepairsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class RepairsHistoryServiceImpl implements RepairsHistoryService {

    @Autowired
    private RepairsHistoryRepository repairsHistoryRepository;

    @Override
    public void save(RepairsHistory repairsHistory){
        repairsHistoryRepository.save(repairsHistory);
    }
}
