package src.Trie;

public class ExtraCharacters {
    TrieNode root;
    int result = 0;
    public int minExtraChar(String s, String[] dictionary) {
        root = new TrieNode();
        for(String word: dictionary){
            insertWord(word);
        }

        return searchWord(s, 0, new int[s.length()]);
    }

    public void insertWord(String word){

        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(node.childrens[index] == null){
                TrieNode child = new TrieNode();
                node.childrens[index] = child;
            }
            node = node.childrens[index];
        }

        node.isEndFlag = true;
    }

    public int searchWord(String word, int index, int[] dp){
        if(index == word.length()) return 0;

        if(dp[index] != 0) return dp[index];

        result = 1 + searchWord(word, index + 1, dp);
        TrieNode node = root;
        for(int i = index; i < word.length(); i++){
            int indexOfChild = word.charAt(i) - 'a';
            node = node.childrens[indexOfChild];
            if(node == null){
                break;
            }

            if(node.isEndFlag){
                result = Math.min(result, searchWord(word, i + 1, dp));
            }
        }
        dp[index] = result;

        return result;
    }
}


