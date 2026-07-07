package controllers;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import models.TicketSoporte;

public class TicketController {

  // primer metodo
  public TreeSet<TicketSoporte> filtrarYOrdenarTickets(List<TicketSoporte> tickets, int prioridadMinima) {
    Comparator<TicketSoporte> comparadorTicket = new Comparator<TicketSoporte>() {
      @Override
      public int compare(TicketSoporte ticket1, TicketSoporte ticket2) {
        // caso de duplicados si tanto LA PRIORIDAD como el CODIGO SON IGUALES
        if (ticket1.getPrioridad() == ticket2.getPrioridad()
            && ticket1.getCodigo().equalsIgnoreCase(ticket2.getCodigo())) {
          return 0;
        } else if (ticket1.getPrioridad() != ticket2.getPrioridad()) {
          return Integer.compare(ticket2.getPrioridad(), ticket1.getPrioridad());
        } else {
          return ticket1.getTecnico().compareToIgnoreCase(ticket2.getTecnico());
        }
      }
    };
    TreeSet<TicketSoporte> treeSetTicket = new TreeSet<>(comparadorTicket);
    for (TicketSoporte ticket : tickets) {
      if (ticket.getPrioridad() >= prioridadMinima) {
        treeSetTicket.add(ticket);
      }
    }
    return treeSetTicket;
  }

  // segundo metodo
  public TreeMap<String, TreeSet<Integer>> agruparCodigosPorPrioridad(List<TicketSoporte> tickets) {
    TreeMap<String, TreeSet<Integer>> mapaCodigosPrioridad = new TreeMap<>();
    TreeSet<Integer> prioridadAlta = new TreeSet<>();
    TreeSet<Integer> prioridadMedia = new TreeSet<>();
    TreeSet<Integer> prioridadBaja = new TreeSet<>();
    mapaCodigosPrioridad.put("ALTA", prioridadAlta);
    mapaCodigosPrioridad.put("MEDIA", prioridadMedia);
    mapaCodigosPrioridad.put("BAJA", prioridadBaja);
    for (TicketSoporte ticket : tickets) {
      if (ticket.getPrioridad() >= 4) {
        String[] arrTickets = ticket.getCodigo().split("-");
        String codigoNombre = arrTickets[1];
        int codigoAEntero = Integer.parseInt(codigoNombre);
        prioridadAlta.add((codigoAEntero));
      } else if (ticket.getPrioridad() == 2 || ticket.getPrioridad() == 3) {
        String[] arrTickets = ticket.getCodigo().split("-");
        String codigoNombre = arrTickets[1];
        int codigoAEntero = Integer.parseInt(codigoNombre);
        prioridadMedia.add(codigoAEntero);
      } else if (ticket.getPrioridad() == 1) {
        String[] arrTickets = ticket.getCodigo().split("-");
        String codigoNombre = arrTickets[1];
        int codigoAEntero = Integer.parseInt(codigoNombre);
        prioridadBaja.add(codigoAEntero);
      }
    }
    return mapaCodigosPrioridad;
  }
}
