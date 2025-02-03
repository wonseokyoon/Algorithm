class Solution {
 public String solution(String new_id) {

        String s=new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .lessThan16()
                .moreThan2()
                .toStirng();
        return s;
    }
    private static class KAKAOID{
        private String s;

        KAKAOID(String s){
            this.s=s;
        }
        // 1
        private KAKAOID replaceToLowerCase(){
            s=s.toLowerCase();
            return this;
        }
        // 2
        public KAKAOID filter() {
            s=s.replaceAll("[^a-z0-9-_.]","");
            return this;
        }
        // 3
        public KAKAOID toSingleDot() {
            s=s.replaceAll("[.]{2,}",".");
            return this;
        }
        // 4
        public KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$","");
            return this;
        }
        // 5
        public KAKAOID noBlank() {
            s=s.isBlank()?"a":s;
            return this;
        }

        public KAKAOID lessThan16() {
            s=s.length()<=15?s:s.substring(0,15);
            s=s.replaceAll("[.]$","");
            return this;
        }

        public KAKAOID moreThan2() {
            while(s.length()<3){
                char last=s.charAt(s.length()-1);
                s+=last;
            }
            return this;
        }

        public String toStirng(){
            return s;
        }
    }
}