/*
Approach 
    1. Push all oepning backets inside stack.
    2. Once we find closing baracket match with last opening bracket
    3. if match continue till end  => valid
    4. else return false => invalid paranthesis
TC: O(n)
SC: O(1)
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

       for (char str : s.toCharArray()) {
			if (str == '(' || str == '{' || str == '[') {
				stack.push(str);
			} else if (str == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (str == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (str == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}
		}
        return stack.isEmpty();
    }
}