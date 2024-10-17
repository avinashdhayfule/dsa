package src.Trie;

public class Trie {

    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.childrens[index] == null){
                TrieNode child = new TrieNode();
                node.childrens[index] = child;
            }
            node = node.childrens[index];
        }
        node.isEndFlag = true;

        System.out.println(root.childrens);
    }

    public boolean search(String word){
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.childrens[index] == null)
                return false;

            node = node.childrens[index];
        }
        return node.isEndFlag;
    }

    public void deleteWord(String word){
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()){
            if(current.isEndFlag){
                current.isEndFlag = false;
                return current.childrens.length == 0;
            }
            return false;
        }

        char ch = word.charAt(index);
        TrieNode node = current.childrens[ch - 'a'];
        if(node == null){
            return false;
        }

        boolean shouldDeleteChild = delete(node, word, index + 1);

        if(shouldDeleteChild){
            current.childrens[ch - 'a'] = null;
            return current.childrens.length == 0;
        }

        return false;
    }



    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("cat");
        trie.insert("can");
    }


}


class TrieNode{
    TrieNode[] childrens = new TrieNode[26];
    boolean isEndFlag;

    public TrieNode(){
        isEndFlag =false;
        for (int i = 0; i < 26; i++) {
            childrens[i] = null;
        }
    }

}
