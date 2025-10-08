class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int n = path.length();
        int i = 0;

        while (i < n) {
            while (i < n && path.charAt(i) == '/') {
                i++;
            }

            StringBuilder sb = new StringBuilder();
            while (i < n && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }

            String token = sb.toString();

            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (token.equals(".") || token.equals("")) {

                continue;
            } else {
                stack.push(token);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
