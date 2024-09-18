package LeetCode;

class TrieNode_208 {
    boolean isWord;
    TrieNode_208[] children;
    
    TrieNode_208() {
        this.isWord = false;
        this.children = new TrieNode_208[26];
    }
}

public class ImplementTrie_PrefixTree_208 {
    
    class Trie {
        private TrieNode_208 rootTrieNode;
        
        public Trie() {
            this.rootTrieNode = new TrieNode_208();
        }
        
        public void insert(String word) {
            TrieNode_208 wordTrieNode = this.rootTrieNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordTrieNode.children[c - 'a'] == null) {
                    wordTrieNode.children[c - 'a'] = new TrieNode_208();
                }
                wordTrieNode = wordTrieNode.children[c - 'a'];
            }
            wordTrieNode.isWord = true;
        }
        
        public boolean search(String word) {
            TrieNode_208 wordTrieNode = this.rootTrieNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordTrieNode.children[c - 'a'] == null) {
                    return false;
                }
                wordTrieNode = wordTrieNode.children[c - 'a'];
            }
            return wordTrieNode.isWord;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode_208 wordTrieNode = this.rootTrieNode;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (wordTrieNode.children[c - 'a'] == null) {
                    return false;
                }
                wordTrieNode = wordTrieNode.children[c - 'a'];
            }
            return true;
        }
    }
}

