import java.lang.reflect.Array;
import java.util.*;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.

//// bracket = "({[]})"


// function that takes in a String and returns  a boolean
public class BalancedBrackets {
    public static void main(String[]args){
        System.out.println(balanceBrackets("(}")); // false
        System.out.println(balanceBrackets("({[]})")); // true
        System.out.println(balanceBrackets("([})")); // false
        System.out.println(balanceBrackets("([{}])]")); // false
    }

    static boolean balanceBrackets(String str){
        // create a map of key value pairs that is opening and brackets
        HashMap<Character, Character> bracketMap = new HashMap<>();

        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');


        // create a stack
        Stack <Character> bracketStack = new Stack<>();

        // split string into character array

        var charArray = str.toCharArray();

        for (var ch : charArray){
            // if character is opening braket, add it to the stack
            if (ch == '(' || ch == '[' || ch == '{'){
                bracketStack.add(ch); // ({[
            } else if (ch == ')' || ch == ']' || ch == '}'){
                // if character is closing bracket,
                if (bracketStack.isEmpty()){
                    return false;
                }
                // get last character in stack and see if it's the key to the closing bracket
                char last = bracketStack.peek(); // [

                // check to see if last is the key to the hashmap of the closign bracket

                if (last == bracketMap.get(ch)){
                    bracketStack.pop();
                }

                else {
                    return false;
                }
            }

        }

       return bracketStack.isEmpty();
        // return true if stack is empty and string is at max length
    }

}
