
package br.com.first.projeto.tela.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {

    public static void main(String[] args) {
        int delay = 10000;   // delay de 10 seg.
        int interval = 5000;  // intervalo de 1 seg.
        Timer timer = new Timer();
        
        Monitoramento mon = new Monitoramento();
        Conexao con = new Conexao();
        JdbcTemplate template = new JdbcTemplate(con.getBanco());
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                Date data = new Date();
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String today = formatador.format(data);

                System.out.println("\n---------------------");
                System.out.println("Hora de inserir dados");
                System.out.println("Memoria Ram em uso: 50.00");
                System.out.println("Temperatura: " + mon.getTemperatura());
                System.out.println("Quantidade de processos: " + mon.getQtdProcessos().toString());
                System.out.println("---------------------\n");

                template.update("INSERT INTO dados (ram,temperatura,processador,dataDado,fkMaquina) VALUES (?,?,?,?,?)",
                        "50.00", mon.getTemperatura(), mon.getQtdProcessos().toString(), today, 7);

                System.out.println(".....");
                System.out.println("....");
                System.out.println("...");
                System.out.println("..");
                System.out.println(".");
                
                System.out.println("Os dados foram inseridos com sucesso");
            }
        }, delay, interval);
    }
}
