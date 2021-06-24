package Java_Algorithms;

class KMP {
    static boolean kmp(String Sentence, String Pattern){
        int SP = 1;     //Sentence Pointer
        int PP = 0;     //Pattern Pointer
        int[] skip = new int[Pattern.length() + 1];

        //skip 배열 만들기
        skip[SP] =1;
        while(SP != Pattern.length()){
            if(Pattern.charAt(SP) == Pattern.charAt(PP))
                skip[++SP] = ++PP;          //skip[++SP]인 이유는 ++PP가 1이 되면 2번째 인덱스로 스킵이 되기 때문
            else if(PP == 0)
                skip[++SP] = PP;
            else
                PP = skip[PP];
        }
        SP = PP = 0;
        // kmp 검색
        while(SP != Sentence.length() && PP != Pattern.length()){
            if(Sentence.charAt(SP) == Pattern.charAt(PP)){
                SP++;
                PP++;
            }
            else if(PP == 0)
                SP++;
            else
                PP = skip[PP];
        }
        return (PP == Pattern.length()) ? true : false;
    }

    public static void main(String[] args) {
        boolean result = kmp("ABCABABCABD", "ABCABD");
        System.out.println(result);
    }
}
