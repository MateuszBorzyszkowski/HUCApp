package com.mateusz.api;

import com.mateusz.model.Settlement;

import java.util.List;

public interface SettlementService {
    void addSettlement(Settlement settlement);
    List<Settlement> getAllSettlements();
}
