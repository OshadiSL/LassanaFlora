package service.custom.impl;

import business.BusinessFactory;
import business.custom.ReceptionBusiness;
import dto.ReceptionDTO;
import service.custom.ReceptionService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {
    ReceptionBusiness receptionBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.RECEPTION);
    public ReceptionServiceImpl() throws RemoteException {
    }

    @Override
    public boolean save(ReceptionDTO receptionDTO) throws Exception {
        return receptionBusiness.save(receptionDTO);
    }

    @Override
    public List<ReceptionDTO> getAll() throws Exception {
        ArrayList<ReceptionDTO> receptionDTOS=receptionBusiness.findAll();
        return receptionDTOS;
    }
}
