package src.Trie;

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        TrieNode node = root;
        return searchHelper(root, word);

    }
    public boolean searchHelper(TrieNode node, String word) {
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if('.' == ch){
                for(TrieNode child : node.childrens){
                    if(child != null && searchHelper(child, word.substring(i + 1)))
                        return true;
                }
                return false;
            }else{
                if(node.childrens[index] == null) return false;
            }

            node =  node.childrens[index];
        }

        return node.isEndFlag;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        //wordDictionary.search("pad"); // return False
        //wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        //wordDictionary.search("b.."); // return True

    }
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */