package br.com.gilmario;

/**
 * Created by gilmario on 21/02/17.
 */
public class PessoaController {
    private PessoaDAO pessoaDAO;
    private GeradorDeLog log;

    public PessoaController(GeradorDeLog log){
        pessoaDAO = new PessoaDAO();
        this.log = log;
    }

    public void exclui(Pessoa pessoa){
        pessoaDAO.exclui(pessoa);
        log.criaLog(pessoa.getNome());
    }
}
