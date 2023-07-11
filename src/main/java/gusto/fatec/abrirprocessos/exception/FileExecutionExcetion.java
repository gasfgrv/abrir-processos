package gusto.fatec.abrirprocessos.exception;

public class FileExecutionExcetion extends RuntimeException {
    public FileExecutionExcetion(Throwable throwable) {
        super("Erro ao executar o arquivo", throwable);
    }
}
