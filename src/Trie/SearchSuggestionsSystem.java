package src.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionsSystem {

    TrieNodeII root = new TrieNodeII();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        for(String product : products){
            insertWord(product);
        }

        return search(searchWord);
    }

    public void insertWord(String word){

        TrieNodeII node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';

            if(node.childrens[index] == null){
                TrieNodeII child = new TrieNodeII();
                node.childrens[index] = child;
            }
            node = node.childrens[index];

            if(node.words.size() < 3)
                node.words.add(word);
        }
    }

    public List<List<String>> search(String word){
        List<List<String>> result = new ArrayList();

        TrieNodeII node = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.childrens[index] == null){
                for (int j = i; j < word.length(); j++){
                    result.add(Collections.EMPTY_LIST);
                }
                break; //return result;
            }

            node = node.childrens[index];
            result.add(node.words);
        }
        return result;
    }
}
class TrieNodeII {
    public boolean isEndFlag;
    TrieNodeII[] childrens = new TrieNodeII[26];
    List<String> words;

    public TrieNodeII(){
        words = new ArrayList<>();
        for(int i =0 ; i< 26; i++){
            childrens[i] = null;
        }
    }
}

