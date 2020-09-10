package com.mateusz.api;

import com.mateusz.model.Settlement;

import java.util.List;

public interface SettlementDao {
    void addSettlement(Settlement settlement);
    List<Settlement> getAllSettlements();
}
