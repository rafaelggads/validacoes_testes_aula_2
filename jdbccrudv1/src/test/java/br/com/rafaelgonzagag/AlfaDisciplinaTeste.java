package br.com.rafaelgonzagag;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao.*;
import br.com.gilmarioarantes.jdbccrudv1.model.Disciplina;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao.DeletaDisciplina;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlfaDisciplinaTeste {

    Logger logger = Logger.getLogger(AlfaDisciplinaTeste.class.getName());

    @Test
    public void incluirDisciplinaTest(){

        logger.info("Executando o método incluirDisciplinaTest() da classe: " + this.getClass().getSimpleName());
        
        boolean result = false;

        try{
            Disciplina disciplina = new Disciplina();
            disciplina.setId(new Long(50));
            disciplina.setNome("Futebol");
            disciplina.setCargaHoraria(80);
            
            result = new PersisteDisciplina().persisteDisciplina(disciplina);
          
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Disciplina!", e);
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void excluirDisciplinaTest(){
        System.out.println("Executando o método excluirDisciplinaTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaDisciplina().deletaDisciplina(new Long(50));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
