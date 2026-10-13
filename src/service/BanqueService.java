package service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import metier.BanqueLocal;
import metier.entities.Compte;

import java.util.List;

@WebService
@Stateless
public class BanqueService {
    @EJB
    private BanqueLocal banqueLocal;
    @WebMethod
    public Compte addCompte(@WebParam(name = "compte") Compte compte) {
        return banqueLocal.addCompte(compte);
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code) {
        return banqueLocal.getCompte(code);
    }
    @WebMethod
    public List<Compte> listComptes() {
        return banqueLocal.listComptes();
    }
    @WebMethod
    public void verser(
            @WebParam(name = "code") Long code,
            @WebParam(name = "montant") double montant){
        banqueLocal.verser(code, montant);
    }
    @WebMethod
    public void retirer(
            @WebParam(name = "code") Long code,
            @WebParam(name = "montant") double montant){
        banqueLocal.retirer(code, montant);
    }
    @WebMethod
    public void virement(
            @WebParam(name = "compte1") Long code1,
            @WebParam(name = "compte2") Long code2,
            @WebParam(name = "montant") double montant
    ){
        banqueLocal.virement(code1, code2, montant);
    }
}
