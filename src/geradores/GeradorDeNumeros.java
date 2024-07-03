package geradores;

public class GeradorDeNumeros {
    private int numeroMaximo = 100;
    private int numeroMinimo = 1;
    
    public int gerarNumeroRandomico(){
        return (int)((Math.random()*numeroMaximo-numeroMinimo)+numeroMinimo);
    }
}
