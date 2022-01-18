package getir.book.store.exception;

public class RecordNotFoundException extends  RuntimeException{
    public RecordNotFoundException(String s) {
        super(s);
    }
}
