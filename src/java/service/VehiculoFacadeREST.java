/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author jgasd
 */
@Stateless
@Path("modelo.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "examenPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Vehiculo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vehiculo find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }
    
    /////////////////////////////////////
    
   @POST
   @Path ("buscar")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public List <Vehiculo> bus(@FormParam("pasajero")String pasajero){
 
    TypedQuery consulta = getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.nunpasajeros = :nunpasajeros",Vehiculo.class);
    consulta.setParameter("nunpasajeros",pasajero);
    return consulta.getResultList();
}
   @POST
   @Path ("buscarveh")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
public List <Vehiculo> bucarr(@FormParam("vehiculocon")String pas){
 
    TypedQuery consulta = getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.consecionario = :consecionario",Vehiculo.class);
    consulta.setParameter("consecionario",pas);
    return consulta.getResultList();
}


    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
