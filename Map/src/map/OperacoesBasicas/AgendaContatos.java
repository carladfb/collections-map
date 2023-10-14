package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) throws Exception {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Carla", 998456315);
        agendaContatos.adicionarContato("Matheus", 964565123);
        agendaContatos.adicionarContato("Joao", 945653211);
        agendaContatos.adicionarContato("Pietra", 945651320);
        agendaContatos.adicionarContato("Julia", 945139465);
        agendaContatos.adicionarContato("Raquel", 954451329);
    
        System.out.println("Exibino contatos: ");
        agendaContatos.exibirContatos();
        
        
        System.out.println("Exibino contatos: ");
        agendaContatos.removerContato("Joao");
        agendaContatos.exibirContatos();

        System.out.println("Pesquisar contato: ");
        System.out.println("O número é: " + agendaContatos.pesquisarPorNome("Pietra"));

    }
}
