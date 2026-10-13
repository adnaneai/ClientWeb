package service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import metier.BanqueLocal;
import metier.entities.Compte;

import java.util.List;

@Stateless
@Path("/")
public class BanqueRestService {
    @EJB
    private BanqueLocal banqueLocal;

    @POST
    @Path("/comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte addCompte(Compte compte) {
        return banqueLocal.addCompte(compte);
    }


    @GET
    @Path("/comptes/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getCompte(@PathParam(value = "code") Long code) {
        return banqueLocal.getCompte(code);
    }


    @GET
    @Path("/comptes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> listComptes() {
        return banqueLocal.listComptes();
    }


    @PUT
    @Path("/comptes/verser")
    @Produces(MediaType.APPLICATION_JSON)
    public void verser(@FormParam(value = "code") Long code,
                       @FormParam(value = "montant") double montant) {
        banqueLocal.verser(code, montant);
    }


    @PUT
    @Path("/comptes/retirer")
    @Produces(MediaType.APPLICATION_JSON)
    public void retirer(@FormParam(value = "code") Long code,
                        @FormParam(value = "montant") double montant){
        banqueLocal.retirer(code, montant);
    }

    @PUT
    @Path("/comptes/virsement")
    @Produces(MediaType.APPLICATION_JSON)
    public void virsement(@FormParam(value = "code1") Long code1,
                          @FormParam(value = "code2") Long code2,
                          @FormParam(value = "montant") double montant){
        banqueLocal.virement(code1, code2, montant);
    }
}
