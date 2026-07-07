import java.util.ArrayList;
import java.util.List;
import controllers.TicketController;
import models.TicketSoporte;

public class App {

    public static void main(String[] args) throws Exception {
        TicketController ticketController = new TicketController();
        List<TicketSoporte> listaTicketSoporte = new ArrayList<>();
        listaTicketSoporte.add(new TicketSoporte("TK-101", "Carlos Vega", 4));
        listaTicketSoporte.add(new TicketSoporte("TK-102", "Carlos Mendez", 5));
        // llamar primer metodo
        System.out.println(ticketController.filtrarYOrdenarTickets(listaTicketSoporte, 3));
        // llamar segundo metodo
        System.out.println(ticketController.agruparCodigosPorPrioridad(listaTicketSoporte));
    }
}
