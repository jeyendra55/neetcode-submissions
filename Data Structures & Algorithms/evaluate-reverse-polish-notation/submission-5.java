class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOp(a,b,token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String s){
            return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
        }
        private int applyOp(int a, int b, String Op){
            switch(Op){
                case "+" : return a+b;
                case "-" : return a-b;
                case "*" : return a*b;
                case "/" : 
                if(b==0){
                    throw new ArithmeticException("Division by zero in RPN input");
                }
                return a / b;
            }
            return 0;
        }
}
