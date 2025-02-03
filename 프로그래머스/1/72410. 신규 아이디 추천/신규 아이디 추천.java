class Solution {
 public String solution(String new_id) {
        StringBuilder sb=new StringBuilder(new_id);

        // 1
        new_id= new_id.toLowerCase();
        System.out.println("1 :"+new_id);
        // 2
        new_id=new_id.replaceAll("[^a-z0-9-_.]","");
        System.out.println("2 :"+new_id);

        // 3
        while(new_id.contains("..")){
            new_id=new_id.replace("..",".");
            System.out.println("3 :"+new_id);
        }

        // 4
        while(new_id.startsWith(".") || new_id.endsWith(".")){
            if(new_id.startsWith(".")){
                new_id=new_id.substring(1);
            } else if (new_id.endsWith(".")) {
                new_id=new_id.substring(0,new_id.length()-1);
            }
        }
        System.out.println("4 :"+new_id);

        // 5
        if(new_id.isEmpty()){
            new_id="a";
        }
        System.out.println("5 :"+new_id);

        // 6
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            while(new_id.endsWith(".")){
                new_id=new_id.substring(0,new_id.length()-1);
            }
        }
        System.out.println("6 :"+new_id);
        //7
        if(new_id.length()<=2){
            char last=new_id.charAt(new_id.length()-1);
            while(new_id.length()<3){
                new_id+=last;
            }
        }
        return new_id;
    }
}