package cineflex;

public interface InterfaceFilme {
    public void comprarIngresso(int i, Pessoa type);
    public void escolherAssento(int i, String aux, int[] values);
    public void comprarComida(Pessoa tipo, int i);
    public String horarioFilme(int i);
    public void gerarFilmes();
    public void pagamento(String horario, int[] valores, Pessoa tipo, int i);
    public void pagamentoDinheiro(Pessoa tipo, int i, int[] valores);
    public void pagamentoMoedas(Pessoa tipo, int i, int[] valores);
}
