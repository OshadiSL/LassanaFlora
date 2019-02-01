package service.custom.impl;

import business.BusinessFactory;
import business.custom.FlowerCategoryTypeBusiness;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import observer.Observer;
import service.custom.FlowerCategoryTypeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FlowerCategoryTypeserviceImpl extends UnicastRemoteObject implements FlowerCategoryTypeService {

    FlowerCategoryTypeBusiness flowerCategoryTypeBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.FLOWERCATEGORYTYPE);

    private static ArrayList<Observer> allItemObservers=new ArrayList<>();




    public FlowerCategoryTypeserviceImpl() throws RemoteException {
    }

    @Override
    public boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryTypeBusiness.addCategoryType(flowerCategoryDTO);
    }

    @Override
    public FlowerCategoryTupeDTO search(int parseInt) throws Exception {
        return flowerCategoryTypeBusiness.search(parseInt);
    }

    @Override
    public FlowerCategoryTupeDTO search2(String text) throws Exception {
        return flowerCategoryTypeBusiness.search2(text);
    }

    @Override
    public boolean delete(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryTypeBusiness.delete(flowerCategoryDTO);
    }

    @Override
    public List<FlowerCategoryTupeDTO> getAll() throws Exception {
        ArrayList<FlowerCategoryTupeDTO>flowerCategoryDTOS=flowerCategoryTypeBusiness.findAll();
        return flowerCategoryDTOS;
    }
}
