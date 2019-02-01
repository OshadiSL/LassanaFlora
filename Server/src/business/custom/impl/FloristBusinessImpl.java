package business.custom.impl;

import business.custom.FloristBusiness;
import dto.FloristDTO;
import entity.Florist;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.FloristRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class FloristBusinessImpl implements FloristBusiness {
    FloristRepository floristRepository= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.FLORIST);

    public FloristBusinessImpl() {
    }

    @Override
    public boolean save(FloristDTO floristDTO) throws Exception {
       try(Session session= HibUtil.getSessionFactory().openSession()){
           floristRepository.setSession(session);
           session.getTransaction().begin();
           session.save(new Florist(floristDTO.getFloristId(), floristDTO.getFloristName(), floristDTO.getNic(),floristDTO.getContactNum(), floristDTO.getAddress(),floristDTO.getUserName(),floristDTO.getPassWord()));
           session.getTransaction().commit();
       }
       return true;
    }

    @Override
    public ArrayList<FloristDTO> findAll() throws Exception {
        ArrayList<FloristDTO> floristDTOS = new ArrayList<>();
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            floristRepository.setSession(session);
            session.getTransaction().begin();
            List<Florist> flowerCategory = floristRepository.findAll();
            for (Florist ch : flowerCategory) {
                floristDTOS.add(new FloristDTO(ch.getFloristId(),
                        ch.getFloristName(),ch.getUserName(),ch.getPassWord()));
            }
            session.getTransaction().commit();

        }
        return floristDTOS;
    }
}
