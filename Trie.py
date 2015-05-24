class TrieNode:
    # Initialize your data structure here.
    def __init__(self,ch=' '):
        self.val=ch
        self.children={}

class Trie:
    def __init__(self):
        self.root = TrieNode()

    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        if len(word)>0:
            if ~self.root.children.has_key(word[0]):
                self.root.children[word[0]]=TrieNode(word[0])
                if len(word)>1:
                    self.root.children.insert(word[1:len(word)])
               
        

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    # def search(self, word):
        

    # @param {string} prefix
    # @return {boolean}
    # Returns if there is any word in the trie
    # that starts with the given prefix.
    # def startsWith(self, prefix):
        

# Your Trie object will be instantiated and called as such:
trie = Trie()
trie.insert("somestring")
trie.search("key")