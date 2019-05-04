package br.com.rafaelgonzagag;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao.*;
import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao.DeletaProfessor;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlfaProfessorTeste {

    Logger logger = Logger.getLogger(AlfaProfessorTeste.class.getName());

    @Test
    public void incluirProfessorTest(){

        logger.info("Executando o método incluirProfessorTest() da classe: " + this.getClass().getSimpleName());
        
        boolean result = false;

        try{
            Professor professor = new Professor();
            professor.setId(new Long(50));
            professor.setNome("João");
            professor.setEmail("email@email");
            professor.setTitulacao("Titulacao");
            result = new PersisteProfessor().persisteProfessor(professor);
          
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Professor!", e);
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void excluirProfessorTest(){
        System.out.println("Executando o método excluirProfessorTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaProfessor().deletaProfessor(new Long(50));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
