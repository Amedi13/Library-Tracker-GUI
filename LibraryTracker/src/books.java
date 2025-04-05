public class books {

    //book attributes
    private String author;
    private String title;
    private String status;

    // constructor
    public books(String author, String title, String status) {
        this.author = author; 
        this.title = title; 
        this.status = status; 
    }

    // getters and setter methods 
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;  
    }

    public String getTitle(){
        return title;  
    }

    public void setTitle(String title){
        this.title = title;  
    }

    public String getStatus(){
        return status;
    }

    public  void setStatus(String status){
        this.status = status; 
    }
}
