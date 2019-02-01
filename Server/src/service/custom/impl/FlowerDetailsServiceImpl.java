package service.custom.impl;

import business.BusinessFactory;
import business.custom.FlowerDetailsBusiness;
import dto.FlowerDetailsDTO;
import service.custom.OrderDetailsService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FlowerDetailsServiceImpl extends UnicastRemoteObject implements OrderDetailsService {
    FlowerDetailsBusiness flowerDetailsBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.FLOWERDETAILS);
    public FlowerDetailsServiceImpl() throws RemoteException {
    }


    @Override
    public FlowerDetailsDTO search(int id) throws Exception {
      return flowerDetailsBusiness.search(id);
    }

    @Override
    public List<FlowerDetailsDTO> getAll() throws Exception {
        ArrayList<FlowerDetailsDTO>flowerDetailsDTOS=flowerDetailsBusiness.findAll();
        return flowerDetailsDTOS;
    }






}
