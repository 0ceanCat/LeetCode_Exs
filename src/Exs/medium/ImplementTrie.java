package Exs.medium;

/**
 * @author wy
 * @date 2021/4/13 21:22
 */
// 208. 实现 Trie (前缀树)
public class ImplementTrie {
    static class Trie {
        boolean isEnd;
        Trie[] nodes;
        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            nodes = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie curr = this;
            Trie[] ns = nodes;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';

                if (ns[index] == null){
                    ns[word.charAt(i) - 'a'] = new Trie();
                }

                curr = ns[word.charAt(i) - 'a'];
                ns = curr.nodes;
            }
            curr.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie curr = this;
            for (Character c : word.toCharArray()) {
                curr = curr.nodes[c - 'a'];
                if (curr == null) return false;
            }
            return curr.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (Character c : prefix.toCharArray()) {
                curr = curr.nodes[c - 'a'];
                if (curr == null) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("words");
        trie.insert("word");
        System.out.println(trie.search("words"));
    }
}
