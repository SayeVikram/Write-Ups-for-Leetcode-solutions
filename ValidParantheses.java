
/*
    Hi guys this is my first write-up for the leetcode problem "Valid Parentheses."
    This problem demands whether or not a string is implemented with valid parentheses. 
    
    To solve this problem, I implemented a Stack and a Hashmap. The hashmap acted as a dictionary 
    mapping String -> String, being a RIGHT BRACKET (")", "]", "}") to a LEFT BRACKET. 
    The time complexity if O(N) as only one pass is made through the string

    When making a pass through the string, if the substring is a left bracket, it is pushed onto the 
    stack.

    In cases of a right bracket, we essentially push off the left bracket if it is a correct match.
    If the stack is empty, that implies a higher number of right brackets, so we just return false
    If the stack's elements do not have the correct match (checked through the hashmap) we return false
    If all conditions pass, the element in the stack is pushded off. 

    At the end, we check whether or not the stack is empty, as if this condition does not pass, 
    then there would be a higher number of left parantheses.
*/
import java.util.Stack;
import java.util.HashMap;
class ValidParantheses {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
        
        for(int i = 0; i < s.length(); i++){
            String rev = s.substring(i, i+1);
            if(rev.equals("[") || rev.equals("(") || rev.equals("{")){
                stack.push(rev);
                
            }
            
            else if(!(stack.isEmpty()) && stack.pop().equals(map.get(rev)))
                continue;
            else
                return false;
           
        
        }
         return stack.isEmpty();
    }
}