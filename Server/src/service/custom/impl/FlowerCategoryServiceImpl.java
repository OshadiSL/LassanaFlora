package service.custom.impl;

import business.BusinessFactory;
import business.custom.FlowerCategoryBusiness;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import service.custom.FlowerCategoryService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class FlowerCategoryServiceImpl extends UnicastRemoteObject implements FlowerCategoryService {
    FlowerCategoryBusiness flowerCategoryBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.FLOWERCATEGORY);




    public FlowerCategoryServiceImpl() throws RemoteException {
    }

    @Override
    public boolean add(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryBusiness.add(flowerCategoryDTO);
    }

    @Override
    public FlowerCategoryDTO search(int id) throws Exception {
        return flowerCategoryBusiness.search(id);

    }

    @Override
    public List<FlowerCategoryDTO> getAll() throws Exception {
        ArrayList<FlowerCategoryDTO>flowerCategoryDTOS=flowerCategoryBusiness.findAll();
        return flowerCategoryDTOS;
    }

    @Override
    public boolean delete(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryBusiness.delete(flowerCategoryDTO);
    }

    @Override
    public boolean update(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryBusiness.update(flowerCategoryDTO);
    }

    @Override
    public ArrayList<String> getCategory() throws Exception {
        return flowerCategoryBusiness.getCtegory();
    }

    @Override
    public List<FlowerCategoryDTO> getSearch(String search) throws Exception {
        List<FlowerCategoryDTO>flowerCategoryDTOS=flowerCategoryBusiness.getSearch(search);
        return flowerCategoryDTOS;
    }

    @Override
    public boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
        return flowerCategoryBusiness.addCategoryType(flowerCategoryDTO);
    }


}
