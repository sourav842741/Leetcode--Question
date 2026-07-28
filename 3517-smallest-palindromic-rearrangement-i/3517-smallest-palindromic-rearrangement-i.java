class Solution {
    public String smallestPalindrome(String s) {
        int size = s.length();
        StringBuilder finalAns = new StringBuilder();

        if(size%2 != 0 ){
            char[] storage = new char[(size-1)/2];
            char[] storageRev = new char[(size-1)/2];

            for(int i = 0 ; i < (size-1)/2 ; i++){
                storage[i] = s.charAt(i);
                storageRev[i] = s.charAt(size - i - 1);
            }

            Arrays.sort(storage);
            Arrays.sort(storageRev);

            char middle = s.charAt((size)/2);

            for(int i = 0 ; i < (size-1)/2 ; i++){
                finalAns.append(storage[i]);
            }
            finalAns.append(middle);
            for(int i = 0 ; i < (size-1)/2 ; i++){
                finalAns.append(storageRev[(size-1)/2 - i - 1]);
            }
        }
        else{
            char[] storage = new char[(size)/2];
            char[] storageRev = new char[(size)/2];

            for(int i = 0 ; i < (size)/2 ; i++){
                storage[i] = s.charAt(i);
                storageRev[i] = s.charAt(size - i - 1);
            }

            Arrays.sort(storage);
            Arrays.sort(storageRev);

            for(int i = 0 ; i < size/2 ; i++){
                finalAns.append(storage[i]);
            }
            for(int i = 0 ; i < size/2 ; i++){
                finalAns.append(storageRev[(size)/2 - i - 1]);
            }
        }
        String result = finalAns.toString();
        return result;
    }
}