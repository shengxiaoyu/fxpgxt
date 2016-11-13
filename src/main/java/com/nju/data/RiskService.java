package com.nju.data;

import com.nju.model.Risk;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Zongyi on 2016/11/10.
 */
public interface RiskService {
    List<Risk> getAllRisks() throws RemoteException;
    Risk getRisk(int risk_id) throws RemoteException;
    void addRisk(Risk risk) throws RemoteException;
    void deleteRisk(int risk_id) throws RemoteException;
    void followRisk(int risk_id,String follower_id) throws RemoteException;
}
