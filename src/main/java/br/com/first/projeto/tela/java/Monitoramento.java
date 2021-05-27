
package br.com.first.projeto.tela.java;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

public class Monitoramento {
    
   Looca looca = new Looca();
   Memoria memoria = new Memoria(); 
   String memoriaRam;
   Temperatura temperatura;
   Processador processador = new Processador();
   String qtdDeUso ;
   Integer qtdProcessos;
   ProcessosGroup processosGroup = new ProcessosGroup();
   
   public void formatarTemperatura(){
        this.temperatura = looca.getTemperatura();    
   }
   
   public void formatarQtdProcessos(){
        this.qtdProcessos = processosGroup.getTotalProcessos();  
   }
   

   public void formatarMemoriaRam(){
        this.memoriaRam = memoria.getEmUso().toString();
   }
   
   public void formatarQtdDeUso(){
        this.qtdDeUso = processador.getUso().toString();
   }
   
    public String getMemoriaRam() {
        formatarMemoriaRam();
        return memoriaRam;
    }

    public String getQtdDeUso() {
        formatarQtdDeUso();
        return qtdDeUso;
    }

    public Integer getQtdProcessos() {
        formatarQtdProcessos();
        return qtdProcessos;
    }

    public String getTemperatura() {
        formatarTemperatura();
        return temperatura.toString();
    }   
}
