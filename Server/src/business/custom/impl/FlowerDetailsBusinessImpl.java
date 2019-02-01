package business.custom.impl;

import business.custom.FlowerDetailsBusiness;
import dto.FlowerDetailsDTO;
import entity.FlowerDetails;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.FlowerDetailsRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class FlowerDetailsBusinessImpl implements FlowerDetailsBusiness {
    FlowerDetailsRepository flowerDetailsRepository= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.FLOWERDETAILS);

    public FlowerDetailsBusinessImpl() {
    }


    @Override
    public FlowerDetailsDTO search(int id) throws Exception {
     try (Session session= HibUtil.getSessionFactory().openSession()){
         flowerDetailsRepository.setSession(session);
         session.getTransaction().begin();
         FlowerDetails search=flowerDetailsRepository.search(id);
         session.getTransaction().commit();
         return new FlowerDetailsDTO(search.getOrders().getOid(),search.getFlowerCategory().getFCID(),search.getOrderQty(),search.getUnitPrice(),search.getFlowerName());

     }
    }

    @Override
    public ArrayList<FlowerDetailsDTO> findAll() throws Exception {
      ArrayList<FlowerDetailsDTO>flowerDetailsDTOS=new ArrayList<>();
      try(Session session=HibUtil.getSessionFactory().openSession()){
          flowerDetailsRepository.setSession(session);
          session.getTransaction().begin();
          List<FlowerDetails>flowerDetails=flowerDetailsRepository.findAll();
          for (FlowerDetails ch:flowerDetails){
              flowerDetailsDTOS.add(new FlowerDetailsDTO(ch.getOrders().getOid(),
                      ch.getFlowerCategory().getFCID(),ch.getOrderQty(),
                      ch.getUnitPrice(),ch.getFlowerName()));
          }
          session.getTransaction().commit();
      }
      return flowerDetailsDTOS;
    }




}
