import java.util.Stack;

/**
 *
 * @author ovidiomolina
 */
public class ParenthesisCheck {
    
    public static void main(String args[]) {
        String[] phrases = {
            "(1+1*(2+2))", "(([()]))","[][[(())[[]]]]()",
                "[","([][][])(","()[]]", "((){}[)"
        };
        for (String phrase : phrases) {
            System.out.println(String.format("%s, %s",
                    phrase, checkParenthesis(phrase)));
        }
    }
    
    static String checkParenthesis(String phrase) {
        if(phrase == null) {
            return "invalid";
        }
        if(phrase.length() == 0) {
            return "valid";
        }
        
        Stack<String> stack = new Stack();
        for(int i=0; i<phrase.length(); i++) {
            char current = phrase.charAt(i);
            switch(current) {
                case '(':
                case '[':
                    stack.push(String.format("%s", current));
                    break;
                case ')':
                    if(stack.isEmpty() || !stack.peek().equalsIgnoreCase("(")) {
                        if(!stack.isEmpty()) {
                            stack.clear();
                        }
                        return "invalid";
                    }
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || !stack.peek().equalsIgnoreCase("[")) {
                        if(!stack.isEmpty()) {
                            stack.clear();
                        }
                        return "invalid";
                    }
                    stack.pop();
                    break;
            }
        }
        
        if(!stack.isEmpty()) {
            stack.clear();
            return "invalid";
        }
        
        return "valid";
    }
}
