package Java_Algorithms;

class Boyer_Moore {
    static boolean BM(String Sentence, String Pattern){
        int[] skip = new int[Character.MAX_VALUE + 1];
        int i;
        for(i=0; i<=Character.MAX_VALUE; i++){
            skip[i] = Pattern.length();
        }
        for(i=0; i<Pattern.length()-1; i++){
            // 이렇게도 쓸 수 있구나...
            skip[Pattern.charAt(i)] = Pattern.length() - i - 1;
        }
        int SP,PP;
        SP = Pattern.length() - 1;
        // 패턴에 문자가 있는지 먼저 검사, 있다면 패턴을 얼만큼 옮길지 결정
        while(SP < Sentence.length()){
            PP = Pattern.length() - 1;
            while(Sentence.charAt(SP) == Pattern.charAt(PP)){
                if(PP == 0)
                    return true;
                SP--;
                PP--;
            }
            SP += Math.max(skip[Sentence.charAt(SP)], Pattern.length() - PP);
            // 위와 같이 비교하는 이유는 skip[Sentence.charAt(SP)]가 0일 수도 있기 때문이다.
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(BM("ABCXDEZCABACABAC", "ABAC"));
    }
}
