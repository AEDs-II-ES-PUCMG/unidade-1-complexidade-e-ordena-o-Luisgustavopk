import java.util.Comparator;

/**
 * Critério A - Valor Final do Pedido (crescente).
 * Desempate 1: Volume Total de Itens (quantProdutos).
 * Desempate 2: Código Identificador do primeiro item do pedido.
 */
public class ComparadorCriterioA implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        
        if (o1.valorFinal() == o2.valorFinal()){
            
            if(o1.getTotalItens() == o1.getTotalItens()){
                 o1.compareTo(o2);
            }else if(o1.getTotalItens()> o2.getTotalItens()){
                return 1;
            }else{
                return -1;
            }

        }else if (o1.valorFinal()> o2.valorFinal()){
            return 1;
        }
        return -1;
        
    }
}
