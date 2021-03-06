import java.util.*;

public class Solution {
	int beg = 0, end = 0, width = 0;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String> ();
        int n = words.length;
        while(end < n) {
            String word = words[end];
            int newWidth = width;
            if(width != 0) newWidth += 1;
            newWidth += word.length();
            if(newWidth > maxWidth) {
                res.add(justifyRow(words, maxWidth));
                beg = end;
                newWidth = word.length();
            }
            width = newWidth;
            end++;
        }
        if(beg < n) res.add(justifyLastRow(words, maxWidth));
        return res;
    }
    public String justifyRow(String[] words, int maxWidth) {
        int wordCnt = end - beg, spaceSlotCnt = wordCnt - 1;
        if(spaceSlotCnt == 0) return words[beg]+spaces(maxWidth-words[beg].length());
        int extraSpaceTotal = maxWidth - width;
        int extraSpacePerSlot = extraSpaceTotal / spaceSlotCnt;
        int extraSpaceSlotCnt = extraSpaceTotal % spaceSlotCnt;
        String[] spaceSlots = new String[spaceSlotCnt];
        for(int i = 0; i < extraSpaceSlotCnt; i++) {
            spaceSlots[i] = spaces(extraSpacePerSlot + 2);
        }
        for(int i = extraSpaceSlotCnt; i < spaceSlotCnt; i++) {
            spaceSlots[i] = spaces(extraSpacePerSlot + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < spaceSlotCnt; i++) {
            sb.append(words[beg+i]);
            sb.append(spaceSlots[i]);
        }
        sb.append(words[end-1]);
        return sb.toString();
    }
    public String justifyLastRow(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[beg++]);
        while(beg < end) {
            sb.append(" ");
            sb.append(words[beg++]);
        }
        int rowCnt = sb.length();
        while(rowCnt < maxWidth) {
        	sb.append(" ");
        	rowCnt++;
        }
        return sb.toString();
    }
    public String spaces(int len) {
        char[] chars = new char[len];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }
}