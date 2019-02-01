package service.custom.impl;

import business.BusinessFactory;
import business.custom.PaymentBusiness;
import service.custom.PayementService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PayementServiceImpl extends UnicastRemoteObject implements PayementService {

    PaymentBusiness paymentBusiness= BusinessFactory.getInstance().getBusinessFor(BusinessFactory.BusinessTypes.PAYMENT);

    public PayementServiceImpl() throws RemoteException {
    }





    }
