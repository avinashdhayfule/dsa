package src.Stack;

import java.util.Stack;

public class SimplyPath {
    public String simplifyPath(String path) {

        String[] directories = path.split("/");
        Stack<String> stack = new Stack();

        for(int i = 0; i < directories.length; i++){
            String directory = directories[i];

            if(directory.isBlank() || directory.isEmpty() || ".".equals(directory))
                continue;

            if("..".equals(directory)){
                if(!stack.isEmpty())
                    directory = stack.pop();
                continue;
            }else{
                stack.push(directory);
            }
        }

        return "/" + String.join("/", stack);
    }
}
