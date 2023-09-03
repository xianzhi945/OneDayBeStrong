class TextEditor {
    StringBuilder sb;
    int cur;

    public TextEditor() {
        sb=new StringBuilder();
        cur=0;
    }

    public void addText(String text) {
        sb.insert(cur,text);
        //sb=sb.substring(0,cur)+text+sb.substring(cur,sb.length());
        cur=cur+text.length();

    }

    public int deleteText(int k) {

        int res=Math.min(cur,k);
        sb.delete(cur-res,cur);
        //sb=sb.substring(0,cur-res)+sb.substring(cur,sb.length());
        cur-=res;
        return res;
    }

    public String cursorLeft(int k) {
        cur-=Math.min(cur,k);

        return sb.toString().substring(Math.max(0,cur-10),cur);

    }

    public String cursorRight(int k) {
        cur+=Math.min(sb.length()-cur,k);
        return sb.toString().substring(Math.max(0,cur-10),cur);
    }
}
