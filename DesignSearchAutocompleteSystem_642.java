package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TrieNode implements Comparable<TrieNode> {
    String sentence;
    TrieNode[] children;
    List<TrieNode> hotSentences; // contains the top 3 hot freq string list
    int times;
    
    public TrieNode() {
        this.sentence = null;
        this.children = new TrieNode[128];
        this.hotSentences = new ArrayList<TrieNode>();
        this.times = 0;
    }
    
    public int compareTo(TrieNode trieNode) {
        if (this.times == trieNode.times) {
            return this.sentence.compareTo(trieNode.sentence);
        }
        
        return trieNode.times - this.times; // des high -> low
    }
    
    public void update(TrieNode trieNode) {
        if (!this.hotSentences.contains(trieNode)) {
            this.hotSentences.add(trieNode);
        }
        Collections.sort(hotSentences);
        if (hotSentences.size() > 3) {
            hotSentences.remove(hotSentences.size() - 1);
        }
    }
}

public class DesignSearchAutocompleteSystem_642 {
    class AutocompleteSystem {
        private TrieNode root;
        private TrieNode curr;
        private StringBuilder sb; // how many chars are put
        
        public AutocompleteSystem(String[] sentences, int[] times) {
            this.root = new TrieNode();
            this.curr = this.root;
            sb = new StringBuilder();
            
            for (int i = 0; i < times.length; i++) {
                add(sentences[i], times[i]);
            }
        }
        
        private void add(String sentence, int times) {
            TrieNode temp = this.root;
            List<TrieNode> tempTriNodeList = new ArrayList<TrieNode>();
            for (char c : sentence.toCharArray()) {
                if (temp.children[c] == null) {
                    temp.children[c] = new TrieNode();
                }
                temp = temp.children[c];
                tempTriNodeList.add(temp);
            }
            
            // temp now is the end char of this sentence
            temp.sentence = sentence;
            temp.times += times;
            
            for (TrieNode node : tempTriNodeList) {
                node.update(temp);
            }
        }
        
        public List<String> input(char c) {
            List<String> hotSentences = new ArrayList<>();
            if (c == '#') {
                add(this.sb.toString(), 1);
                this.sb = new StringBuilder();
                this.curr = this.root;
                return hotSentences;
            }
            
            this.sb.append(c);
            
            if (this.curr != null) {
                curr = curr.children[c];
            }
            if (this.curr == null) {
                return hotSentences;
            }
            
            for (TrieNode node : this.curr.hotSentences) {
                hotSentences.add(node.sentence);
            }
            return hotSentences;
        }
    }

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
}
