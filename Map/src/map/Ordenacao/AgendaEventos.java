package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventosMap.put(data, evento);
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        for (Map.Entry<LocalDate, Evento> entry : eventosMap.entrySet()) {
          LocalDate dataEvento = entry.getKey();
          if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
            proximaData = dataEvento;
            proximoEvento = entry.getValue();
            break;
          }
        }
        if (proximoEvento != null) {
          System.out.println("O próximo evento: " + proximoEvento.getNome() + " acontecerá na data " + proximaData);
        } else {
          System.out.println("Não há eventos futuros na agenda.");
        }
      }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2023, Month.OCTOBER, 12), "Show The Weeknd", "The Weeknd");
        agendaEventos.adicionarEvento(LocalDate.of(2025, 5, 15), "Show The Ariana Grande", "Ariana Grande");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 3, 29), "Show Beyonce", "Beyonce");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 3), "Show Twenty One Pilots", "Twenty One Pilots");
        agendaEventos.adicionarEvento(LocalDate.of(2021, Month.DECEMBER, 2), "Show Coldplay", "Coldplay");

        System.out.println("\nAgenda: ");
        agendaEventos.exibirAgenda();

        System.out.println("\nProximos eventos: ");
        agendaEventos.obterProximoEvento();
    }
}
