
/**
 * linked data structure, special case of Pair
 * 
 * @author Stefan Kahrs
 * @version 21/09/2017
 */
public class Node<A> extends Pair<A,Node<A>>
{

    public Node(A content,Node<A> next)
    {
        super(content,next);
    }

    public String toString() {
        return "[" + rawString() + "]";
    }
    
    //rawString implementation is non-recursive to avoid
    //stack overflows for long lists; the comments indicate what the recursive version would look like
    private String rawString() {
        // if (right==null) return ""+left;
        // return left + "," + right.rawString();
        StringBuilder sb=new StringBuilder(left.toString());
        for(Node<A>i=right; i!=null; i=i.getRight()) {
            sb.append(',');
            sb.append(i.left.toString());
        }
        return sb.toString();
    }
    

}
