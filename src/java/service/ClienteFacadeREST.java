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

/**
 *
 * @author jgasd
 */
@Stateless
@Path("modelo.cliente")
public class ClienteFacadeREST extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "examenPU")
    private EntityManager em;

    public ClienteFacadeREST() {
        super(Cliente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Cliente entity) {
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
    public Cliente find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        return super.findAll();
    }
////////////////////////////////////////////////////
       @POST
    @Path ("CrearCliente")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("ide")String ide,@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,
    @FormParam("direccion")String direccion,@FormParam("correo")String correo,@FormParam("telefono")String telefono,@FormParam("provincia")String provincia,@FormParam("edad") String edad,@FormParam("vehiculocompra") String vehiculocompra)
   {     
     Cliente ob = new Cliente(ide, cedula, nombre, apellido, direccion, correo, telefono, provincia, edad, vehiculocompra);
     super.create(ob);     
      return "Se registro correctamente";  
    }
    
    @POST
      @Path ("Actualizardatos")
      @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
      public String actualizar(@FormParam("ide")String ide,@FormParam("cedula")String cedula,@FormParam("nombre")String nombre,@FormParam("apellido")String apellido,
    @FormParam("direccion")String direccion,@FormParam("correo")String correo,@FormParam("telefono")String telefono,@FormParam("provincia")String provincia,@FormParam("edad") String edad,@FormParam("vehiculocompra") String vehiculocompra){
   {             
                  
           Cliente ob = new Cliente(ide);
           if(ide==null){  
               return "no se edito por que no se encuentra registrado";
           }else {
           ob.setCedula(cedula);
           ob.setNombre(nombre);
           ob.setApellido(apellido);
           ob.setDireccion(direccion);
           ob.setCorreo(correo);
           ob.setTelefono(telefono);
           ob.setProvincia(provincia);
           ob.setEdad(edad);
           ob.setVehiculocompra(vehiculocompra);          
           super.edit(ob);
           
              return "Se edito correctamente";
             
         }
         }
      }
      

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
