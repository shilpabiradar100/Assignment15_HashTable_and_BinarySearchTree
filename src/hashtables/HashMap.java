package hashtables;

public class HashMap {
    HashLinkedList[] buckets;

    public HashMap()
    {
        buckets = new HashLinkedList[20];
    }
    /**
     * Method to count frequency of word in given string
     */
    public void countOfOccurance()
    {
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");
        for ( String word : words)
        {
            put(word,1);
        }
        int frequency = get("be");
        System.out.println("Freequency of given key is "+frequency);
    }
    /**
     * Method to map key,value pair on the hashmap
     * @param key
     * @param value
     */
    public void put(String key,Integer value)
    {
        int bucketIndex = computeBucketIndex(key);
        HashLinkedList foundLinkedList = buckets[bucketIndex];
        if(foundLinkedList != null)
        {
            HashNode foundNode = foundLinkedList.search(key);
            if(foundNode != null)
            {
                foundNode.value += value;
            }
            else {
                foundLinkedList.add(key, value);
            }
        }
        else
        {
            HashLinkedList newLinkedList = new HashLinkedList();
            newLinkedList.add(key,value);
            buckets[bucketIndex] = newLinkedList;
        }
    }
    /**
     * Method to retrieve the value mapped by particular key in hashtable
     * @param key
     * @return
     */
    public int get(String key)
    {
        int bucketIndex = computeBucketIndex(key);
        HashLinkedList foundLinkedList = buckets[bucketIndex];
        if(foundLinkedList != null)
        {
            HashNode foundNode = foundLinkedList.search(key);
            return  foundNode.value;
        }
        return 0;
    }
    /**
     * hashcode method to get index
     * @param key
     * @return
     */

    private int computeBucketIndex(String key) {
        int hashCode = Math.abs(key.hashCode());
        int bucketIndex = hashCode % buckets.length;
        return bucketIndex;
    }

}
