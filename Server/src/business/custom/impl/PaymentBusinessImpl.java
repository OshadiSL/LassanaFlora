package business.custom.impl;

import business.custom.PaymentBusiness;
import repository.RepoFactory;
import repository.custom.PayementRepository;

public class PaymentBusinessImpl implements PaymentBusiness {
    PayementRepository payementRepository= RepoFactory.getInstance().getRepositoryFor(RepoFactory.RepoTypes.PAYMENT);

    public PaymentBusinessImpl() {
    }


}
