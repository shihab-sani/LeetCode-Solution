class Valid_Parentheses {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int size = 0;
        boolean t = false;
        char c = s.charAt(0);
        for (int i = 0; i<s.length(); i++){
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                arr[size] = c;
                size++;
            }
            else{
                if (size == 0)
                    return t;
                if (c == ')'){
                    if (arr[size-1] != '(')
                        return t;
                }
                else if (c == '}'){
                    if (arr[size-1] != '{')
                        return t;
                }
                else if (c == ']'){
                    if (arr[size-1] != '[')
                        return t;
                }
                size--;
            }
        }
        if (size == 0){
            t = true;
            return t;
        }
        return t;
    }
}