import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringBalance {
    private List<Character> rightOpen = Arrays.asList('(', '[','{','<');
    private List<Character> leftOpen = Arrays.asList(')',']','}','>');

    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()){
            if(isRightBrackets(ch)){
                stack.push(ch);
            } else if(isLeftBracket(ch)) {
                if(stack.empty()){
                    return false;
                }
                var top = stack.pop();
                if(!isBracketsMatch(top,ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
    private boolean isRightBrackets(char ch){
        return rightOpen.contains(ch);
    }

    private boolean isLeftBracket(char ch){
        return leftOpen.contains(ch);
    }

    private boolean isBracketsMatch(char right , char left){
        return rightOpen.indexOf(right) == leftOpen.indexOf(left);
    }
}
