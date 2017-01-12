package hello;

public class ServicioSeguro {

    private final long id;
    private final String content;

    public ServicioSeguro(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}