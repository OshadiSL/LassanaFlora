package business.custom.impl;

import business.custom.FlowerCategoryBusiness;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import entity.FlowerCategory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.FlowerCategoryRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class FlowerCategoryBusinessImpl implements FlowerCategoryBusiness {

    FlowerCategoryRepository flowerCategoryRepository = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.FLOWERCATEGORY);

    //    private Object List;

    public FlowerCategoryBusinessImpl() {
    }


    @Override
    public boolean add(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            flowerCategoryRepository.add(new FlowerCategory(flowerCategoryDTO.getFCID(),flowerCategoryDTO.getDescription(),flowerCategoryDTO.getUnitPrice(),flowerCategoryDTO.getStatus()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public FlowerCategoryDTO search(int id) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            FlowerCategory serch = flowerCategoryRepository.search(id);
            session.getTransaction().commit();
            return new FlowerCategoryDTO(serch.getFCID(), serch.getCategoryType(), serch.getPrice(), serch.getStatus());

        }
    }

    @Override
    public ArrayList<FlowerCategoryDTO> findAll() throws Exception {
        ArrayList<FlowerCategoryDTO> flowerCategoryDTOS = new ArrayList<>();
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            List<FlowerCategory> flowerCategory = flowerCategoryRepository.findAll();
            for (FlowerCategory ch : flowerCategory) {
                flowerCategoryDTOS.add(new FlowerCategoryDTO(ch.getFCID(),
                        ch.getCategoryType(),
                        ch.getPrice(),
                        ch.getStatus()));
            }
            session.getTransaction().commit();

        }
        return flowerCategoryDTOS;
    }

    @Override
    public boolean delete(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            flowerCategoryRepository.delete(new FlowerCategory(flowerCategoryDTO.getFCID()));
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public boolean update(FlowerCategoryDTO flowerCategoryDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            flowerCategoryRepository.update(new FlowerCategory(flowerCategoryDTO.getFCID()));
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public ArrayList<String> getCtegory() throws Exception {
        List list;
        try
                (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryRepository.setSession(session);
            session.getTransaction().begin();
            list = session.createSQLQuery("select status from flowercategory  ").list();

            session.getTransaction().commit();
        } catch (HibernateException e) {
            return null;
        }
        return (ArrayList<String>) list;
    }

    @Override
    public List<FlowerCategoryDTO> getSearch(String search) throws Exception {
        List<FlowerCategoryDTO>flowerCategoryDTOS=new ArrayList<>();
        List<FlowerCategory>flowerCategories=flowerCategoryRepository.getSearch(search);
        for (FlowerCategory flowerCategory: flowerCategories){
            flowerCategoryDTOS.add(new FlowerCategoryDTO(flowerCategory.getFCID(),flowerCategory.getCategoryType(),flowerCategory.getPrice(),flowerCategory.getStatus()));

        }
        return flowerCategoryDTOS;
    }

    @Override
        public boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
//            try(Session session=HibUtil.getSessionFactory().openSession()){
//                flowerCategoryRepository.setSession(session);
//                session.getTransaction().begin();
//                flowerCategoryRepository.add(new Cate)
//            }
        return true;
    }


}
