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