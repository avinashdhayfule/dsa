package src.TwoPointers;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {

        if(name.length() > typed.length()) return false;

        int k = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < name.length(); i++){
            char ch = name.charAt(i);
            int freq = 1;

            while( i < name.length() - 1 && ch == name.charAt(i + 1)){
                freq++; i++;
            }

            while(freq > 0 && k < typed.length()){
                sb.append(ch);
                char key = typed.charAt(k);

                if(key != ch) return false;

                freq--; k++;
            }

            while( k < typed.length() && typed.charAt(k) == ch) k++;
        }

        if(k < typed.length()) return false;

        return name.equals(sb.toString());
    }
}
