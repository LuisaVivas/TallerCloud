package com.example.echo;

import beans.Equipo;
import com.google.api.server.spi.response.BadRequestException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import persistence.EMF;

public class Dimayor {

    private ArrayList<Equipo> equipos;

    public Dimayor() {

        equipos = new ArrayList<>();

    }

    public List<Equipo> getEquipos() {

        EntityManager em = EMF.get().createEntityManager();

        return em.createNamedQuery("Equipo.findAll", Equipo.class).getResultList();
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Transactional
    public Equipo agregarNuevoEquipo(int id, String nombreEquipo, int anioFundacion, int cantidadTitulo) {
        EntityManager em = EMF.get().createEntityManager();
        em.getTransaction().begin();
        /*
        String query1= "INSERT INTO Equipos.Equipo (idEquipo, Nombre, aniofundacion, cantidadtitulos) VALUES (?, ?, ?, ?)";
        Query query = em.createNativeQuery(query1, Equipo.class);
        
        query.setParameter(1, id);
        query.setParameter(2, nombreEquipo);
        query.setParameter(3, anioFundacion);
        query.setParameter(4, cantidadTitulo);
        return (Equipo) query.ex;*/
        Equipo equipo = new Equipo(id, nombreEquipo, anioFundacion, cantidadTitulo);

        em.persist(equipo);

        em.getTransaction().commit();

        return equipo;

    }

    public void eliminarEquipo(int IdEquipo) {
        EntityManager em = EMF.get().createEntityManager();
        Equipo p = em.find(Equipo.class, IdEquipo);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public Equipo infoEquipo(int idEquipo) {

        EntityManager em = EMF.get().createEntityManager();
        em.getTransaction().begin();
        Equipo equipo = em.find(Equipo.class, idEquipo);
        em.getTransaction().commit();
        return equipo;
        //em.createNamedQuery("Equipo.findByIdEquipo", Equipo.class).setParameter("idEquipo", idEquipo).getSingleResult();
    }

    public void cambiarInfoEquipo(String nombreEquipo, int anioFundacion, int cantidadTitulo) {

        List<Equipo> list = getEquipos();
        Equipo eq=null;
        
        for (Equipo equipo : list) {
            if(equipo.getNombre().equals(nombreEquipo)){
                eq=equipo;
                break;
            }
        }
        Equipo e=new Equipo();
        e.setNombre(nombreEquipo);
        e.setIdEquipo(eq.getIdEquipo());
        e.setAniofundacion(anioFundacion);
        e.setCantidadtitulos(cantidadTitulo);
        EntityManager em = EMF.get().createEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();

    }

}
