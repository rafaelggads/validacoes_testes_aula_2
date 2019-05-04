package br.com.rafaelgonzagag;

import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao.*;
import br.com.gilmarioarantes.jdbccrudv1.model.Aluno;
import br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.exclusao.DeletaAluno;

import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlfaAlunoTeste {

    Logger logger = Logger.getLogger(AlfaAlunoTeste.class.getName());

    @Test
    public void incluirAlunoTest(){

        logger.info("Executando o método incluirAlunoTest() da classe: " + this.getClass().getSimpleName());
        
        boolean result = false;

        try{
            Aluno aluno = new Aluno();
            aluno.setId(new Long(50));
            aluno.setMatricula("121245456");
            aluno.setNome("Rafael Gonzaga");
            aluno.setSexo("M");
            aluno.setDataNascimento(new Timestamp(System.currentTimeMillis()));
            result = new PersisteAluno().persisteAluno(aluno);
          
        }catch (Exception e){
            result = false;
            logger.error("Erro ao persistir o Aluno!", e);
        }
        Assert.assertTrue(result);
    }
    
    @Test
    public void excluirAlunoTest(){
        System.out.println("Executando o método excluirAlunoTest() da classe: " + this.getClass().getSimpleName());
        boolean result;
        try {
            result = new DeletaAluno().deletaAluno(new Long(50));
        } catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}
