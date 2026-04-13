import java.util.Comparator;

public class ComparadorPorPadrao implements Comparator<Produto> {

    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.compareTo(o2);
    }
    
}
