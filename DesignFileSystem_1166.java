package LeetCode;

import java.util.*;

public class DesignFileSystem_1166 {
    class FileSystem {
        
        Map<String, Integer> file = new HashMap<>();
        
        public FileSystem() {
            file.put("", -1);
        }
        
        public boolean create(String path, int value) {
            int index = path.lastIndexOf("/");
            String parent = path.substring(0, index);
            if (!file.containsKey(parent)) {
                return false;
            }
            return file.putIfAbsent(path, value) == null;
        }
        
        public int get(String path) {
            return file.getOrDefault(path, -1);
        }
    }
    
    
    class TrieNode {
        String name;
        int value;
        Map<String, TrieNode> children;
        
        TrieNode(String name, int value) {
            this.name = name;
            this.value = value;
            this.children = new HashMap<>();
        }
    }
    
    class FileSystem_I {
        private TrieNode root;
        
        public FileSystem_I() {
            this.root = new TrieNode("/", -1);
        }
        
        public boolean createPath(String path, int value) {
            String[] folders = path.split("/");
            
            TrieNode currNode = this.root;
            String name = folders[folders.length - 1];
            
            for (int i = 0; i < folders.length - 1; i++) {
                if (folders[i].equals("")) {
                    continue;
                }
                if (currNode.children.containsKey(folders[i])) {
                    currNode = currNode.children.get(folders[i]);
                } else {
                    return false;
                }
            }
            
            // check if the path exists
            if (currNode.children.containsKey(name)) {
                return false;
            }
            
            currNode.children.put(name, new TrieNode(name, value));
            return true;
        }
        
        public int get(String path) {
            String[] folders = path.split("/");
            TrieNode currNode = this.root;
            
            for (String folder : folders) {
                if (folder.equals("")) {
                    continue;
                }
                if (currNode.children.containsKey(folder)) {
                    currNode = currNode.children.get(folder);
                } else {
                    return -1;
                }
            }
            
            return currNode.value;
        }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
    }
}
