import java.util.Stack;

class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                result = st.peek();
                st.pop();
                result += st.peek();
                st.pop();
                st.push(result);

            } else if (tokens[i].equals("*")) {
                result = st.peek();
                st.pop();
                result *= st.peek();
                st.pop();
                st.push(result);

            } else if (tokens[i].equals("-")) {
                result = st.peek();
                st.pop();
                result = st.peek()-result;
                st.pop();
                st.push(result);

            } else if (tokens[i].equals("/")) {
                result = st.peek();
                st.pop();
                result = st.peek()/result;
                st.pop();
                st.push(result);
            } else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();
    }
}