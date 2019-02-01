package business.custom.impl;

import business.custom.ReceptionBusiness;
import dto.FloristDTO;
import dto.ReceptionDTO;
import entity.Florist;
import entity.Reception;
import org.hibernate.Session;
import repository.RepoFactory;
import repository.custom.ReseptionRepository;
import resources.HibUtil;

import java.util.ArrayList;
import java.util.List;

public class ReceptionBusinessImpl implements ReceptionBusiness {
    ReseptionRepository reseptionRepository= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.RESEPTION);

    public ReceptionBusinessImpl() {
    }

    @Override
    public boolean save(ReceptionDTO receptionDTO) throws Exception {
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            reseptionRepository.setSession(session);
            session.getTransaction().begin();
            session.save(new Reception(receptionDTO.getReceptionId(), receptionDTO.getReceptionName(), receptionDTO.getAddress(), receptionDTO.getContactNum(), receptionDTO.getAddress(),receptionDTO.getUserName(),receptionDTO.getPassWord()));
            session.getTransaction().commit();

        }
        return true;
    }

    @Override
    public ArrayList<ReceptionDTO> findAll() throws Exception {
        ArrayList<ReceptionDTO> receptionDTOS = new ArrayList<>();
        try (Session session = HibUtil.getSessionFactory().openSession()) {
            reseptionRepository.setSession(session);
            session.getTransaction().begin();
            List<Reception> receptionList = reseptionRepository.findAll();
            for (Reception ch : receptionList) {
                receptionDTOS.add(new ReceptionDTO(ch.getReceptionId(),
                        ch.getReceptionName(),ch.getUserName(),ch.getPassWord()));
            }
            session.getTransaction().commit();

        }
        return receptionDTOS;
    }

}
