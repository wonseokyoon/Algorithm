import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class Solution {
static class FileInfo{
        String original;
        String head;
        int number;
        String tail;

        public FileInfo(String original, String head, int number, String tail) {
            this.original = original;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public String[] solution(String[] files) {

        ArrayList<FileInfo> fileInfos = new ArrayList<>();

        for(String file : files) {
            // 구간 구분
            String[] sections = splitSection(file);
            String head = sections[0];
            String number = sections[1];
            String tail = sections[2];

            System.out.println("head: " + head);
            System.out.println("number: " + number);
            System.out.println("tail: " + tail);

            fileInfos.add(new FileInfo(file, head, Integer.parseInt(number), tail));
        }

        // 정렬
        fileInfos = sortFiles(fileInfos);
        String[] answer = new String[fileInfos.size()];
        for(int i = 0; i < fileInfos.size(); i++) {
            answer[i] = fileInfos.get(i).original;
        }

        return answer;
    }

    private ArrayList<FileInfo> sortFiles(ArrayList<FileInfo> fileInfos) {

        Collections.sort(fileInfos, new Comparator<FileInfo>() {
            @Override
            public int compare(FileInfo o1, FileInfo o2) {
                // 1. 헤드 정렬
                int compare = o1.head.compareToIgnoreCase(o2.head);     // 대소문자 무시
                if(compare != 0){      // 양수: o1>o2, 음수: o1 < o2, 0: o1=o2
                    return compare;
                }
                // 2. 헤드가 같으면 number 정렬
                return Integer.compare(o1.number, o2.number);
            }
        });

        return fileInfos;
    }

    private String[] splitSection(String file) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        int i = 0;

        // Head
        for(; i < file.length(); i++) {
            char c = file.charAt(i);
            if(Character.isDigit(c)) break;
            head.append(c);
        }

        // Number
        for(; i < file.length(); i++) {
            char c = file.charAt(i);
            if(!Character.isDigit(c) || number.length() >= 5) break;
            number.append(c);
        }

        // Tail
        for(; i < file.length(); i++) {
            char c = file.charAt(i);
            tail.append(c);
        }

        return new String[]{head.toString(), number.toString(), tail.toString()};
    }
}