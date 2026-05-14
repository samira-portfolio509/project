package Model;


public class Exam {
    int exam_id;
    String exam_name;
    String exam_date;
    String exam_time ;
    public Exam(){};
    public Exam( String sub, String date,String time){
        exam_name = sub;
        exam_date = date; exam_time = time;
    }
    public int getExamId() {
        return exam_id;
    }

    public String getEsub(){
        return exam_name;
    }
    public String getEdate(){
        return exam_date;
    }
    public String getEtime(){
        return exam_time;
    }
    public void setid(int i){
        exam_id = i;
    }
    public void setEsub(String sub){
         exam_name = sub;
    }
    public void setEdate(String d){
         exam_date = d;
    }
    public void setEtime(String t){
         exam_time = t;
    }

}
