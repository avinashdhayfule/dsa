package src.Trie;


class ImplementTrie {
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;
        for(int i = 0; i< word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.childrens[index] == null){
                TrieNode child = new TrieNode();
                node.childrens[index] = child;
            }
            node = node.childrens[index];
            System.out.println(node);
        }

        node.isEndFlag = true;

    }

    public boolean search(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(node.childrens[index] == null)
                return false;

            node = node.childrens[index];
        }

        return node.isEndFlag;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(node.childrens[index] == null)
                return false;

            node = node.childrens[index];
        }

        return node.childrens.length != 0;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        boolean flag = trie.search("apple");
        System.out.println(flag);// return True
        flag = trie.search("app");
        System.out.println(flag);// return False
        flag = trie.startsWith("app");
        System.out.println(flag);// return True
        trie.insert("app");
        flag = trie.search("app");     // return True
        System.out.println(flag);
    }
}


