package business.custom.impl;

import business.custom.FlowerCategoryBusiness;
import business.custom.FlowerCategoryTypeBusiness;
import dto.FlowerCategoryDTO;
import dto.FlowerCategoryTupeDTO;
import entity.CategoryType;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.FlowerCategoryTypeRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class FlowerCategoryTypeBusinessImpl implements FlowerCategoryTypeBusiness {

    FlowerCategoryTypeRepository flowerCategoryTypeRepository = RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.FLOWERCATEGORYTYPE);

    public FlowerCategoryTypeBusinessImpl() {
    }

    @Override
    public boolean addCategoryType(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryTypeRepository.setSession(session);
            session.getTransaction().begin();
            session.save(new CategoryType(flowerCategoryDTO.getId(), flowerCategoryDTO.getName()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public FlowerCategoryTupeDTO search(int parseInt) throws Exception {
//        try (Session session = HibUtil.getSessionFactory().openSession()) {
//            flowerCategoryTypeRepository.setSession(session);
//            session.getTransaction().begin();
//            CategoryType search = flowerCategoryTypeRepository.search(parseInt);
//            session.getTransaction().commit();
//            return new FlowerCategoryTupeDTO(search.getId(),search.getName());
//
//        }
        return null;
    }

    @Override
    public FlowerCategoryTupeDTO search2(String text) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryTypeRepository.setSession(session);
            session.getTransaction().begin();
            CategoryType search = flowerCategoryTypeRepository.search2(text);
            session.getTransaction().commit();
            return new FlowerCategoryTupeDTO(search.getId(),search.getName());

        }

    }

    @Override
    public boolean delete(FlowerCategoryTupeDTO flowerCategoryDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryTypeRepository.setSession(session);
            session.getTransaction().begin();
            flowerCategoryTypeRepository.delete(new CategoryType(flowerCategoryDTO.getId(),flowerCategoryDTO.getName()));
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public ArrayList<FlowerCategoryTupeDTO> findAll() throws Exception {
        ArrayList<FlowerCategoryTupeDTO> flowerCategoryDTOS = new ArrayList<>();
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            flowerCategoryTypeRepository.setSession(session);
            session.getTransaction().begin();
            List<CategoryType> flowerCategory = flowerCategoryTypeRepository.findAll();
            for (CategoryType ch : flowerCategory) {
                flowerCategoryDTOS.add(new FlowerCategoryTupeDTO(ch.getId(),
                        ch.getName()));
            }
            session.getTransaction().commit();

        }
        return flowerCategoryDTOS;
    }
}
