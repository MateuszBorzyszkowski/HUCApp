package com.mateusz.service;

import com.mateusz.api.SettlementDao;
import com.mateusz.api.SettlementService;
import com.mateusz.dao.SettlementDaoImpl;
import com.mateusz.model.Place;
import com.mateusz.model.Settlement;

import java.util.List;

public class SettlementServiceImpl implements SettlementService {
    private static SettlementServiceImpl instance = null;
    private final SettlementDao settlementDao = SettlementDaoImpl.getInstance();

    private SettlementServiceImpl() {}
    public static SettlementServiceImpl getInstance() {
        if (instance == null) {
            instance = new SettlementServiceImpl();
        }
        return instance;
    }

    @Override
    public void addSettlement(Settlement settlement) {
        settlementDao.addSettlement(settlement);
    }

    @Override
    public List<Settlement> getAllSettlements() {
        return settlementDao.getAllSettlements();
    }
}
