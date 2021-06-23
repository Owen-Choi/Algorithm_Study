package Java_Algorithms;

class Brute_Force {
    static int BF(String sentence, String pattern) {
        char[] patternChar = new char[pattern.length()];
        char[] sentenceChar = new char[sentence.length()];
        int i;
        for (i = 0; i < sentence.length(); i++) {
            sentenceChar[i] = sentence.charAt(i);
        }

        for (i = 0; i < pattern.length(); i++) {
            patternChar[i] = pattern.charAt(i);
        }
        int k = 0;
        int j = 0;
        int same = 0;
        for (i = 0; i < sentence.length(); i++) {
            same = 0;
            j = i;
            for (k = 0; k < pattern.length(); k++) {
                if(sentenceChar[j] == patternChar[k]){
                    same++;
                    j++;
                }
                else
                    break;
            }
            if(same == pattern.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence = "ABABABCACD";
        String Pattern = "ABC";
        int result = BF(sentence, Pattern);
        if(result != -1)
            System.out.println(result+1 + "번째에 패턴 존재");
        else
            System.out.println("패턴 없음");
    }
}
